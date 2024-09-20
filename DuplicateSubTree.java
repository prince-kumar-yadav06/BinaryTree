import java.util.HashMap;
import java.util.*;

public class DuplicateSubTree {
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

    

    static Map<String,Integer> mp=new HashMap<String,Integer>();
    

    public static String checkSubTree(TreeNode root){

        String str="";
        mp.put(str,0);

        if(root == null){
            return "$";
        }


        if(root.left == null && root.right == null){
            str= Integer.toString(root.data);
        }
        str=str + String.valueOf(root.data);
        str=str + checkSubTree(root.left);
        str = str + checkSubTree(root.right);

       if(mp.containsKey(str)){
        Integer count = mp.get(str);
        count +=1;
        mp.put(str, count);
       }
       else{
        mp.put(str,1);
       }
       return str;


    }
    public static boolean checkDuplicateSubTree(TreeNode root){

        if(root == null){
            return true;
        }

        checkSubTree(root);

        for(Map.Entry<String,Integer> ent : mp.entrySet()){
            int i=ent.getValue();
            if(i >= 2){
                return true;
            }
        }
        return false;

    }

    public static void main(String args[]){

        TreeNode T=new TreeNode(1);
        T.left=new TreeNode(2);
        T.right=new TreeNode(2);
        T.left.left=new TreeNode(4);
        T.right.left=new TreeNode(4);
        T.left.left.right=new TreeNode(3);
        T.right.left.right=new TreeNode(3);
  
        System.out.println(checkDuplicateSubTree(T));
    }
}
