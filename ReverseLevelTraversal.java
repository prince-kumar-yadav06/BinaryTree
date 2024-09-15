package BinaryTree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelTraversal {

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
    public static ArrayList<Integer> RevLevel(TreeNode root){

        //base case
      ArrayList<Integer> arr =new ArrayList<>();
      Deque<TreeNode> Q=new ArrayDeque<>();

      Q.addFirst(root);
      while(!Q.isEmpty()){
        TreeNode curr=Q.remove();
        if(curr.right != null){
            Q.add( curr.right );
        }
        if(curr.left != null){
            Q.add(curr.left);
        }
        arr.add(curr.data);
      }
       return arr;

      
    
    }
    public static void main(String args[]){

        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);

       ArrayList rev= RevLevel(t);

       for(int i=0;i<rev.size();i++){
        System.out.println(rev.get(i));
       }
    }
}
