import java.util.Scanner;

/**
 * <a href="https://www.acwing.com/problem/content/1/">A+B - Acwing</a>
 * <p>
 * @since 2024/8/13
 */
public class _0001_Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputLine = input.nextLine();
        int result = 0;
        for (String s : inputLine.split(" ")) {
            result += Integer.parseInt(s);
        }

        System.out.println(result);
    }
}
