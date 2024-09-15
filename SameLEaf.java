package BinaryTree;
public class SameLEaf {

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
public static boolean sameleafOrNot(TreeNode root){

    int leftHeight=Height(root.left); //find left height
    int rightHeight=Height(root.right);  //find right height

   //left and right are same return true else false
    if(leftHeight == rightHeight){
        return true;
    }
    return false;

}
    public static int Height(TreeNode root){
        if(root == null){
            return 0;
        }
       int leftHeight = Height(root.left);    //return left height
       int rightHeight = Height(root.right);  //return right height


        int height=Math.max(leftHeight,rightHeight) + 1;

        return height;
    }
    public static void main(String args[]){

        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(30);
        t.left.left=new TreeNode(2);
        t.left.right=new TreeNode(2);


        System.out.println(sameleafOrNot(t));
    }
}
