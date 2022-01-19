import java.net.*;
import java.util.*;
class UDPServer {
	public static void main(String args[]) throws Exception {


		DatagramSocket ds = new DatagramSocket(7777);
		System.out.println("server started.....");
		byte r[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(r, r.length);
		ds.receive(dp);
		String str = new String(dp.getData());
		System.out.println("Message from client   : " + str);

		//  System.out.print("server replying to client");
		InetAddress ca = dp.getAddress();
		int port = dp.getPort();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string  :  ");
		String str1 = sc.nextLine();
		byte send[] = new byte[1024];
		send = str1.getBytes();
		DatagramPacket dp1 = new DatagramPacket(send, send.length, ca, port);
		ds.send(dp1);
		ds.close();
	}
}
