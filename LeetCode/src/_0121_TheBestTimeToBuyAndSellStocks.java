import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150">买卖股票的最佳时机 - LeetCode</a>
 * <p>
 * 2024/8/12
 */
public class _0121_TheBestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(price - minPrice, maxProfit);
        }
        return maxProfit;
    }

    @Test
    public void test_1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    @Test
    public void test_2() {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }
}
