import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150">Z 字形变换 - LeetCode</a>
 * <p>
 * @since 2024/8/8
 */
public class _0006_Z_shapedTransformation {
    /**
     * 规律解法
     *
     * @param s       输入字符串
     * @param numRows 行数
     * @return 变换后的结果
     */
    public String convert(String s, int numRows) {
        int stringLength = s.length();

        if (stringLength <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int distance = numRows * 2 - 2;
        int count = stringLength / distance + 1;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < count; j++) {
                if (j * distance + i < stringLength) {
                    result.append(s.charAt(j * distance + i));
                }

                if (i != 0 && i != numRows - 1 && (j + 1) * distance - i < stringLength) {
                    result.append(s.charAt((j + 1) * distance - i));
                }
            }
        }

        return result.toString();
    }

    /**
     * 链表解法（参考其他人的 C++ 解法）
     *
     * @param s       输入字符串
     * @param numRows 行数
     * @return 变换后的结果
     */
    public String convert_array(String s, int numRows) {
        // 特殊处理
        if (numRows == 1) {
            return s;
        }

        // 行转向标志，极妙
        int flag = 1;
        // 行下标索引
        int rowIndex = 0;
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Character> characters = new ArrayList<>();
            lists.add(characters);
        }

        for (int i = 0; i < s.length(); i++) {
            lists.get(rowIndex).add(s.charAt(i));

            // 更新行下标
            rowIndex += flag;

            if (rowIndex == numRows - 1 || rowIndex == 0) {
                // 转向，上 —> 下 | 下 —> 上
                flag = -flag;
            }
        }

        StringBuilder result = new StringBuilder();
        lists.forEach(list -> list.forEach(result::append));

        return result.toString();
    }

    @Test
    public void test_1() {
        String result = convert("PAYPALISHIRING", 4);
        System.out.println(result);
        Assert.assertEquals("PINALSIGYAHRPI", result);
    }

    @Test
    public void test_2() {
        String result = convert("AB", 1);
        System.out.println(result);
        Assert.assertEquals("AB", result);
    }

    @Test
    public void test_3() {
        String result = convert("ABCDE", 4);
        System.out.println(result);
        Assert.assertEquals("ABCED", result);
    }

    @Test
    public void test_4() {
        String result = convert_array("PAYPALISHIRING", 4);
        System.out.println(result);
        Assert.assertEquals("PINALSIGYAHRPI", result);
    }
}
