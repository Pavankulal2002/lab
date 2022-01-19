import java.util.*;

class crc
{
	public static void main(String[] args)
	{
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter data");
		String data= scan.nextLine();
		System.out.println("Enter CRC GENERATOR");
		String gen=scan.nextLine();
		String code=data;
		while(code.length()<data.length()+gen.length()-1)
		{
			code=code+"0";
		}
	//	System.out.println("DATA\t\t"+data);
	//	System.out.println("GENERATOR\t"+gen);
	//	System.out.println("CODE\t\t"+code);
		code=data + div(code,gen);
		System.out.println("Transmitted code from sender is "+code);	
		System.out.println("Enter the recieved code");
		String recv=scan.next();
		if(Integer.parseInt(div(recv,gen))==0)
			System.out.println("The recieved code has no error");
		else 
 			System.out.println("The recieved code has error");


	}


	static String div(String num1,String num2)
	{
		int pointer =num2.length();
		String result=num1.substring(0,pointer);
 		String remainder="";
		for(int i=0;i<num2.length();i++)
		{
 			if(num2.charAt(i)==result.charAt(i))
			{
  			  remainder=remainder+"0";
			}
 			 else
			{
   			  remainder=remainder+"1";
			}
 		}

		while(pointer<num1.length())
		{
 			if(remainder.charAt(0)=='0')
			{
 				remainder=remainder.substring(1,remainder.length());
 				remainder=remainder+String.valueOf(num1.charAt(pointer));
				pointer++;
			}
			result=remainder;
			remainder="";
			if(result.charAt(0)=='0')
				remainder =result;

			else
			{
			for(int i=0;i<num2.length();i++)
			{
 				if(num2.charAt(i)==result.charAt(i))
 				{
 					remainder=remainder+"0";
				}
				else
				{
 					remainder=remainder+"1";	
 				}
			}	 
			}
		}
		return remainder.substring(1,remainder.length());

	}
}



