import java.util.*;
import java.io.*;
import java.math.BigInteger;

class RSA{
	int bitlength = 1024;
	BigInteger a;
	BigInteger b;
	BigInteger n;
	BigInteger phi;
	BigInteger e;
	BigInteger d;


	RSA() {
      		Random r=new Random();
		a=BigInteger.probablePrime(bitlength,r);
		b=BigInteger.probablePrime(bitlength,r);
		n=a.multiply(b);
		phi=a.subtract(BigInteger.ONE).multiply(b.subtract(BigInteger.ONE));
		e=BigInteger.probablePrime(bitlength/2,r);
		
		while((phi.gcd(e).compareTo(BigInteger.ONE)>0) && (e.compareTo(phi)<0));
		{
			e.add(BigInteger.ONE);
		}

		d=e.modInverse(phi);
		}
       
     


	public static void main(String[] args)
	{
		RSA R=new RSA();
		Scanner in=new Scanner(System.in);
		System.out.println("Enter a plain text");
		String textString=in.nextLine();
		System.out.println("Entered plain text is  "+ textString);	
		System.out.println("Encrypting message =" + textString);
		System.out.println("Plain text in bytes=" + bytesToString(textString.getBytes()));
		byte[] encrypted=R.encrypt(textString.getBytes());
		byte[] decrypted=R.decrypt(encrypted);
		System.out.println("Decrypted byte="+ bytesToString(decrypted));
		System.out.println("Decrypted string=" + new String(decrypted));
		
	}



	private static String bytesToString(byte[] encrypted)
	{
		String test=" ";
		for(byte b: encrypted)
		{
			 test=test+Byte.toString(b);
		}
		return test;
	}


	public byte[] encrypt(byte[] message)
	{
		return  new BigInteger(message).modPow(e,n).toByteArray() ;
	}


	public byte[] decrypt(byte[] message)
	{
		return  new BigInteger(message).modPow(d,n).toByteArray() ;
	}			 


}
