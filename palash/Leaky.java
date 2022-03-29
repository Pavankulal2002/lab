import java.util.*;
class Leaky{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Bucket size");
        int buck=sc.nextInt();
        System.out.println("Enter the output rate");
        int rate=sc.nextInt();
        System.out.println("Enter the number of packets");
        int num=sc.nextInt();
        int[] arr=new int[num];
        System.out.println("Enter the size of each packet");
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<num;i++){
            if(arr[i]>buck){
                System.out.println("Packet dropped");
            }
            else if(arr[i]<=rate){
                System.out.println("Packet "+arr[i]+" sent to network\nremaining bucket size="+(buck-arr[i]));
            }
            else if(arr[i]>rate){
                while(arr[i]>rate){
                    System.out.println("Packet "+rate+" sent to network");
                    arr[i]=arr[i]-rate;
                }
                System.out.println("Packet "+arr[i]+" sent to network");
            }
        }
    }
}