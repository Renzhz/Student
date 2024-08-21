import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150">二叉树的层序遍历 - LeetCode</a>
 * <p>
 * @since 2024/7/17
 */
public class _0101_SequenceTraversalOfBinaryTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 存放每层节点的值
        List<List<Integer>> arrayList = new ArrayList<>();
        // 存放每层中有哪些节点的队列
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return arrayList; // 特殊处理
        queue.offer(root);

        // 每层每层处理
        while (!queue.isEmpty()) {
            // 每层都需要新建一个 list，否则会重复引用，最终导致 arrayList 中只有一个 list
            List<Integer> list = new ArrayList<>();
            // 当前队列中有几个节点，方便理解
            int currentLevelSize = queue.size();

            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            arrayList.add(list);
        }

        return arrayList;
    }

    @Test
    public void test() {
        TreeNode node7 = new TreeNode();
        TreeNode node6 = new TreeNode();
        TreeNode node5 = new TreeNode(7,node6,node7);
        TreeNode node4 = new TreeNode(15);
        TreeNode node3 = new TreeNode(20, node4, node5);
        TreeNode node2 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node2, node3);

        System.out.println(levelOrder(root));
    }
}
