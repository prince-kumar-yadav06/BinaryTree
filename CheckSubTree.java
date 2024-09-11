public class CheckSubTree{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean areIdentical(Node root1,Node root2){

        // base case 
        if(root1 == null && root2 == null){  //dono root null hai to identical hoga
            return true;
        }

        if(root1 == null || root2 ==null){ //agar ek null hai or ek nhi to identical nhi hoga
            return false;
        }
        //  check data hr root ka same hai and left ka or right ka bhi
        return (root1.data == root2.data && 
                areIdentical(root1.left,root2.left)
                && areIdentical(root1.right, root2.right));
    }


    public static boolean isSubTree(Node T,Node S){
        if(S==null){
            return true;
        }

        if(T==null){
            return false;
        }

        if(areIdentical(T, S)){
            return true;
        }

        return (isSubTree(T.left,S) || isSubTree(T.right,S));
    }

    public static void main(String args[]){
    

       Node T=new Node(3);
       T.left=new Node(4);
       T.right=new Node(5);
       T.left.left=new Node(1);
       T.left.right=new Node(2);
       T.left.right.left=new Node(0);

    //    subTree 
    Node S=new Node(4);
    S.left=new Node(1);
    S.right=new Node(2);
    S.right.left=new Node(0);

    System.out.println(isSubTree(T, S));

    }
}
