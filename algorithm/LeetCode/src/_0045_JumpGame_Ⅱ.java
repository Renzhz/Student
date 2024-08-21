import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150">跳跃游戏 - LeetCode</a>
 * <p>
 * @since 2024/8/12
 */
public class _0045_JumpGame_Ⅱ {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    @Test
    public void test_1() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    @Test
    public void test_2() {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }

    @Test
    public void test_3() {
        int[] nums = {3, 2, 1, 0};
        System.out.println(jump(nums));
    }

    @Test
    public void test_4() {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(jump(nums));
    }
}
