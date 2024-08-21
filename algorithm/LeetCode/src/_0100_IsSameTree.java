import common.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/same-tree/?envType=study-plan-v2&envId=top-interview-150">相同的树 - LeetCode</a>
 * <p>
 * @since 2024/8/7
 */
public class _0100_IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean a = isSameTree(p.left, q.left);
        boolean b = isSameTree(p.right, q.right);

        return a && b;
    }

    @Test
    public void test() {
        TreeNode node1_root1 = new TreeNode(1);
        TreeNode node1_root2 = new TreeNode(2);
        TreeNode node2_root1 = new TreeNode(2);
        TreeNode node2_root2 = new TreeNode(1);

        TreeNode root1 = new TreeNode(1, node1_root1, node2_root1);
        TreeNode root2 = new TreeNode(1, node1_root2, node2_root2);

        System.out.println(isSameTree(root1, root2));
    }
}
