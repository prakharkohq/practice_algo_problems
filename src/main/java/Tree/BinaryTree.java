package Tree;

public class BinaryTree {
    TreeNode root;

   static class TreeNode {
        TreeNode left, right;
        int data;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Left right root
    public void printNodesPreOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.data);

        printNodesPreOrder(root.left);
        printNodesPreOrder(root.right);
    }

    // right left root
    public void printNodesPostorder(TreeNode root)
    {
     if (root == null)
         return;
        printNodesPreOrder(root.left);
        printNodesPreOrder(root.right);
        System.out.println(root.data);

    }

    // left root right
    public void printNodesInorder(TreeNode root)
    {
        if (root == null)
            return;
        printNodesPreOrder(root.left);
        System.out.println(root.data);
        printNodesPreOrder(root.right);

    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode( 4);
        node.right.right = new TreeNode(5);
        BinaryTree tree = new BinaryTree();
        tree.printNodesPostorder(node);
    }

}
