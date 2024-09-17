import java.util.*;
public class MinSwapToConvrtBTreeToBST {
    static class Pair{
        int first;
        int second;

        Pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }
    static ArrayList<Integer>  arrL=new ArrayList<>();

    public static void ConvrtBtToBST(int arr[],int Idx,int n){
        
        if(Idx >= n){
            return;
        }

        ConvrtBtToBST(arr,2*Idx+1,n);  //left node
        arrL.add(arr[Idx]);   //store root node value
        ConvrtBtToBST(arr, 2*Idx +2,n);  //for right node
    }

    public static int MinSwap(ArrayList<Integer> arr){
        
        int len=arr.size();

    ArrayList<Pair> vector=new ArrayList<Pair>();

        for(int i=0;i<arr.size();i++){
            vector.add(new Pair(arr.get(i),i));
        
        }
      
        vector.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1,Pair o2){
                return o1.first - o2.first;
            }
            
        });
        boolean vis[]=new boolean[len];

        Arrays.fill(vis,false);

        int countswap=0;

        for(int i=0;i<len;i++){
            if(vis[i]  || vector.get(i).second==i){
                continue;
            }
            else{
                int j=i;
                int cycle=0;

                while(!vis[j]){
                    vis[j]=true;

                    j=vector.get(j).second;
                    cycle++;
                }
                if(cycle > 0){
                    countswap += cycle-1;
                }
            }
        }
        return countswap;
    }


       

    public static void main(String args[]){
        int arr[]={1,2,3};

        ConvrtBtToBST(arr, 0,arr.length);
        
        System.out.println(MinSwap(arrL));

    }
}
