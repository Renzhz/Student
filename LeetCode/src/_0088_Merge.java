import java.util.ArrayList;
import java.util.Collections;

/**
 * <a href='https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150'>合并有序数组 - LeetCode</a>
 * <p>
 * 2024/7/12
 */
public class _0088_Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            integers.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            integers.add(nums2[i]);
        }
        Collections.sort(integers);

        for (int i = 0; i < m + n; i++) {
            nums1[i] = integers.get(i);
        }
    }
}
