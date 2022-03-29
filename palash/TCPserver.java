import java.util.*;
import java.io.*;
import java.net.*;
class TCPserver{
    public static void main(String args[])throws IOException{
        ServerSocket ss=new ServerSocket(6000);
        Socket s=ss.accept();
        System.out.println("Client connected successfully!");
        InputStreamReader in=new InputStreamReader(s.getInputStream());
        BufferedReader br=new BufferedReader(in);
        String str=br.readLine();
        System.out.println("Client requested "+str);
        PrintWriter pw=new PrintWriter(s.getOutputStream());
        FileReader fr=new FileReader(str);
        int a;
        while((a=fr.read())!=-1){
            pw.println((char)a);
            pw.flush();
        }
s.close();
    }
}