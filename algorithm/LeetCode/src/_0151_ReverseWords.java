/**
 * <a href='https://leetcode.cn/problems/reverse-words-in-a-string/'>反转字符串中的单词 - LeetCode</a>
 * <p>
 * 2024/7/10
 */
public class _0151_ReverseWords {
    public static String reverseMessage(String message) {
        String[] words = message.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                if (i != words.length - 1) result.append(" ");
                result.append(words[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseMessage("  hello world!  "));
    }
}
