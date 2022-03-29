import java.util.*;
import java.io.*;
import java.net.*;
class TCPclient{
    public static void main(String args[])throws IOException{
        Socket s=new Socket("localhost",6000);
        PrintWriter pw=new PrintWriter(s.getOutputStream());
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the File name");
        String str=sc.next();
        pw.println(str);
        pw.flush();
        InputStreamReader in=new InputStreamReader(s.getInputStream());
        BufferedReader br=new BufferedReader(in);
        System.out.println("From server");
        while((str=br.readLine())!=null){
            System.out.print(str);
        }
	s.close();    }
}