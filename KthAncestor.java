import java.util.*;

public class KthAncestor {

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
public static int FindKthNode(TreeNode root,int node,int k){

    if(root == null){
        return -1;
    }

    if(root.data == node){
        return 0;
    }

    int left=FindKthNode(root.left, node, k);
    int right=FindKthNode(root.right, node, k);

    if(left == -1 && right == -1){
        return -1;
    }

    int max=Math.max(left , right);
    
    if(max + 1 == k){

       ans= root.data;
    }

    return max +1;
}

static int ans;
static int KthAncestor(TreeNode root,int node ,int k){

    FindKthNode(root, node, k);

    if(ans > 0){
        return ans;
    }
    return -1;

}
public static void main(String ags[]){

    TreeNode root=new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    int node = 5;

       System.out.println(KthAncestor(root,node,1));
       
     
}

}
