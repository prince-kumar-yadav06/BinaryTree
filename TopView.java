import java.util.*;
public class TopVeiw {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    //pair for Horizontal Distance and value
    static class Pair{
        TreeNode root;
        int value;

        Pair(TreeNode root,int v){
            this.root=root;
            this.value=v;
        }
    } 


    public static Map<Integer,Integer> Topveiw(TreeNode root){

        Map<Integer,Integer> map=new HashMap<>();
        if(root == null){
            return map;
        }

        Queue<Pair> Q=new LinkedList();
        Q.add(new Pair(root,0));

        while(!Q.isEmpty()){

            Pair curr=Q.remove();  //store Q first pair

            TreeNode temp=curr.root;  // store root from pair
            int hd=curr.value;   // store horizontal value from pair

            // if(map.get(hd)== null){  //map me hd pr phle se koi value nhi hai to add that
                map.put(hd,temp.data);
            // }

            if(temp.left != null){
                Q.add(new Pair(temp.left, hd-1)); //root ka left null nhi hai to Q me add kr denge 
                                                    //aur hd-1 hoga left ke liye
            }
            
            if(temp.right != null){
                Q.add(new Pair(temp.right,hd+1));  // root,right not null add in Q and hd+1

            }
        }
        return map;
    }
public static void main(String args[]){


    TreeNode t=new TreeNode(1);
    t.left=new TreeNode(2);
    t.right=new TreeNode(3);
    t.left.left=new TreeNode(4);
    t.left.right=new TreeNode(5);
    t.right.left=new TreeNode(6);
    t.right.right=new TreeNode(7);

    Map<Integer,Integer> result=Topveiw(t);

    // sort the by key using TreeMap 
    Map<Integer,Integer> sort=new TreeMap<>(result);

    for(Map.Entry<Integer,Integer> entry : sort.entrySet()){
        System.out.println(entry.getValue());
    }
}
}
