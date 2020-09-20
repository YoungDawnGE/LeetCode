package A231_240.A236_LowestCommonAncestor;

import MyUtils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GYC
 * 2020/8/31 10:56
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class LowestCommonAncesstor {
    private TreeNode ans;
    //way1 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean xl = dfs(root.left, p, q);
        boolean xr = dfs(root.right, p, q);
        if (xl && xr || ((root.val == p.val || root.val == q.val) && (xl || xr))) {
            ans = root;//得到答案
        }
        return xl || xr || (root.val == p.val || root.val == q.val);
    }


    //----------------------------------------------------------------------------
    //way2 HashMap存储每个节点的父节点
    private HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();
    private Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //孩子指向父节点
        pointToParent(root);
        //从 p q 向上找
        //先把P自身加进去
        while (p != null) {
            set.add(p);
            p = hashMap.get(p);//获得P的父节点
            System.out.println(p.val);
        }

        //获得Q的父节点
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = hashMap.get(q);
        }
        return null;
    }
    //先序遍历构造 指向父节点的指针 O(N)
    private void pointToParent(TreeNode root) {
        if (root.left != null) {
            hashMap.put(root.left, root);
            pointToParent(root.left);
        }
        if (root.right != null) {
            hashMap.put(root.right, root);
            pointToParent(root.right);
        }
    }
}
