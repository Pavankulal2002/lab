import java.util.*;
class Crc{
    public static String div(String num1,String num2){
        int pointer=num2.length();
        String result=num1.substring(0,pointer);
        String remainder="";
        for(int i=0;i<num2.length();i++){
            if(result.charAt(i)==num2.charAt(i)){
                remainder+="0";
            }
            else{
                remainder+="1";
            }
        }
        while(pointer<num1.length()){
            if(remainder.charAt(0)=='0'){
            remainder=remainder.substring(1,remainder.length());
            remainder+=num1.charAt(pointer);
            pointer++;
        }
        result=remainder;
        remainder="";
        if(result.charAt(0)=='0'){
            remainder=result;
        }
        else{
            for(int i=0;i<num2.length();i++){
            if(result.charAt(i)==num2.charAt(i)){
                remainder+="0";
            }
            else{
                remainder+="1";
            }
        }
        }
        }
        
        return(remainder.substring(1,remainder.length()));
    }
    
    
    
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the data");
        String data=sc.next();
        System.out.println("Enter the CRC generator");
        String gen=sc.next();
        String code=data;
        while(code.length()<data.length()+gen.length()-1){
            code+="0";
        }
        code=data+div(code,gen);
        System.out.println("Transmitted code="+code+"\nEnter the Received code");
        String check=sc.next();
        if(Integer.parseInt(div(check,gen))==0){
            System.out.println("No error");
        }
        else{
            System.out.println("There is a error");
        }
    }
}