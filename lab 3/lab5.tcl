# This script is created by NSG2 beta1
# <http://wushoupong.googlepages.com/nsg>

#===================================
#     Simulation parameters setup
#===================================
set val(stop)   70.0                         ;# time of simulation end

#===================================
#        Initialization        
#===================================
#Create a ns simulator
set ns [new Simulator]

#Open the NS trace file
set tracefile [open 1lab1.tr w]
$ns trace-all $tracefile

#Open the NAM trace file
set namfile [open 1lab1.nam w]
$ns namtrace-all $namfile

#===================================
#        Nodes Definition        
#===================================
#Create 6 nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]

#===================================
#        Links Definition        
#===================================
#Createlinks between nodes
$ns duplex-link $n4 $n5 100.0Mb 10ms DropTail
$ns queue-limit $n4 $n5 50
$ns make-lan "$n0 $n1 $n2 $n3 $n4" 100Mb 10ms LL Queue/DropTail Mac/802_3

#Give node position (for NAM)
$ns duplex-link-op $n4 $n5 orient right

#===================================
#        Agents Definition        
#===================================
#Setup a TCP connection
set tcp0 [new Agent/TCP]
$ns attach-agent $n0 $tcp0
set sink3 [new Agent/TCPSink]
$ns attach-agent $n3 $sink3
$ns connect $tcp0 $sink3
$tcp0 set packetSize_ 1500

#Setup a TCP connection
set tcp1 [new Agent/TCP]
$ns attach-agent $n2 $tcp1
set sink4 [new Agent/TCPSink]
$ns attach-agent $n5 $sink4
$ns connect $tcp1 $sink4
$tcp1 set packetSize_ 1500


#===================================
#        Applications Definition        
#===================================
#Setup a FTP Application over TCP connection
set ftp0 [new Application/FTP]
$ftp0 attach-agent $tcp0
$ns at 1.0 "$ftp0 start"
$ns at 2.0 "$ftp0 stop"

#Setup a FTP Application over TCP connection
set ftp1 [new Application/FTP]
$ftp1 attach-agent $tcp1
$ns at 1.0 "$ftp1 start"
$ns at 2.0 "$ftp1 stop"
set file1 [open file1.tr w]
$tcp0 attach $file1
$tcp0 trace cwnd_
set file2 [open file2.tr w]
$tcp1 attach $file2
$tcp1 trace cwnd_


#===================================
#        Termination        
#===================================
#Define a 'finish' procedure
proc finish {} {
    global ns tracefile namfile
    $ns flush-trace
    close $tracefile
    close $namfile
    exec nam 1lab1.nam &
    exit 0
}
$ns at 0.1 "$ftp0 start"
$ns at 1 "$ftp0 stop"
$ns at 2 "$ftp0 start"
$ns at 5 "$ftp0 stop"
$ns at 6 "$ftp1 start"
$ns at 8 "$ftp1 stop"
$ns at 9 "$ftp1 start"
$ns at 10 "$ftp1 stop"

$ns at $val(stop) "$ns nam-end-wireless $val(stop)"
$ns at $val(stop) "finish"
$ns at $val(stop) "puts \"done\" ; $ns halt"
$ns run
