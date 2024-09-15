package BinaryTree;
public class InvertTreeByRecur {
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

    public static TreeNode InvertByrecur(TreeNode root){
        //base case
        if(root ==null){
            return root;
        }

        InvertByrecur(root.left);
        InvertByrecur(root.right);

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        return root;
    }
    public static void main(String args[]){

        TreeNode t=new TreeNode(2);
        t.left=new TreeNode(1);
        t.right=new TreeNode(8);
        t.left.left=new TreeNode(12);
        // t.left.right=new TreeNode(5);
        t.right.right=new TreeNode(9);
      //  t.right.right=new TreeNode(9);



        TreeNode ans=InvertByrecur(t);
        System.out.println(ans.right.data);
}

}
