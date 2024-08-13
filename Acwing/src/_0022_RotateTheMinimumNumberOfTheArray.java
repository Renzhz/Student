import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://www.acwing.com/problem/content/20/">旋转数组的最小数字 - Acwing</a>
 * <p>
 * 2024/8/13
 */
public class _0022_RotateTheMinimumNumberOfTheArray {
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        Arrays.sort(nums);
        return nums[0];
    }

    @Test
    public void test() {
        int[] nums = {2, 2, 2, 0, 1};
        Assert.assertEquals(0, findMin(nums));
    }
}
