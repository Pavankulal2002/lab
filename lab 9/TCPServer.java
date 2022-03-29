import java.net.*;
import java.io.*;

class TCPServer{
	public static void main(String args[])throws IOException{
		ServerSocket Sc=new ServerSocket(4000);
		System.out.println("Server is ready for connection");

		Socket S=Sc.accept();
		System.out.println("connection successfull");
		
		InputStreamReader in=new InputStreamReader(S.getInputStream());
		BufferedReader br=new BufferedReader(in);
		String str=br.readLine();
		FileReader fr=new FileReader(str);
		PrintWriter pr=new PrintWriter(S.getOutputStream());
	
		int i;
		while((i=fr.read())!=-1)
			{
			pr.println((char)i);
		    pr.flush();
			}
		S.close();
	}
 
}

