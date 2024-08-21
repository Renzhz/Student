import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150">快乐数 - LeetCode</a>
 * <p>
 * @since 2024/7/14
 */
public class _0202_HappyNumber {
    private static final HashSet<Integer> set = new HashSet<>();

    public static boolean isHappy(int n) {
        int sum = 0, temp;

        while (!set.contains(sum)) {
            set.add(sum);
            sum = 0;
            while (n > 0) {
                temp = n % 10;
                n /= 10;
                sum += (int) Math.pow(temp, 2);
            }
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
