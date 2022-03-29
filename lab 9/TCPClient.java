import java.net.*;
import java.io.*;
import java.util.*;

class TCPClient{

	public static void main(String args[])throws IOException{
		Socket S=new Socket("localhost",4000);
		Scanner Sc=new Scanner(System.in);
		System.out.println("enter your file name");
		String n=Sc.nextLine();

		PrintWriter pr=new PrintWriter(S.getOutputStream());
		pr.println(n);
		pr.flush();


		InputStreamReader in=new InputStreamReader(S.getInputStream());
		BufferedReader br=new BufferedReader(in);


		System.out.println("from server  :  ");
		String str;
		while((str=br.readLine())!=null)
		//while(true)
		{
			//str=br.readLine();
			//if((Integer.parseInt(str))==-1)
			//break;
			//int temp=Integer.parseInt(str);
  			System.out.print(str);
		}

	S.close();
}
}

