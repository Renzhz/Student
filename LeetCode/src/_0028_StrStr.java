import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=study-plan-v2&envId=top-interview-150">找出字符串中第一个匹配项的下标 - LeetCode</a>
 * <p>
 * 2024/7/16
 */
public class _0028_StrStr {
    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;

        int needleLength = needle.length();
        char needleFirstChar = needle.charAt(0);
        char[] haystackCharArray = haystack.toCharArray();

        for (int i = 0; i < haystack.length(); i++) {
            if (haystackCharArray[i] == needleFirstChar && needle.equals(haystack.substring(i, i + needleLength))) {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        System.out.println(strStr("mississippi", "issipi"));
    }
}
