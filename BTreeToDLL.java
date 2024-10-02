import java.util.*;

public class BTreeToDLL {
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

    static TreeNode head=null;
    static TreeNode prev=null;
    public static TreeNode BinaryTreeToDlL(TreeNode root){
        if(root ==null){
            return null;
        }
       

        BinaryTreeToDlL(root.left);

        if(prev == null){
            head=root;
        }

        else{
            root.left=prev;
            prev.right=root;
        }
        prev =root;
        BinaryTreeToDlL(root.right);

        return head;
    }

    public static void print(TreeNode root){
        while(root !=null){
            System.out.println(root.data+" ");
            root=root.right;
        }
    }
    public static void main(String args[]){

        TreeNode t=new TreeNode(10);
        t.left=new TreeNode(12);
        t.right=new TreeNode(15);
        t.right.left=new TreeNode(36);
        t.left.left=new TreeNode(25);
        t.left.right=new TreeNode(30);

      TreeNode res=  BinaryTreeToDlL(t);


      print(res);
    }
}
