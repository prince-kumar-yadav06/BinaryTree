public class Isomorphism{

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
    public static boolean CheckIsomorph(TreeNode N1,TreeNode N2){

      //  both node of tree N1 & N2 are null measn it is isomorphism
        if(N1 == null && N2 == null){
            return true;
        }

        if(N1 == null || N2 == null){
            return false;
        }

        if(N1.data != N2.data){
            return false;
        }

        return (CheckIsomorph(N1.left, N2.left) && CheckIsomorph(N1.right, N2.right) || CheckIsomorph(N1.right, N2.left) && CheckIsomorph(N1.left, N2.right));

    }


    public static void main(String args[]){
        TreeNode T1=new TreeNode(1);
        T1.left=new TreeNode(2);
        T1.right=new TreeNode(3);
        T1.left.left=new TreeNode(4);

        TreeNode T2=new TreeNode(1);
        T2.left=new TreeNode(3);
        T2.right=new TreeNode(2);
        T2.right.right=new TreeNode(4);

        System.out.println(CheckIsomorph(T1, T2));

    }
}
