import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150">最后一个单词的长度 - LeetCode</a>
 * <p>
 * 2024/8/5
 */
public class _0058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (result == 0 && charArray[i] == ' ') {
                continue;
            } else if (result > 0 && charArray[i] == ' ') {
                break;
            } else result++;
        }

        return result;
    }

    @Test
    public void test_1() {
        System.out.println(lengthOfLastWord("Hello World"));
    }
    @Test
    public void test_2() {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
    @Test
    public void test_3() {
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
