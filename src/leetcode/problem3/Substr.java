package leetcode.problem3;

import java.util.*;

/**
 * @Author: 98050
 * @Time: 2018-11-03 09:48
 * @Feature: 求不重复字串的长度
 */
public class Substr {

    public static void main(String[] args) {
        String str = "bcaabcc";
        System.out.println(lengthOfLongestSubstring3(str));
    }

    public static int lengthOfLongestSubstring(String s) {

        //转换为字符数组
        char[] str = s.toCharArray();
        //不重复的字串
        String s1 ="";
        int maxLength = 0;
        for (int i = 0; i < str.length;i ++){
            if (!s1.contains(String.valueOf(str[i]))){
                s1+=str[i];
            }else{
                i = i - s1.length();
                maxLength = Math.max(maxLength,s1.length());
                s1 = "";
            }

        }
        if (s1 != ""){
            System.out.println(s1);
            maxLength = Math.max(maxLength,s1.length());
        }

        return maxLength;
    }


    public static int lengthOfLongestSubstring2(String s) {
        //不重复的字串
        Set<Character> s1 = new HashSet<>();
        int maxLength = 0,i = 0,j = 0;
        int n = s.length();
        while (i < n && j < n){
            if (!s1.contains(s.charAt(j))){
                s1.add(s.charAt(j++));
                maxLength = Math.max(maxLength,j-i);
            }else {
                s1.remove(s.charAt(i++));
            }
        }

        return maxLength;
    }


    public static int lengthOfLongestSubstring3(String s) {
        Map<Character,Integer> s1 = new HashMap<>();
        int maxLength = 0;
        int n = s.length();

        for (int i=0,j=0;j<n;j++){
            if (s1.containsKey(s.charAt(j))){
                i = Math.max(s1.get(s.charAt(j)),i);
            }
            maxLength = Math.max(maxLength,j-i+1);
            //为什么要加1,i保存的是真实位置
            s1.put(s.charAt(j),j+1);
        }
        return maxLength;
    }
}
