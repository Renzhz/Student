import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150">删除有序数组中的重复项 - LeetCode</a>
 * <p>
 * @since 2024/7/13
 */
public class _0026_RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;

        for (int num : nums) {
            if (map.get(num) != null) continue;

            map.put(num, index++);
        }

        map.forEach((key, value) -> nums[value] = key);

        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};

        System.out.println(removeDuplicates(nums));

        System.out.println(Arrays.toString(nums));
    }
}
