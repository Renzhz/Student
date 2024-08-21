/**
 * <a href="https://leetcode.cn/problems/account-balance-after-rounded-purchase/">取整购买后的账户余额 - LeetCode</a>
 * <p>
 * @since 2024/6/12
 */
public class _2806_AccountBalanceAfterPurchase {
    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        int result;

        int temp = purchaseAmount % 10;

        if (temp > 5) {
            result = 100 - purchaseAmount + temp - 10;
        } else if (temp < 5) {
            result = 100 - purchaseAmount + temp;
        } else {
            result = 100 - purchaseAmount - 5;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(accountBalanceAfterPurchase(23));
    }
}
