import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/distribute-candies-to-people/description/?envType=daily-question&envId=2024-06-03">分糖果 Ⅱ</a>
 * <p>
 * @since 2024/6/3
 */
public class _1103_DistributeCandies_Ⅱ {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int i =0;
        while (candies != 0) {
            result[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
    }
}
