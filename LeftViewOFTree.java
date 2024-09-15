package BinaryTree;
import java.util.*;
public class LeftViewOFTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=left;
            this.right=right;

        }
    }

    public static int[] LeftView(TreeNode root,int N) {

        int arr[]=new int[N];  //store ans

        if(root == null){
            return arr;
        }
        
        int i=0;
        Queue<TreeNode> Q=new LinkedList();
        Q.add(root);
        int j=0;
         while(!Q.isEmpty()){
            
            TreeNode curr=Q.remove();
            arr[i++]=curr.data;

            if(curr.left != null){
                Q.add(curr.left);
            }

            else if(curr.left == null && curr.right != null){
                Q.add(curr.right);
            }
         }
         return arr;
    
}
    public static void main(String args[]){

        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.right.left=new TreeNode(6);
        t.right.right=new TreeNode(7);
        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(5);
        t.left.left.right=new TreeNode(8);



        int ans[]=LeftView(t, 4);

        if(ans.length <0){
            System.out.println("Left view Not possible");
        }

        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    
    }
    }