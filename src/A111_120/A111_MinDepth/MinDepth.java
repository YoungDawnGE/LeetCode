package A111_120.A111_MinDepth;

import MyUtils.TreeNode;

import java.util.*;

/**
 * Created by GYC
 * 2020/11/1 12:55
 *
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left  = node2;
        node1.right = node3;
        node3.left  = node4;
        node3.right = node5;

        System.out.println(new MinDepth().minDepth2(node1));

    }

    //way1 深度优先
    //     和MaxDepth一样的方法，但是return的时候是Math.min
    //     但是会存在问题：遍历了整棵树，可以考虑剪枝
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1;
    }

    //way2 广度优先  层次遍历
    //     第一个非叶子节点的深度一定是最小的
    public int minDepth2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return 0;
        }
        stack.addLast(root);
        int layerSize = 1;//记录每层的大小
        int depth = 1;//记录深度
        while (stack.size() != 0) {
            while (layerSize-- != 0) {
                TreeNode temp = stack.pollFirst();

                if (temp.left == null && temp.right == null) {
                    return depth;
                }

                if (temp.left != null) {
                    stack.addLast(temp.left);
                }
                if (temp.right != null) {
                    stack.addLast(temp.right);
                }
            }
            layerSize = stack.size();
            depth += 1;
        }
        return 0;
    }
}
