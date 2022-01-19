import java.net.*;
import java.util.*;
class UDPClient{
	public static void main (String args[]) throws Exception{
		DatagramSocket ds=new DatagramSocket();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the message to be sent   :  ");
		String str=sc.nextLine();

		byte b[]=new byte[1024];
		b = str.getBytes();

		InetAddress ia=InetAddress.getByName("localhost");
		DatagramPacket dp=new DatagramPacket(b,b.length,ia,7777);
		ds.send(dp);

		byte r[]=new byte[1024];
		DatagramPacket dp1=new DatagramPacket(r,r.length);
		ds.receive(dp1);
		String str1=new String(dp1.getData());
		System.out.print("Message from server:   :  "+str1); 
		ds.close();
         }
}
