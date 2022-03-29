import java.util.*;
import java.io.*;
import java.net.*;
class UDPserver{
    public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);
        DatagramSocket ds=new DatagramSocket(6000);
        byte receive[]=new byte[1024];
        DatagramPacket dp=new DatagramPacket(receive,receive.length);
        ds.receive(dp);
        String msg=new String(dp.getData());
        System.out.println(msg);
        System.out.println("Enter the msg to send");
        String msg1=sc.nextLine();
        byte send[]=new byte[1024];
        send=msg1.getBytes();
        InetAddress ia=dp.getAddress();
        int portNo=dp.getPort();
        DatagramPacket dp1=new DatagramPacket(send,send.length,ia,portNo);
        ds.send(dp1);
    }
}