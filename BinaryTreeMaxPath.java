import java.util.*;

public class BinaryTreeMaxPath {
    
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
static int ans=0;

static int SumAtNode(TreeNode root ){

    if(root == null){
        return 0;
    }

    int leftsum=SumAtNode(root.left);
    int rightsum=SumAtNode(root.right);

  

   int MaxNodesum= Math.max(Math.max(root.data, (root.data + leftsum + rightsum)),
    Math.max( (root.data + leftsum) , (root.data + rightsum)));

        ans=Math.max(ans, MaxNodesum);



     int singlePathSum =  Math.max(root.data ,(Math.max( root.data +leftsum,
           root.data + rightsum)));

    return singlePathSum;
            
}


public static int MaxSumPath(TreeNode root){


    //sum at including left & right every particular node
    SumAtNode(root);  

    return ans;
}



public static void main(String args[]){

    TreeNode t=new TreeNode(1);
    t.left=new TreeNode(2);
    t.right=new TreeNode(3);
    t.right.left=new TreeNode(15);
    t.right.right=new TreeNode(7);

    System.out.println(MaxSumPath(t));
}


}
