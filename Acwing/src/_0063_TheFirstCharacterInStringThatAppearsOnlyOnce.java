import org.junit.Assert;
import org.junit.Test;

import java.util.Hashtable;
import java.util.Map;

/**
 * <a href="https://www.acwing.com/problem/content/59/">字符串中第一个只出现一次的字符 - Acwing</a>
 * <p>
 * 2024/8/14
 */
public class _0063_TheFirstCharacterInStringThatAppearsOnlyOnce {
    public char firstNotRepeatingChar(String s) {
        Map<Character, Boolean> hashtable = new Hashtable<>();

        char[] charArray = s.toCharArray();

        for (char ch : charArray) {
            if (hashtable.containsKey(ch)) {
                if (!hashtable.get(ch)) continue;
                hashtable.put(ch, false);
            } else hashtable.put(ch, true);
        }

        for (char ch : charArray) {
            if (hashtable.get(ch)) return ch;
        }

        return '#';
    }

    @Test
    public void test_1() {
        Assert.assertEquals('b', firstNotRepeatingChar("abaccdeff"));
    }

    @Test
    public void test_2() {
        Assert.assertEquals('#', firstNotRepeatingChar("aabbccddeeff"));
    }
}
