import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150">跳跃游戏 - LeetCode</a>
 * <p>
 * @since 2024/8/12
 */
public class _0055_JumpGame {
    /**
     * 找到当前最大的步数再去跳跃
     * 首先设最大步数 n，然后每次只走一格，如果走到的该格步数大于 n，则替换掉当前的 n，反之则 n-1；
     * 如果 n 减到 0 之后则则证明最大的步数都无法移动，故返回 false
     *
     * @param nums 非负整数数组
     * @return TRUE / FALSE
     */
    public boolean canJump(int[] nums) {
        int maxStep = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxStep == 0) return false;

            if (maxStep > nums[i])
                maxStep--;
            else maxStep = nums[i];
        }

        return true;
    }

    @Test
    public void test_1() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    @Test
    public void test_2() {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    @Test
    public void test_3() {
        int[] nums = {3, 2, 1, 0};
        System.out.println(canJump(nums));
    }
}
