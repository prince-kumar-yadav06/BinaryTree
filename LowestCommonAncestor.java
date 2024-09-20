import java.util.ArrayList;

public class LowestCommonAncestor {
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
static boolean getPath(TreeNode root,int Key, ArrayList<Integer> path){

    if(root == null){
        return false;
    }
    path.add(root.data); //first path me root ka data store kr lenge

    if(root.data==Key){
        return true;
    }

    //check in left and right subtree
    if(getPath(root.left, Key, path)  || getPath(root.right,Key,path)){
        return true;
    }

    //agar left aur right me shi path nhi mila to path me store data ko pop kr denge
    path.remove(path.size()-1);
    return false;
}

static ArrayList<Integer> path1=new ArrayList<>();
static ArrayList<Integer> path2=new ArrayList<>();

    public static int LCA(TreeNode root,int N1,int N2){

        if(root == null){
            return -1;
        }
        getPath(root,N1,path1);
        getPath(root,N2,path2);
        
        int pc;   //Path change for Node N1,N2
        for(pc=0; pc<path1.size() && pc<path2.size();pc++){
            if(path1.get(pc) != path2.get(pc)){
                break;
            }
        }
        return path1.get(pc-1);

    }
    public static void main(String args[]){

        TreeNode T=new TreeNode(1);
        T.left=new TreeNode(2);
        T.left.right=new TreeNode(4);

        T.right=new TreeNode(3);
        T.right.left=new TreeNode(5);
        T.right.left.left=new TreeNode(7);
        T.right.right=new TreeNode(6);

        System.out.println(LCA(T, 7, 6));
    }
}
