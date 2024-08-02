import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a href="https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150">多数元素 - LeetCode</a>
 * <p>
 * 2024/8/2
 */
public class _0169_MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        AtomicInteger result = new AtomicInteger();
        map.forEach((key, value) -> {
            if (value > nums.length /2)
                result.set(key);
        });

        return result.get();
    }

    @Test
    public void test() {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
