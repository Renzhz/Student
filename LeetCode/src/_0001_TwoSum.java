import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/two-sum/description/">两数之和-LeetCode</a>
 * <p>
 * 2024/6/1
 */
public class _0001_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 1, 9, 5};
        System.out.println(Arrays.toString(twoSum(nums, 11)));
    }
}
