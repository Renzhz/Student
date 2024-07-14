/**
 * <a href="https://leetcode.cn/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150">移除元素 - LeetCode</a>
 * <p>
 * 2024/6/29
 */
public class _0027_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (num != val) nums[index++] = num;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println("result = " + removeElement(nums, 3));
        System.out.println((6 + 3) % 7);
    }
}
