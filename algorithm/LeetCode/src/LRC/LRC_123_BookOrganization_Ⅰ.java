package LRC;

import common.ListNode;

import java.util.Arrays;

/**
 * <a href='https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/'>图书整理 Ⅰ [逆转链表] - LeetCode</a>
 * <p>
 * 2024/7/4
 */
public class LRC_123_BookOrganization_Ⅰ {
    public static int[] reverseList(ListNode head) {
        // 1. 计算需要返回的数组长度
        int length = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            length++;
            tempNode = tempNode.next;
        }

        // 2. 倒序将节点值存入数组
        int[] array = new int[length];
        tempNode = head;
        while (tempNode != null) {
            array[--length] = tempNode.val;
            tempNode = tempNode.next;
        }

        return array;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(Arrays.toString(reverseList(node1)));
    }
}
