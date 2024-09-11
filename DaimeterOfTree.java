import java.util.*;
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

    static int HeightOfTree(Node root){

        // base case 
        if(root == null){
            return 0;
        }

        int leftHeight=HeightOfTree(root.left);
        int rightHeight=HeightOfTree(root.right);

        int myHeight=Math.max(leftHeight,rightHeight) + 1;

        return myHeight;
    }

    public static int Daimeter(Node root){
        if(root ==null){
            return 0;
        }

        int Dai1=Daimeter(root.left);
        int Dai2=Daimeter(root.right);
        int  Dai3=HeightOfTree(root.left) + HeightOfTree(root.right);

        int finalDai=Math.max(Dai3,Math.max(Dai1,Dai2)) + 1;

        return Dai3;
    }
    static class TreeInfo{ //  T.C = O(N)
        int height;
        int Daimeter;
        // TreeInfo left;
        // TreeInfo right;

        TreeInfo(int dm,int ht){
            this.Daimeter=dm;
            this.height=ht;
        }
    }
    public static TreeInfo FindDaim(Node root){

        // base case 
        if(root == null ){
            return new TreeInfo(0,0);
        }

        // step 1
        TreeInfo left=FindDaim(root.left);  // find left node
        TreeInfo right=FindDaim(root.right);   // find right node

        // Step 2 find heigth
        int myheight=Math.max(left.height,right.height)+1;

        // step 3
        int daim1=left.Daimeter;
        int daim2=right.Daimeter;
        int daim3=left.height + right.height + 1;

        int fianalDaim=Math.max(daim3,Math.max(daim1,daim2)) ;

        return new TreeInfo(fianalDaim, myheight);
        
    }
    public static void main(String args[]){

        // int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int arr[]={1,2,4,7,-1,-1,-1,5,8,-1,-1,9,11,-1,-1,12,13,-1,-1,14,-1,-1,3,-1,6,-1,-1};

        BinaryTree ob=new BinaryTree();
       Node root= ob.CreateTree(arr);
    //    System.out.println(root.data);

       System.out.println(Daimeter(root));

        // find Daimeter with O(n)
   System.out.println(FindDaim(root).Daimeter);
    }
}
