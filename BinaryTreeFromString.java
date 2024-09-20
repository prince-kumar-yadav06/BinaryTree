import java.util.*;
public class BinaryTreeFromString{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public static int Findindex(String str ,int st,int end){

        if(st > end){
            return -1;
        }

        Stack<Character> stack =new Stack<>();

        for( int i=st;i <= end;i++){

            if(str.charAt(i)=='('){
                stack.add(str.charAt(i));
            }

           else if(str.charAt(i) == ')'){
                if(stack.peek() == '(')
                {
                    stack.pop();

                    if(stack.isEmpty()){
                        return i;
                    }
                }
            }
        }
        return -1;

    }
    public static TreeNode TreeFromString(String str,int st,int end){


        //base case
        if(st > end){
            return null;
        }
        int num=0;
        // first value num me store kr lenge parenthesis se phle wala
        while(st <= end && str.charAt(st) >= '0' && str.charAt(st) <= '9' ){
            num=num*10;
            num += (str.charAt(st)- '0');
            st++;
        }
        st--; // parenthesis se ek phle index pr st ko kr denge

        TreeNode root=new TreeNode(num);

        int index=-1;

        if( st+1 <= end && str.charAt(st+1) == '('){

            index=Findindex(str,st+1,end);
        }

        if(index != -1){
            root.left=TreeFromString(str, st+2,index-1);
            root.right=TreeFromString(str,index+2,end-1);
        }

        return root;
    }

public static void preOrder(TreeNode root){

    if (root == null){
        return ;
    }

    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
}

    public static void main(String args[]){

        // String str="1(2)(3)";
        String str="4(2(3)(1))(6(5))";

        TreeNode ansRoot = TreeFromString(str, 0, str.length()-1);

        preOrder(ansRoot);
    }

}
