package BinaryTree;
import java.util.*;
public class TransformSumTree {
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

    public static int TreeTransform(TreeNode root){

        if (root == null){
            return 0;
        }

        int old_value=root.data;  //store old value before change

        int left_value=TreeTransform(root.left);
        int right_value=TreeTransform(root.right);

        root.data=left_value + right_value;

        return root.data + old_value;

    }
    public static void main(String args[]){
        TreeNode t=new TreeNode(10);
        t.left=new TreeNode(-2);
        t.right=new TreeNode(6);
        t.left.left=new TreeNode(8);
        t.left.right=new TreeNode(-4);
        t.right.left=new TreeNode(7);
        t.right.right=new TreeNode(5);

        TreeTransform(t);

        System.out.println(t.right.data);

    }
}
