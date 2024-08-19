import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits/description/">计算 K 置位下标对应元素的和 —— LeetCode</a>
 * <p>
 * 2024/6/11
 */
public class _2859_SumOfValuesAtIndicesWithKSetBits {
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        /*
        fori 遍历数组，持续对数组下标以 2 取余并除以 2，直到下标为 0，在这个过程中进行了几次取余则置位 + 1，
        当置位 == K 时，则获取该下标对应的元素值，进行相加。
        直到 fori 遍历结束。
         */
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (bitCount(i) == k) {
                result += nums.get(i);
            }
        }

        return result;
    }

    public static int bitCount(int number) {
        int count = 0;
        while (number != 0) {
            // 必须先对 number 先取余后整除
            count += (number % 2);
            number /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(1);
        list.add(5);
        list.add(2);

        System.out.println(sumIndicesWithKSetBits(list, 1));
    }
}
