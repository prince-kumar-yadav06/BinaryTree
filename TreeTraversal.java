import java.util.*;
public class CreateTree{
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
    static int indx=-1;
    static Node BuildTree(int arr[]){
        indx++;
        if(arr[indx] == -1){
            return null;
        }

        Node newnode=new Node(arr[indx]);
        // recursion 
        newnode.left=BuildTree(arr);
        newnode.right=BuildTree(arr);

        // return newnode that is root node 1
        return newnode;
    }

    // 1 Preorder traversal
    static void PreorderTraversal(Node root){
        //base case
        if(root==null){
            return;
        }
        // step1 print root
        System.out.print(root.data+" ");
        PreorderTraversal(root.left); //recursion for left node
        PreorderTraversal(root.right);  //recursion for right node
    }

    // 2 Inorder Traversal
    static void InOrderTraversal(Node root){

        //base case
        if(root == null){
            return;
        }

        InOrderTraversal(root.left);
        System.out.print(root.data+" ");
        InOrderTraversal(root.right);
    }

    // 3 postOrder Traversal
    static void PostOrderTraversal(Node root){
        if(root == null){
            return;
        }
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    // 4 Level Order Traversal
    static void LevelOrder(Node root){

        // Base case
        if(root == null){
            return;
        }

        // Step 1 
        Queue<Node> Q=new LinkedList<>();
        // fist add root in Q and null
        Q.add(root);
        Q.add(null);

        // Step 2 
        while(!Q.isEmpty()){
            Node curr=Q.remove();

            if(curr ==null){
                System.out.println();

                if(Q.isEmpty()){ // Q khali hai to loop se exit kr jayenge
                    break;
                }
                else{
                    Q.add(null);  // Q khali nhi hai to null add kr denge
                }
            }
            else{
                System.out.print(curr.data+" "); //curr null nhi hai to print kra de

                // root ka left null nhi hai to adkr de Q me
                if(curr.left != null){
                    Q.add(curr.left);
                }

                // root ka right null nhi hai to adkr de Q me
                if(curr.right != null){
                    Q.add(curr.right);
                }

            }
        }
    }
    public static void main(String args[]){
        int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        CreateTree tree=new CreateTree();

        Node root=tree.BuildTree(arr);
        // System.out.println(root.left.data);
        PreorderTraversal(root); 

        System.out.println();

        InOrderTraversal(root);

        System.out.println();

        tree.PostOrderTraversal(root);

        System.out.println();

        LevelOrder(root);
    }
}
