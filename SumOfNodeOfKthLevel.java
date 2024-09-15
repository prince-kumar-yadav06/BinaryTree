package BinaryTree;
import java.util.*;
public class SumOfNodeOfKthLevel{
   static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static int SumOFNode(TreeNode root,int K){

        //base case
        if(root == null){
            return -1;
        }

        Queue<TreeNode> Q=new LinkedList<>();

        Q.add(root);
        Q.add(null);
        int sum=0;

        while(K >0 && (!Q.isEmpty()) ){
            TreeNode curr=Q.remove();
            if(curr != null){
                sum=sum + curr.data;
                if(curr.left !=null){
                    Q.add(curr.left);
                }
                if(curr.right != null){
                    Q.add(curr.right);
                }
            }
            else{
                Q.add(curr);
                K=K-1;
            }
        }
        return sum;
    }

    public static void main(String args[]){
         
        TreeNode T=new TreeNode(1);
        T.left=new TreeNode(2);
        T.right=new TreeNode(3);
        T.left.left=new TreeNode(4);
        T.left.right=new TreeNode(5);
        T.right.left=new TreeNode(6);

        int k=3;

        System.out.println(SumOFNode(T, k));
    }
}