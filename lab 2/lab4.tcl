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
set tracefile [open lab4.tr w]
$ns trace-all $tracefile

#Open the NAM trace file
set namfile [open lab4.nam w]
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
$ns duplex-link $n0 $n2 50.0Mb 10ms DropTail
$ns queue-limit $n0 $n2 10
$ns duplex-link $n2 $n4 5.0Mb 10ms DropTail
$ns queue-limit $n2 $n4 1
$ns duplex-link $n1 $n2 50.0Mb 10ms DropTail
$ns queue-limit $n1 $n2 5
$ns duplex-link $n2 $n3 5.0Mb 10ms DropTail
$ns queue-limit $n2 $n3 1
$ns duplex-link $n2 $n5 5.0Mb 10ms DropTail
$ns queue-limit $n2 $n5 1

#Give node position (for NAM)
$ns duplex-link-op $n0 $n2 orient right-down
$ns duplex-link-op $n2 $n4 orient right-down
$ns duplex-link-op $n1 $n2 orient right-up
$ns duplex-link-op $n2 $n3 orient right-up
$ns duplex-link-op $n2 $n5 orient right-down

#===================================
#        Agents Definition        
#===================================
#Setup a TCP connection
set p0 [new Agent/Ping]
$ns attach-agent $n0 $p0
set p4 [new Agent/Ping]
$ns attach-agent $n4 $p4
$ns connect $p0 $p4
$p0 set packetSize_ 1500

#Setup a TCP connection
set p1 [new Agent/Ping]
$ns attach-agent $n1 $p1
set p3 [new Agent/Ping]
$ns attach-agent $n3 $p3
$ns connect $p1 $p3
$p1 set packetSize_ 1500

Agent/Ping instproc recv {from rtt} {
$self instvar node_
puts "node[$node_ id] recieved answer from $from with round trip time $rtt msec"
}

#===================================
#        Applications Definition        
#===================================

#===================================
#        Termination        
#===================================
#Define a 'finish' procedure
proc finish {} {
    global ns tracefile namfile
    $ns flush-trace
    close $tracefile
    close $namfile
    exec nam lab4.nam &
    exit 0
}
$ns at 0.1 "$p0 send"
$ns at 0.2 "$p0 send"
$ns at 0.3 "$p0 send"
$ns at 0.4 "$p0 send"
$ns at 0.5 "$p0 send"
$ns at 0.6 "$p0 send"
$ns at 0.7 "$p0 send"
$ns at 0.8 "$p0 send"
$ns at 0.9 "$p0 send"
$ns at 1.0 "$p0 send"
$ns at 0.1 "$p1 send"
$ns at 0.2 "$p1 send"
$ns at 0.3 "$p1 send"
$ns at 0.4 "$p1 send"
$ns at 0.5 "$p1 send"
$ns at 0.6 "$p1 send"
$ns at 0.7 "$p1 send"
$ns at 0.8 "$p1 send"
$ns at 0.9 "$p1 send"
$ns at 1.0 "$p1 send"
$ns at $val(stop) "$ns nam-end-wireless $val(stop)"
$ns at $val(stop) "finish"
$ns at $val(stop) "puts \"done\" ; $ns halt"
$ns run
