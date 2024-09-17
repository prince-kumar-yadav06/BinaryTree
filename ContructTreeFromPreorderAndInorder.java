public class BuildTreeByPreOderANdInorderArr {

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

    public static int FindPos(int inorder[],int st,int end,int curr){

        for(int i=st;i<=end;i++){
            if(curr == inorder[i]){
                return i;
            }
        }
        return -1;
    }
    static int idx=0;
    public static TreeNode BuildTree(int preorder[],int inorder[],int start,int end){

        if(start > end){
            return null;
        }

        int curr=preorder[idx];
        idx++;
        TreeNode root=new TreeNode(curr);

        int pos=FindPos(inorder,start,end,curr);
        
                if(start == end){
                    return root;
                }

        
        root.left=BuildTree(preorder, inorder, start, pos-1);
        root.right=BuildTree(preorder, inorder, pos+1, end);

        return root;
    }

    // print function
    public static void inorder(TreeNode root){

        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[]){
         int[]preorder={3,9,20,15,7};
         int inorder[]={9,3,15,20,7};

      TreeNode ansroot=   BuildTree(preorder,inorder,0,4);

      inorder(ansroot);
    }
}
