import java.util.*;
public class All_K_Sum {

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

    static Vector<Integer> path=new Vector<>();

    static  void printKSum(TreeNode root,int k){

        if(root == null){
            return;
        }

        path.add(root.data);

        printKSum(root.left,k);
        printKSum(root.right,k);

        int sum=0;

        for(int i=path.size()-1;i>=0;i--){

            sum+=path.get(i);

            if(sum==k){
                printPathUtil(path,i);
            }
        }
        path.remove(path.size()-1);

    }

    static void printPathUtil(Vector<Integer> path,int j){

        System.out.print("[");
        for(int i=j;i<path.size();i++){
            System.out.print(path.get(i)+",");
        }
        System.out.println("]");
    }

    public static void main(String args[]){

        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(3);
        t.right=new TreeNode(-1);
        t.left.left=new TreeNode(2);
        t.left.right=new TreeNode(1);
        t.left.right.left=new TreeNode(1);
        t.right.left=new TreeNode(4);
        t.right.right=new TreeNode(5);
        t.right.left.left=new TreeNode(1);
        t.right.left.right=new TreeNode(2);

        int k=5;

        printKSum(t,k);

    }
}
