import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/sqrtx/description/?envType=study-plan-v2&envId=top-interview-150">X 的平方根 - LeetCode</a>
 * <p>
 * 因为返回的一定是整数，小数部分会被直接约去，所以最后的那个值一定符合 pow(result, 2) <= x，
 * 所以只需要找到平方后最接近 x 的整数即可。【二分法查找】
 * 2024/7/16
 */
public class _0069_SquareRootOfX {
    public int mySqrt(int x) {
        int left = 0, right = x, mid, result = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    @Test
    public void test() {
        System.out.println(mySqrt(0));
    }
}
