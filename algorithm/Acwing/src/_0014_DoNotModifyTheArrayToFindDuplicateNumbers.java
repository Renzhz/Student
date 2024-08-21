import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * <a href="https://www.acwing.com/problem/content/15/">不修改数组找出重复的数字 - Acwing</a>
 * <p>
 * @since 2024/8/13
 */
public class _0014_DoNotModifyTheArrayToFindDuplicateNumbers {
    public int duplicateInArray(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        int result = 0;

        for (int num : nums) {
            if (integers.contains(num)) {
                result = num;
                break;
            }
            integers.add(num);
        }

        return result;
    }

    @Test
    public void test_1() {
        int[] nums = {2, 3, 5, 4, 3, 6, 7};
        Assert.assertEquals(3, duplicateInArray(nums));
    }
}
