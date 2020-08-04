package Miscllaneous;

public class MorrisTraversal {

    /**
     * Morris traversal does not uses recursion or stack
     * it uses concept of threaded binary tree for traversing the values in right order
     */

    public static void inOrderMorrisTraversal(CorrectBST.TreeNode root) {
        CorrectBST.TreeNode preNode, currentNode;// Pre is for Predecssor node and current is for check of current node

        // Validation for root Node
        if (root == null)
            return;
        currentNode = root;

        // Main While loop which will print all the elements
        while (currentNode != null) {
            // Check if currentNode has a left child or not
            if (currentNode.left == null) {
                System.out.println(" " + currentNode.val);
                currentNode = currentNode.right;
            } else {
                // finding the rightmost element of preNode
                preNode = currentNode.left;
                while (preNode.right != null && preNode.right != currentNode) {
                    preNode = preNode.right;
                }
                // Yaha jab aage aate jaao sirf terminal node ke pointers switch karo other wise  move the ball
                if (preNode.right == null) // only way to find out if it is terminal node or not
                {
                    preNode.right = currentNode;
                    currentNode = currentNode.left;
                } else  // means already there is a link for that node means it is a threaded link mark it null and move current node to right side
                {
                    preNode.right = null;
                    System.out.println("    " + currentNode.val);
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        CorrectBST.TreeNode root = CorrectBST.getOption1("option1");
        inOrderMorrisTraversal(root);
    }
}
