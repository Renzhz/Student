import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams/description/">字母异位词分组-LeetCode</a>
 * <p>
 * 2024/6/3
 */
public class _0049_GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            final char[] key = string.toCharArray();
            Arrays.sort(key);
            String sortKey = new String(key);
            if (map.containsKey(sortKey)) {
                map.get(sortKey).add(string);
            } else {
                List<String> stringArrayList = new ArrayList<>();
                stringArrayList.add(string);
                map.put(sortKey, stringArrayList);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings).forEach(System.out::print);
    }
}
