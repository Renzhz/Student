import org.junit.Test;

import java.util.Scanner;

/**
 * <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/description/">实现 Trie (前缀树) - LeetCode</a>
 * <p>
 * 2024/8/11
 */
public class _0208_Trie {
    class Trie {
        private Trie[] children;
        private boolean isEnd;

        /**
         * 初始化前缀树对象
         */
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /**
         * 向前缀树中插入字符串 word
         *
         * @param word 待插入字符串
         */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) node.children[index] = new Trie();
                node = node.children[index];
            }
            node.isEnd = true;
        }

        /**
         * 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
         *
         * @param word 待插入字符串
         * @return true / false
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /**
         * 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
         *
         * @param prefix 字符串前缀
         * @return true / false
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) return null;
                node = node.children[index];
            }
            return node;
        }
    }

    @Test
    public void test_1() {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
