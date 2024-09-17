import java.util.*;

public class DaigonalTraversal {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class Node{
        int i;
        int val;

        Node(int i,int val){
            this.i=i;
            this.val=val;
        }
    }
   
 static  ArrayList<Integer> arr=new ArrayList<Integer>();

    public static void FindDiaNode(TreeNode root, Map<Integer,ArrayList<Integer>> mp ,int i){

        if(root == null){
            return;
        }
        ArrayList<Integer> temp=mp.getOrDefault(i, new ArrayList<>());
        temp.add(root.data);
        mp.put(i,temp);


        FindDiaNode(root.left, mp, i+1);
        FindDiaNode(root.right, mp, i);
    }
    public static Map<Integer,ArrayList<Integer>> Daigonal(TreeNode root){


        Map<Integer,ArrayList<Integer>> mp=new HashMap<Integer,ArrayList<Integer>>();
       
        FindDiaNode(root,mp,0);

        return mp;
        
    }
    public static void main(String args[]){

        TreeNode T=new TreeNode(8);
        T.left=new TreeNode(3);
        T.right=new TreeNode(10);
        T.left.left=new TreeNode(1);
        T.right.left=new TreeNode(6);
        T.right.right=new TreeNode(14);
        T.right.left.left=new TreeNode(4);
        T.right.left.right=new TreeNode(7);
        T.right.right.left=new TreeNode(13);

        Map<Integer,ArrayList<Integer>> res=Daigonal(T);
        
        for(Map.Entry<Integer,ArrayList<Integer>> entry : res.entrySet()){
            System.out.println(entry.getKey() +":"+ entry.getValue());
        }

    }
}
