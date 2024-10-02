import java.util.*;

public class SerializeAndDeserialize{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }
    }
        public static String serialize(TreeNode root){

            if(root == null){
                return " ";
            }

            Queue<TreeNode> Q=new LinkedList();


            StringBuilder str=new StringBuilder();  //store ans

            Q.add(root);
            while(!Q.isEmpty()){

                TreeNode node=Q.remove();

                if(node == null){
                    str.append("n");
                    continue;
                }
                str.append(node.data);
                Q.add(node.left);
                Q.add(node.right);
            }
            return str.toString();
        }

        public static TreeNode Deserialize(String str){

            if(str== " "){
                return null;
            }

            Queue<TreeNode> Q=new LinkedList<>();
            

            char ch= str.charAt(0);
            TreeNode root=new TreeNode(ch-'0');
            Q.add(root);

            for(int i=1;i<str.length();i++){
                TreeNode parent=Q.poll();

                if(str.charAt(i) != 'n'){
                 char c= str.charAt(i);
                    TreeNode left=new TreeNode(c-'0');
                    parent.left=left;
                    Q.add(left);
                }
                if(str.charAt(++i) != 'n'){
                    char c= str.charAt(i);
                    TreeNode right=new TreeNode(c-'0');
                    parent.right=right;
                    Q.add(right);
                }
            }
             return root;
        }

        public static void main(String args[]){

            TreeNode t=new TreeNode(1);
            t.left=new TreeNode(2);
            t.right=new TreeNode(3);
            t.right.left=new TreeNode(4);
            t.right.right=new TreeNode(5);


            String str=serialize(t);
            for(int i=0;i<str.length();i++){
                System.out.print(str.charAt(i)+" ");
            }

            System.out.println();
            TreeNode root=Deserialize(str);
            System.out.println(root.right.right.data);
            }
        
    }
