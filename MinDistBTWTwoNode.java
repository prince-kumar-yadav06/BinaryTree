import java.util.ArrayList;

public class MinDistBTWTwoNode{
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static TreeNode LCA(TreeNode root,int n1,int n2){
        if(root == null){
           return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }
             
      TreeNode left=  LCA(root.left,n1,n2);
      TreeNode right=  LCA(root.right,n1,n2);

      if(left != null && right != null){
        return root;
      }

      if(left == null && right == null){
        return null;
      }
      if(left != null){
          return LCA(root.left,n1,n2);
      }

       return LCA(root.right,n1,n2);
          
    }

    static int findDist(TreeNode root,int key,int dist){
        
        if(root == null){
            return -1;
        }

        if(root.data==key){
            return dist;
        }

        int left=findDist(root.left, key, dist+1);

        if(left != -1){
            return left;
        }

        return findDist(root.right, key, dist+1);
    }
static int distBtwNode(TreeNode root,int n1,int n2){

    TreeNode lca=LCA(root,n1,n2);

    int d1=findDist(lca,n1,0);
    int d2=findDist(lca,n2,0);

    return d1 +d2;
}

        public static void main(String args[]){

        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.left=new TreeNode(4);
        t.right.left=new TreeNode(6);
        t.right.right=new TreeNode(5);

        // 15 14 N 9 N 8 11 5 N 10 13 3 6 N N N N 1 N N N N 2 N N
//       

    
    System.out.println(distBtwNode(t, 4,5));
    }
}


