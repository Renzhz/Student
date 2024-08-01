import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-interview-150">三数之和 - LeetCode</a>
 * <p>
 * 2024/8/1
 */
public class _0015_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int len = nums.length;

        // 如果 nums 的长度不足 3 则无三元组，直接返回空链表
        if (len < 3) return result;

        // 对 nums 进行排序，从小到大升序排列
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // 因为之前有进行过排序，如果 nums[i] > 0，则之后的所有元素都大于 0 ，则不可能存在满足 nums[i] + nums[j] + nums[k] == 0 条件的三元组
            if (nums[i] > 0) break;

            // 如果 nums[i] 与上一次循环的值相同则直接进入下一次循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int L = i + 1;
            int R = len - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    // 当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R−−
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else R--;
            }
        }
        return result;
    }

    @Test
    public void threeSumTest() {
        int[] nums = {-1, 0, 1, 2, -1, -4, -1};

        System.out.println(threeSum(nums));
    }

    @Test
    public void threeSumTest_1() {
        int[] nums = {0, 0, 0, 0};

        System.out.println(threeSum(nums));
    }

    @Test
    public void threeSumTest_2() {
        int[] nums = {-2, 0, 1, 1, 2};

        System.out.println(threeSum(nums));
    }
}
