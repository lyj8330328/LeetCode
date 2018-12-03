package leetcode.problem139;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 98050
 * @Time: 2018-11-27 21:43
 * @Feature:
 */
public class test {

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> wordDict2 = Arrays.asList("leet", "code");
        List<String> wordDict3 = Arrays.asList("aaaa", "aaa");
        List<String> wordDict5 = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        String s1 = "catsandog";
        String s2 = "leetcode";
        String s3 = "aaaaaaa";
        String s5 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(wordBreak(s5,wordDict5));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        final int length = s.length();
        boolean[] result = new boolean[length+1];
        result[0] = true;
        for (int i = 0; i <= length; i++){
            for (int j = 0; j < i; j++){
                if (result[j] && wordDict.contains(s.substring(j,i))){
                    result[i] = true;
                }
            }
        }
        return result[length];

    }
}
