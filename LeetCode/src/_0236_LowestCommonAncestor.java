import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=top-interview-150">二叉树的最近公共祖先 - LeetCode</a>
 * <p>
 * 2024/7/14
 */
public class _0236_LowestCommonAncestor {
    /**
     * 记录各个节点对应的父节点
     */
    static Map<Integer, TreeNode> parent = new HashMap<>();

    /**
     * 记录遍历寻找公共父节点时已经访问过的节点。
     * 如果寻找时发现某个节点的父节点已经存在于该 Set，则表示这个 Set 中的节点就是他们的公共最近父节点
     */
    static Set<Integer> visited = new HashSet<>();

    /**
     * 遍历二叉树，并将各个节点的根节点对应存入 map 中
     *
     * @param node 节点
     */
    private static void dfs(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.val, node);
            dfs(node.left);
        }

        if (node.right != null) {
            parent.put(node.right.val, node);
            dfs(node.right);
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val)) return q;
            q = parent.get(q.val);
        }

        return null;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node7;
        node4.right = node8;
        node2.left = node5;
        node2.right = node6;

        try {
            System.out.println(Objects.requireNonNull(lowestCommonAncestor(root, node1, node8), "空指针").val);
        } catch (NullPointerException exception) {
            System.out.println("null");
        }
    }

    @Test
    public void test_null() {
        TreeNode root = new TreeNode(2);
        TreeNode right = new TreeNode(1);
        root.right = right;

        try {
            System.out.println(Objects.requireNonNull(lowestCommonAncestor(root, root, right), "空指针").val);
        } catch (NullPointerException exception) {
            System.out.println("null");
        }
    }
}
