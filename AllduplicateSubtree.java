import java.util.HashMap;
import java.util.*;



public class DuplicateSubtree {
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
   static class Node{
        int data;

        Node(int data){
            this.data=data;
        }
    }

   public static String findSubTree(TreeNode root){ // call preOrder recu

    String str="";
    if(root == null){
        return "";
    }
    str += Integer.toString(root.data);
    str += findSubTree(root.left);
    str += findSubTree(root.right);

    if(map.get(str) != null && map.get(str) == 1){
        ans.add(new Node(root.data));
    }
    if(map.containsKey(str)){
        map.put(str,map.get(str) +1);
    }
    else{
        map.put(str, 1);
    }
    for(Map.Entry<String,Integer> ent:map.entrySet()){
        System.out.println(ent.getKey() +":"+ ent.getValue());
    }
        return str;

   }

   static Map<String,Integer> map=new HashMap<String,Integer>();
    static ArrayList<Node> ans=new ArrayList<>();

    public static ArrayList<Node> dupliSubtree(TreeNode root){

        if(root == null){
            return null;
        }

        findSubTree(root);

        return ans;

        
    }
    public static void main(String args[]){

        // TreeNode t=new TreeNode(5);
        // t.left=new TreeNode(4);
        // t.right=new TreeNode(6);
        // t.left.left=new TreeNode(3);
        // t.left.right=new TreeNode(4);
        // t.left.right.left=new TreeNode(3);
        // t.left.right.right=new TreeNode(6);

       TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        ArrayList<Node> res=(dupliSubtree(root));

        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i).data);
        }

    }
}
