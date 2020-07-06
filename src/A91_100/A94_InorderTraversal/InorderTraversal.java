package A91_100.A94_InorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by GYC
 * 2020/7/5 21:29
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        List<Integer> res = new InorderTraversal().inorderTraversal2(node1);
        for (int a : res) {
            System.out.print(a + " ");
        }
    }

    //way1 递归
    private static List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderSearch(root);
        return res;
    }

    private void inorderSearch(TreeNode node) {
        if (node != null) {
            inorderSearch(node.left);
            res.add(node.val);
            inorderSearch(node.right);
        }
    }

    //way2 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root==null) return res;
        TreeNode node;
        node = root;
        while (node!=null||!stack.isEmpty()) {
            while (null != node) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pollLast();//取出最后一个 FILO
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}
