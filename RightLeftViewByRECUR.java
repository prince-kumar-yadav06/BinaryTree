package BinaryTree;
import java.util.*;
public class RightLeftViewByRECUR {
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

    public static List<Integer> Sol(TreeNode root){

        //base case
        List<Integer> result=new ArrayList<Integer>();
        rightview(root,result,0);
        return result;
    }

    public static void rightview(TreeNode curr,List<Integer> result,int level){

        if(curr == null){
            return;
        }

        if(level == result.size()){
            result.add(curr.data);
        }
        rightview(curr.right,result,level+1); //recursion call for right
        rightview(curr.left,result,level+1);  //recursion call for left
    }
    public static void main(String args[]){

        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        // t.right=new TreeNode(3);
        // t.right.left=new TreeNode(6);
        // t.right.right=new TreeNode(7);
        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(5);
        t.left.left.right=new TreeNode(8);


        List<Integer> ans=Sol(t);

        if(ans.size() <0){
            System.out.println("Left view Not possible");
        }

        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}
