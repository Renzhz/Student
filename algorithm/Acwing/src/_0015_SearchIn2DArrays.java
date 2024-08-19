import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://www.acwing.com/problem/content/16/">二维数组中的查找 - Acwing</a>
 * <p>
 *     思维题
 *     目前暴力解法，时间复杂度 O(n^2)，可有一种 O(nlog) 时间复杂度的解法
 * 2024/8/14
 */
public class _0015_SearchIn2DArrays {
    public boolean searchArray(int[][] array, int target) {
        for (int[] nums : array) {
            for (int num : nums) {
                if (num == target) return true;
            }
        }
        return false;
    }

    @Test
    public void test_1() {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Assert.assertTrue(searchArray(nums, 7));
    }

    @Test
    public void test_5() {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Assert.assertFalse(searchArray(nums, 5));
    }
}
