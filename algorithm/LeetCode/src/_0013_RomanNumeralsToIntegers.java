import org.junit.Test;

import java.util.Hashtable;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a href="https://leetcode.cn/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150">罗马数字转整数 - LeetCode</a>
 * <p>
 * @since 2024/8/5
 */
public class _0013_RomanNumeralsToIntegers {
    Hashtable<Character, Integer> romanTable = new Hashtable<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        Stack<Integer> valueStack = new Stack<>();
        int result = 0;

        for (char c : s.toCharArray()) {
            valueStack.push(romanTable.get(c));
        }

        AtomicInteger temp = new AtomicInteger(valueStack.peek());
        int valueStackSize = valueStack.size();
        for (int i = 0; i < valueStackSize; i++) {
            if (valueStack.peek() < temp.get()) {
                temp.set(valueStack.peek());
                result -= valueStack.pop();
            } else {
                temp.set(valueStack.peek());
                result += valueStack.pop();
            }
        }

        return result;
    }

    @Test
    public void test_1() {
        System.out.println(romanToInt("III"));
    }

    @Test
    public void test_2() {
        System.out.println(romanToInt("IV"));
    }

    @Test
    public void test_3() {
        System.out.println(romanToInt("IX"));
    }

    @Test
    public void test_4() {
        System.out.println(romanToInt("LVIII"));
    }

    @Test
    public void test_5() {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
