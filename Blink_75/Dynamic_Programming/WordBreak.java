package Blink_75.Dynamic_Programming;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // For O(1) lookup
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string is always segmentable

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && wordSet.contains(word)) {
                    dp[i] = true;
                    break; // Found a valid break, no need to check further
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println(wb.wordBreak(s1, dict1)); // true

        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println(wb.wordBreak(s2, dict2)); // true

        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wb.wordBreak(s3, dict3)); // false
    }
}
