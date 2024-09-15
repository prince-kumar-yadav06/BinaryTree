package BinaryTree;
import java.util.*;
public class ZigzagTreeTraversal {
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

    public static List<Integer> Solution(TreeNode root){

        List<Integer> result=new ArrayList<>();
     if(root == null){
          return result;
        }

        boolean LeftTOright=true;
        Queue<TreeNode> Q=new LinkedList();

        Q.add(root);
     
        while(!Q.isEmpty()){

            int sz=Q.size();
            int ans[]=new int[sz];

            for(int i=0; i<sz;i++){
                TreeNode curr=Q.remove();

                int indx=(LeftTOright) ? i : sz-i-1;

                ans[indx]=curr.data;
        
            if(curr.left != null){
                Q.add(curr.left);
            }
            if(curr.right != null){
                Q.add(curr.right);
            }
        }
        for(int j=0;j<ans.length;j++){
            result.add(ans[j]);
        }
        LeftTOright=!LeftTOright;
        }
        return result;
    }
    public static void main(String args[]){

        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(5);
        t.right.left=new TreeNode(6);
        t.right.right=new TreeNode(7);
        t.right.right.left=new TreeNode(8);
        t.right.right.right=new TreeNode(9);

       
        List<Integer> res=Solution(t);

        for( int i =0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
}
