package A101_110.A102_LevelOrder;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by GYC
 * 2020/7/22 9:23
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class LevelOrder {

    //way1 非递归
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int depth = 0;
        TreeNode tempNode;
        while (!queue.isEmpty()) {
            depth++;
            int temp = queue.size();
            List<Integer> subList = new ArrayList<>();

            while (temp-- > 0) {
                tempNode = queue.pollFirst();
                subList.add(tempNode.val);
                if (tempNode.left!=null) queue.addLast(tempNode.left);
                if (tempNode.right!=null) queue.addLast(tempNode.right);
            }
            res.add(subList);
        }
        return res;
    }

    //way2 非递归
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        return res;
    }

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
        List<List<Integer>> res = new LevelOrder().levelOrder(node1);
        for (List<Integer> aList : res) {
            for (int val : aList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
