import java.util.*;
import java.io.*;
import java.net.*;
class UDPclient{
    public static void main(String args[])throws Exception{
        DatagramSocket ds=new DatagramSocket();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the message to send ");
        String msg=sc.nextLine();
        byte send[]=new byte[1024];
        send=msg.getBytes();
        InetAddress ia=InetAddress.getByName("localhost");
        DatagramPacket dp=new DatagramPacket(send,send.length,ia,6000);
        ds.send(dp);
         byte receive[]=new byte[1024];
        DatagramPacket dp1=new DatagramPacket(receive,receive.length);
        ds.receive(dp1);
        String msg1=new String(dp1.getData());
        System.out.println(msg1);
    }
}