import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href='https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150'>轮转数组 - LeetCode</a>
 * <p>
 * 2024/7/12
 */
public class _0189_Rotate {
    public static void rotate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();  // key 代表轮转之后的索引，value 代表元素值
        for (int i = 0; i < nums.length; i++) {
            map.put((i + k) % nums.length, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
