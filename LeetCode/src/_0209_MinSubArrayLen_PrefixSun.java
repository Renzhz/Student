import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150">长度最小的子数组 - LeetCode</a>
 * <p>
 * 前缀和解法
 * 2024/8/9
 */
// TODO 看不懂
public class _0209_MinSubArrayLen_PrefixSun {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int temp = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, temp);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    @Test
    public void test_1() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    @Test
    public void test_2() {
        int[] nums = {1, 4, 4};
        System.out.println(minSubArrayLen(4, nums));
    }

    @Test
    public void test_3() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(11, nums));
    }
}
