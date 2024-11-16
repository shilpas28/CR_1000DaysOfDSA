//Leetcode - Method 1
//106. Construct Binary Tree from Inorder and Postorder Traversal
//Time complexity: O(N^2)
//Space complexity: O(N)


public class ConstructBinaryTreeFromInorderPostorder {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(inorder, postorder);
        inorder(root);
    }
    
    public static TreeNode buildTree( int[] inorder,int[] postorder) {
        int n = inorder.length;
        int[] postIndex = {postorder.length-1};
        return cTree(inorder, postorder, 0, n-1, postIndex);
    }

    public static TreeNode cTree(int in[],int post[],int is,int ie, int[] postIndex){
        if(is>ie)return null;
        TreeNode root=new TreeNode(post[postIndex[0]--]);
        int inIndex=is;
        for(int i=is;i<=ie;i++){
            if(in[i]==root.val){
                inIndex=i;
                break;
            }
        }

        root.right=cTree(in, post, inIndex+1, ie, postIndex);
        root.left=cTree(in, post, is, inIndex-1, postIndex);   
        return root;
    }
    
    public static void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);    
        }
    } 

}
