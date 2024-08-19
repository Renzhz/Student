/**
 * <a href="https://leetcode.cn/problems/search-insert-position/?envType=study-plan-v2&envId=top-interview-150">搜索插入位置</a>
 * <p>
 *     关键点：
 *     1. 返回 nums 中的第一个（最左边的）大于或等于 target 的数的下标
 *     2. 如果所有数都小于 target，返回 nums 的长度。
 * 2024/7/13
 */
public class _0035_SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        int result = nums.length; // 如果所有数都小于 target，返回 nums 的长度

        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (nums[mid] >= target) {
                result = mid;   // 返回 nums 中的第一个（最左边的）大于或等于 target 的数的下标
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        System.out.println(searchInsert(nums, 2));
    }
}
