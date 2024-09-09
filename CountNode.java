public class BinaryTree{

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
    static Node CreateTree(int arr[]){
        indx++;
        if(arr[indx] == -1){
            return null;
        }
        Node newNode=new Node(arr[indx]);
        newNode.left=CreateTree(arr);
        newNode.right=CreateTree(arr);

        return newNode;
    }

    static int CountNode(Node root){

        // base case 
        if(root == null){
            return 0;
        }

        int left=CountNode(root.left);
        int right=CountNode(root.right);

        return left + right +1;
    }
    public static void main(String args[]){

        int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree ob=new BinaryTree();
       Node root= ob.CreateTree(arr);

       System.out.println(CountNode(root));

    }
}
