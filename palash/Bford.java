
import java.util.*;
class Bford{
    int nv;
    int dist[];
    Bford(int n){
        nv=n;
        dist=new int[n+1];
    }
    void shortestPath(int source,int arr[][]){
        for(int i=1;i<=nv;i++){
            dist[i]=999;
        }
        dist[source]=0;
        for(int i=1;i<=nv-1;i++){
            for(int snode=1;snode<=nv;snode++){
                for(int dnode=1;dnode<=nv;dnode++){
                    if(arr[snode][dnode]!=99){
                        if(dist[dnode]>dist[snode]+arr[snode][dnode]){
                            dist[dnode]=dist[snode]+arr[snode][dnode];
                        }
                    }
                }
            }
	}
         	for(int snode=1;snode<=nv;snode++){
                for(int dnode=1;dnode<=nv;dnode++){
                    if(arr[snode][dnode]!=99){
                        if(dist[dnode]>dist[snode]+arr[snode][dnode]){
                            System.out.println("The graph has negative cycle");
                        }
                    }
                }
            }
		for(int i=1;i<=nv;i++){
            	System.out.println("The shortest path from "+source+" to destination "+i+" is "+dist[i]);
        }
        }
        
    
    
    
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n=sc.nextInt();
        int arr[][]=new int[n+1][n+1];
        System.out.println("Enter the cost matrix");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("Adjacency matrix is");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Enter the source node");
        int source=sc.nextInt();
        Bford b1=new Bford(n);
        b1.shortestPath(source,arr);
    }
}