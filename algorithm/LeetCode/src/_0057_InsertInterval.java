import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150">插入区间 - LeetCode</a>
 * <p>
 * @since 2024/8/4
 */
public class _0057_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int startNew = newInterval[0];
        int endNew = newInterval[1];

        int start;
        int end;
        boolean insertFlag = false;

        for (int[] interval : intervals) {
            start = interval[0];
            end = interval[1];
            if (endNew < start) {
                if (!insertFlag) {
                    result.add(new int[]{startNew, endNew});
                    insertFlag = true;
                }
                result.add(interval);
            } else if (startNew > end) {
                result.add(interval);
            } else {
                startNew = Math.min(start, startNew);
                endNew = Math.max(end, endNew);
            }
        }

        if (!insertFlag) result.add(new int[]{startNew, endNew});

        return result.toArray(new int[result.size()][]);
    }

    @Test
    public void test() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    @Test
    public void test_2() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
}
