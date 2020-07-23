package A101_110.A104_MaxDepth;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by GYC
 * 2020/7/6 14:12
 *
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node22 = new TreeNode(7);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node22;

        System.out.println(new MaxDepth().maxDepth1(node1));

    }


    //way1 层次遍历
    public int maxDepth1(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int depth = 0;
        TreeNode tempNode;
        while (!queue.isEmpty()) {
            depth++;
            int temp = queue.size();
            while (temp-- > 0) {
                tempNode = queue.pollFirst();
                if (tempNode.left!=null) queue.addLast(tempNode.left);
                if (tempNode.right!=null) queue.addLast(tempNode.right);
            }
        }
        return depth;
    }

    //way2 深度优先遍历 递归
    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
