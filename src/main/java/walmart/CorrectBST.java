package walmart;

public class CorrectBST {

    //    https://leetcode.com/problems/recover-binary-search-tree/discuss/32650/Share-My-java-Solution-using-Morris-Traversal

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

    public static void printInorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printInorder(treeNode.left);
        System.out.println(treeNode.val);
        printInorder(treeNode.right);

    }

    /***
     *
     *  OPTION 1 nODE
     *
     * Input: [1,3,null,null,2]
     *
     *    1
     *   /
     *  3
     *   \
     *    2
     *
     *
     *    Output: [3,1,null,null,2]
     *
     *    3
     *   /
     *  1
     *   \
     *    2
     *
     *
     *  option 2 nODE COMPLETE
     *
     *
     * **/

    public static void main(String[] args) {
        printInorder(getOption1("a"));
    }

    public static TreeNode getOption1(String str) {
        TreeNode rootNode;
        if (str.equalsIgnoreCase("option1")) {
            TreeNode leftNode = new TreeNode(3);
            leftNode.left = null;
            leftNode.right = new TreeNode(2);

            rootNode = new TreeNode(1);
            rootNode.left = leftNode;
        } else {
            TreeNode leftNode = new TreeNode(2);
            leftNode.left = new TreeNode(4);
            leftNode.right = new TreeNode(5);
            TreeNode rightNode = new TreeNode(3);
            rightNode.right = new TreeNode(7);
            rightNode.left = new TreeNode(6);
            rootNode = new TreeNode(1, leftNode, rightNode);
        }
        return rootNode;
    }

    public void recoverTree(TreeNode root) {

        TreeNode first = null;     // first node need to be swap
        TreeNode second = null;    // second node need to be swap
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);  //previous node.

        while (root != null) {
            TreeNode node = root.left;

            // If left is not null, we need to find the rightmost node of left subtree,
            // Set its right child to current node
            if (node != null) {

                //find the rightmost
                while (node.right != null && node.right != root) {
                    node = node.right;
                }

                //There are two cases,
                //null: first time we access current, set node.right to current and move to left child of current and continue;
                //current: we accessed current before, thus we've finished traversing left subtree, set node.right back to null;
                if (node.right == null) {
                    node.right = root;
                    root = root.left;
                    continue;
                } else {
                    node.right = null;
                }
            }

            // compare current node with previous node
            if (root.val < pre.val) {
                // first time we enconter reversed order, we set previous node to first
                if (first == null) {
                    first = pre;
                }
                //In case that two nodes are successive, we set second to current every time.
                second = root;
            }
            pre = root;
            root = root.right;
        }

        //swap the value;
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }
}
