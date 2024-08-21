import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://www.acwing.com/problem/content/16/">二维数组中的查找 - Acwing</a>
 * <p>
 * @since 2024/8/14
 */
public class _0015_SearchIn2DArrays_plus {
    public boolean searchArray(int[][] array, int target) {
        if (array.length == 0 || array[0].length == 0) return false;

        int row = 0;
        int col = array[row].length - 1; // 右边列
        int temp;
        while (col >= 0 && row < array.length) {
            temp = array[row][col];
            if (temp == target) return true;
            if (temp < target) row++;
            else col--;
        }

        return false;
    }

    @Test
    public void test_1() {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Assert.assertTrue(searchArray(nums, 7));
    }

    @Test
    public void test_2() {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Assert.assertFalse(searchArray(nums, 5));
    }

    @Test
    public void test_3() {
        int[][] nums = {{}};
        Assert.assertFalse(searchArray(nums, 5));
    }

    @Test
    public void test_4() {
        int[][] nums = {};
        Assert.assertFalse(searchArray(nums, 5));
    }
}
