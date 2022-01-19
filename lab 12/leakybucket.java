import java.util.*;
import java.io.*;
public class leakybucket{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the bucket size");
	int size=sc.nextInt();
	int a[]=new int[size];
	System.out.println("Enter the number of packets");
	int p=sc.nextInt();
	System.out.println("Enter the data");
	for(int i=0;i<p;i++)
	{	
		a[i]=sc.nextInt();
	}
	System.out.println("Enter output rate");
	int out=sc.nextInt();
	for(int i=0;i<p;i++){
		if(a[i]>size)
			System.out.println("Bucket overflow at "+ a[i]);
		else 	
			if(a[i]==out)
				System.out.println("data transmitted");
			else{
				while(a[i]!=0 && a[i]>out)
				{
					System.out.println("packet transmitted is"+out);
					a[i]=a[i]-out;
				}
				System.out.println("Packet transmitted"+a[i]);
				}
			}
		}
	}


