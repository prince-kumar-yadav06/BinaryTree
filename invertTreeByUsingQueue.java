package BinaryTree;
import java.util.*;
public class invertTreeByUsingQueue {
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

    public static TreeNode sol(TreeNode root){
      
        Queue<TreeNode> Q=new LinkedList();
        Q.add(root);

        while(!Q.isEmpty()){
            TreeNode curr=Q.remove();
            if(curr.left != null){
                Q.add(curr.left);
            }
            if(curr.right != null){
                Q.add(curr.right);
            }

            //swap left and right not null
            // if(curr.left !=null && curr.right != null){
                TreeNode temp=curr.left;
                curr.left=curr.right;
                curr.right=temp;
            // }

            //swap when left ==null and right not
        //  else if(curr.left == null && curr.right != null){
        //         int temp=curr.right.data;
        //         curr.right=null;
        //         curr.left=new TreeNode(temp);
        //     }
        //     //swap when right == null and left != null
        //   else  if(curr.left != null && curr.right == null){
        //         int temp=curr.left.data;
        //         curr.left=null;
        //         curr.right=new TreeNode(temp);
            }
            return root;
        }
    
    public static void main(String args[]){

        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(5);
        t.right.right=new TreeNode(6);
      //  t.right.right=new TreeNode(9);



        TreeNode ans=sol(t);
        System.out.println(ans.left.right.data);
}
}