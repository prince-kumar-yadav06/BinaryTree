import java.util.*;

public class BoundaryTraversal {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
public static void TraversalLeft(TreeNode root,ArrayList<Integer> ans){
    //leaf node kot traverse nhi krenge
    if( (root == null) ||  (root.left == null && root.right == null)){
        return ;
    }

    ans.add(root.data);

    //call for left
    if(root.left != null){
        TraversalLeft(root.left, ans);
    }
    else{
        TraversalLeft(root.right, ans);
    }
}

public static void TraversalLeaf(TreeNode root,ArrayList ans){
    if((root == null) ){
        return;
    }
     
   if (root.left == null && root.right == null){
        ans.add(root.data);
        return;
    }

        TraversalLeaf(root.left, ans);
        TraversalLeaf(root.right, ans);
}

public static void TraversalRight(TreeNode root,ArrayList ans){

    if( (root == null) ||  (root.left == null && root.right == null)){
        return ;
    }
    

    if(root.right != null){
        TraversalRight(root.right, ans); //right null hai to  take left traverse 
    }
    else{
        TraversalRight(root.left,ans);
    }
    ans.add(root.data);


}
    public static ArrayList<Integer> BoundaryTrav(TreeNode root){

        //base case
        ArrayList<Integer> ans=new ArrayList<>();
        if(root == null){
            return ans;
        }

        //first add root data ans call for left and right
        ans.add(root.data);

        // 1 call for left 
        TraversalLeft(root.left,ans);

        // 2 call for leaf node 
        TraversalLeaf(root.left,ans);  // left leaf call 
        TraversalLeaf(root.right,ans);  // right leaf call

        // 3 call for right node 
        TraversalRight(root.right,ans); // right value add from bottom to up

        return ans;
    }
    public static void main(String args[]){

        TreeNode T=new TreeNode(1);
        T.left=new TreeNode(2);
        // T.right=new TreeNode(8);
        T.left.left=new TreeNode(4);
        T.left.left.left=new TreeNode(6);
        T.left.left.right=new TreeNode(5);
        T.left.right=new TreeNode(9);
        T.left.right.right=new TreeNode(3);
        T.left.right.right.left=new TreeNode(7);
        T.left.right.right.right=new TreeNode(8);

        ArrayList<Integer> res= BoundaryTrav(T);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
}
}
