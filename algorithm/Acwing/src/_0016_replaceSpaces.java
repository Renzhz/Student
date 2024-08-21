import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://www.acwing.com/problem/content/17/">替换空格 - Acwing</a>
 * <p>
 * @since 2024/8/13
 */
public class _0016_replaceSpaces {
    public String replaceSpaces(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    @Test
    public void test_1() {
        Assert.assertEquals("We%20are%20happy.", replaceSpaces(new StringBuffer("We are happy.")));
    }
}
