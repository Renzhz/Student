import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150">单词规律 - LeetCode</a>
 * <p>
 * @since 2024/8/2
 */
public class _0290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        List<String> strings = Arrays.asList(s.split(" "));
        int patternLength = pattern.length();

        // 如果 pattern 规律的字符长度 != 字符串中的字符长度，则永远不可能符合该 pattern 规律
        if (patternLength != strings.size()) return false;

        // 判断 pattern 规律和字符串中每个字符第一次出现位置，不同则返回 false
        for (int i = 0; i < patternLength; i++) {
            if (pattern.indexOf(pattern.charAt(i)) != strings.indexOf(strings.get(i))) return false;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    @Test
    public void test_false() {
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }
}
