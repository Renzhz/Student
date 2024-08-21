import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://www.acwing.com/problem/content/14/">找出数组中重复的数字 - Acwing</a>
 * <p>
 * @since 2024/8/13
 */
public class _0013_FindDuplicateNumbers {
    public int duplicateInArray(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        if (length == 0 || nums[0] < 0 || nums[length - 1] > length - 1) return -1;

        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }

        return -1;
    }

    @Test
    public void test_1() {
        int[] nums = {2, 3, 5, 4, 3, 6, 1};
        Assert.assertEquals(3, duplicateInArray(nums));
    }

    @Test
    public void test_2() {
        int[] nums = {3, 1, -10, 1, 1, 4, 3, 10, 1, 1};
        Assert.assertEquals(-1, duplicateInArray(nums));
    }
}
