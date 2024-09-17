public class SameTree {
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
    public static boolean CheckSameTreeOrNot(TreeNode T1,TreeNode T2){

        if(T1 == null && T2 == null){
            return true;
        }
        if(T1 == null || T2 == null){
            return false;
        }
        if(T1.data != T2.data){
            return false;
        }

        return (CheckSameTreeOrNot(T1.left, T2.left) && CheckSameTreeOrNot(T1.right, T2.right));
    }

    public static void main(String args[]){

        TreeNode T1=new TreeNode(1);
        T1.left=new TreeNode(2);
        T1.right=new TreeNode(3);


        TreeNode T2=new TreeNode(1);
        T2.left=new TreeNode(2);
        T2.right=new TreeNode(2);

        System.out.println(CheckSameTreeOrNot(T1,T2));
    }
}
