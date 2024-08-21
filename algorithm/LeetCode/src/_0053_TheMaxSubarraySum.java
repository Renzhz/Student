import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&envId=top-interview-150">最大子数组和 - LeetCode</a>
 * <p>
 *     使用前缀和思想，很强的思想，第一次了解可以这样做。
 * @since 2024/8/13
 */
public class _0053_TheMaxSubarraySum {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int result = Integer.MIN_VALUE;
        int minPrefixSum = 0;
        int curPrefixSum = 0;

        for (int num : nums) {
            // 更新当前前缀和
            curPrefixSum += num;
            // 当前最大前缀和 = 当前前缀和 - 最小前缀和
            result = Math.max(result, curPrefixSum - minPrefixSum);
            // 更新最小前缀和
            minPrefixSum = Math.min(minPrefixSum, curPrefixSum);
        }

        return result;
    }

    @Test
    public void test_1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    @Test
    public void test_2() {
        int[] nums = {1};
        System.out.println(maxSubArray(nums));
    }

    @Test
    public void test_3() {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }
}
