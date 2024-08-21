import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150">买卖股票的最佳时机 Ⅱ - LeetCode</a>
 * <p>
 * @since 2024/8/12
 */
public class _0121_TheBestTimeToBuyAndSellStocks_Ⅱ {
    public int maxProfit(int[] prices) {
        int result = 0;

        // 交易次数无限，所以所有大于 0 的日间差额都是利润
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                result += prices[i] - prices[i - 1];
        }
        return result;
    }

    @Test
    public void test_1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    @Test
    public void test_2() {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }

    @Test
    public void test_3() {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }
}
