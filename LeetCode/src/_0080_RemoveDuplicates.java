/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150">删除有序数组中的重复项 Ⅱ - LeetCode</a>
 * <p>
 * 2024/7/14
 */
public class _0080_RemoveDuplicates {
    /**
     * 利用排序特点
     *
     * @param nums 有序数组
     * @return 删除重复元素之后的数组长度
     */
    public static int removeDuplicates_sort(int[] nums) {
        int index = 0;

        for (int num : nums) {
            if (index < 2 || num > nums[index - 2]) {
                nums[index++] = num;
            }
        }

        return index;
    }

    /**
     * 利用排序特点
     *
     * @param nums 有序数组
     * @return 删除重复元素之后的数组长度
     */
    static int removeDuplicates_point(int[] nums) {
        int fast = 2, slow = 2; // 快慢双指针：fast 表示待检察点；slow 表示处理后的数组长度
        int length = nums.length;

        if (length <= 2) {  // 对数组长度不超过 2 数组进行特殊处理，直接返回其长度
            return length;
        }

        while (fast < length) {
            // 只需要判断待检查点与上上个保留点是否相等，若不相等，则将待检查点覆盖到 slow 索引；若相等，则将来到下一个待检察点
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates_sort(nums));

        System.out.println(removeDuplicates_point(new int[]{1, 1, 1, 2, 2, 3}));
    }
}
