public class BalancedTree {
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

    public static boolean BalancedTreeOrNot(TreeNode root){

        int leftHeight=Height(root.left);   //find left height
        int rightHeight=Height(root.right);  // find right height

        int diff=Math.abs(leftHeight - rightHeight); //diff of both height

        if(diff <= 1){
            return true;
        }
        return false;
    }

    public static int Height(TreeNode root){
        
        //base case
        if(root == null){
            return 0;
        }

        int leftHeight=Height(root.left);
        int rightHeight=Height(root.right);

        int Height=Math.max(leftHeight , rightHeight)+ 1;

        return Height;

    }
    public static void main(String args[]){

    TreeNode t=new TreeNode(1);
    t.left=new TreeNode(2);
    t.right=new TreeNode(4);
    t.left.right=new TreeNode(3);


    System.out.print(BalancedTreeOrNot(t));
}
}
