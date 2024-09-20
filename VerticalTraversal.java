import java.util.*;

public class VerticalTraversal{
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
    // public static void FindVerticalNode(TreeNode root,  Map<Integer,ArrayList<Integer>> map,int i){

    //     if(root == null){
    //         return;
    //     }

    //     ArrayList<Integer> temp=map.getOrDefault(i, new ArrayList<>());
    //     temp.add(root.data);
    //     map.put(i,temp);

    //     FindVerticalNode(root.left, map, i-1);
    //     FindVerticalNode(root.right, map, i+1);
    // }
    // public static Map<Integer,ArrayList<Integer>> VerticalTrav(TreeNode root){

    //     Map<Integer,ArrayList<Integer>> map=new HashMap<>();

    //     if(root == null){
    //         return map;
    //     }

    //     FindVerticalNode(root,map,0);

    //     return map;
    
    // }
    static Map<Integer,List<Integer>> map=new HashMap<>();
    public static  void FindVerticalNode
    (TreeNode root,  Map<Integer,List<Integer>> map,int i){

        if(root == null){
            return;
        }

        List<Integer> temp=map.getOrDefault(i, new ArrayList<>());
        temp.add(root.data);
        map.put(i,temp);

        FindVerticalNode(root.left, map, i-1);
        FindVerticalNode(root.right, map, i+1);

    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {

       
 List<List<Integer>> ans= new ArrayList();
        if(root == null){
            return ans;
        }

         FindVerticalNode(root,map,0);
 
     
     Map<Integer,List<Integer>> sort=new TreeMap<>(map);

        for(Map.Entry<Integer,List<Integer>> ent : sort.entrySet()){
            // System.out.println(ent.getKey() + ":"+ ent.getValue());
            ans.add(ent.getValue());
        }
        return ans;
    }
    public static void main(String args[]){

        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(5);
        t.right.left=new TreeNode(6);
        t.right.right=new TreeNode(7);
        // t.right.left.right=new TreeNode(8);
        // t.right.right.right=new TreeNode(9);

        
        List<List<Integer>> ans=verticalTraversal(t);
        // Map<Integer,ArrayList<Integer>> sort=new TreeMap<>(res);
        // ArrayList<ArrayList<Integer>> ans= new ArrayList();

        // for(Map.Entry<Integer,ArrayList<Integer>> ent : sort.entrySet()){
        //     // System.out.println(ent.getKey() + ":"+ ent.getValue());
        //     ans.add(ent.getValue());
        // }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}
