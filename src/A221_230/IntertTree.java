package A221_230;

import MyUtils.TreeNode;

/**
 * Created by GYC
 * 2020/8/31 10:09
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class IntertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrderInvert(root);
        return root;
    }

    private void inOrderInvert(TreeNode root) {
        //后序遍历
        if (root != null) {
            inOrderInvert(root.left);
            inOrderInvert(root.right);
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
        }
    }
}
