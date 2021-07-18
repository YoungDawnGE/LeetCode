package A91_100.A95_GenerateTrees;

import MyUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/15 13:32
 * 95. 不同的二叉搜索树 II
 * 难度中等928收藏分享切换为英文接收动态反馈
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 * 	• 1 <= n <= 8
 **/
public class GenerateTrees {
    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    /**
     * 以N为root的树
     *
     * @param start
     * @param end
     */
    private List<TreeNode> dfs(int start, int end) {

        List<TreeNode> allTree = new ArrayList<>();
        if (start > end) {
            allTree.add(null);
            return allTree;
        }

        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = dfs(start, i - 1);
            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = dfs(i + 1, end);

            for (TreeNode rightTree : rightTrees) {
                for (TreeNode leftTree : leftTrees) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = leftTree;
                    curTree.right = rightTree;
                    allTree.add(curTree);
                }
            }
        }
        return allTree;
    }
}
