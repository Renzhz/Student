import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150">长度最小的子数组 - LeetCode</a>
 * <p>
 * 滑动窗口解法
 * @since 2024/8/9
 */
public class _0209_MinSubArrayLen_SlideWindow {
    public int minSubArrayLen(int target, int[] nums) {
        int arrayLength = nums.length;
        if (arrayLength == 0) return 0;

        int left = 0; // 左指针
        int right = 0; // 右指针
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int pointDistance; // 指针间距离

        while (right < arrayLength) {
            sum += nums[right];

            while (sum >= target) {
                pointDistance = right - left + 1;
                result = Math.min(result, pointDistance);
                sum -= nums[left++];
            }

            right++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
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
