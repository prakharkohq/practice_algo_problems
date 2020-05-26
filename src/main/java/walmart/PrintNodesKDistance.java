package walmart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PrintNodesKDistance {
    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Search for the respective node in Tree


    // Step 1 find node helper This method can be genric for finding out the parents of nodes
    public static boolean findNodeHelper(TreeNode root, int k, Stack<TreeNode> stack) {
        // Step 1 in Recursive method is to right the termination condition
        if (root == null)
            return false;

        stack.push(root);
        if (root.data == k)
            return true;

        // Intention of using boolean as a return type is to facilitate the recursive calls in if conitions
        if (findNodeHelper(root.left, k, stack))
            return true;
        if (findNodeHelper(root.right, k, stack))
            return true;

        stack.pop();
        return false;
    }

    // Step 2 find child nodes with distance
    public static List<Integer> findChildNodes(TreeNode treeNode, TreeNode lastnode, int distance) {
        // condn to check
        // 1 last node aur current node same na ho
        // 2 if distnace is 0 and data is present add it into the ans
        List<Integer> ans = new LinkedList<>();
        if (treeNode == null)
            return Collections.emptyList();

        if (treeNode == lastnode || distance < 0)
            return Collections.emptyList();

        if (treeNode != null && distance == 0) {
            ans.add(treeNode.data);
            return ans;
        }


        ans.addAll(findChildNodes(treeNode.left, lastnode, distance - 1));
        ans.addAll(findChildNodes(treeNode.right, lastnode, distance - 1));
        return ans;
    }


    // Step 3 run  Main process in loop
    public static List<Integer> findDistantChildNodes(TreeNode treeNode, int k, int distance) {
        // Validations for the process
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (treeNode == null)
            return Collections.emptyList();
        if (!findNodeHelper(treeNode, k, stack))
            return Collections.emptyList();
        // Finding forward nodes are easy whereas backwards nodes are bit tricky so we will use last node to keep track to not to go back
        // Traversing the same track again and again
        TreeNode lastnode = null;
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode root = stack.pop();
            list.addAll(findChildNodes(root, lastnode, distance - count));
            lastnode = root;
            count++;
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right= new TreeNode(5);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        Stack<TreeNode> stack = new Stack<>();
        if (!findNodeHelper(node, 3, stack)) {
            System.out.println(" Unknwon Node entered ");
        }

        List<Integer> ans = findDistantChildNodes(node,1, 2);
        for (int i :ans)
            System.out.println(i);
    }

}
