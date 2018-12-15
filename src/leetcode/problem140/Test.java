package leetcode.problem140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 98050
 * @Time: 2018-12-02 21:35
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        String s = "catsanddog";
        String s2 = "pineapplepenapple";
        String s3 = "aaaaaaa";
        String s4 = "bb";
        String s5 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> wordDict3 = Arrays.asList("aaaa","aaa");
        List<String> wordDict4 = Arrays.asList("a","b","bbb","bbbb");
        List<String> wordDict5 = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
//        wordBreak(s,wordDict);
//        wordBreak(s2,wordDict2);

        for (String str : wordBreak(s,wordDict)){
            System.out.println(str);
        }
        System.out.println("------------------------------");
        for (String str : wordBreak(s2,wordDict2)){
            System.out.println(str);
        }
        System.out.println("------------------------------");
        for (String str : wordBreak(s3,wordDict3)){
            System.out.println(str);
        }
        System.out.println("------------------------------");
        for (String str : wordBreak(s4,wordDict4)){
            System.out.println(str);
        }
        System.out.println("------------------------------");
        for (String str : wordBreak(s5,wordDict5)){
            System.out.println(str);
        }

    }

    public static boolean[] wordBreakResult(String s, List<String> wordDict){
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
        return result;
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        boolean[] result = wordBreakResult(s,wordDict);
        final int length = result.length - 1;
        //返回最终的结果
        List<List<String>> temp = new ArrayList<>();
        if (result[length]) {
            for (int i = 0; i <= length; i++) {
                List<String> strings = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    if (result[j] && wordDict.contains(s.substring(j, i))) {
                        List<String> list = temp.get(j);
                        if (list.size() > 0) {
                            for (String string : list) {
                                String str = string + " " + s.substring(j, i);
                                if (!string.equals(s.substring(j, i))) {
                                    if (i == length) {
                                        strings.add(str.trim());
                                    } else {
                                        strings.add(str);
                                    }
                                }
                            }
                        }
                    }
                }
                if (strings.size() > 0) {
                    temp.add(i, strings);
                } else {
                    temp.add(Arrays.asList(""));
                }
            }

            List<String> list = temp.get(temp.size() - 1);
            if (list.size() == 1 && list.get(0).equals("")) {
                return new ArrayList<>();
            }
            return list;
        }else {
            return new ArrayList<>();
        }

    }
}
