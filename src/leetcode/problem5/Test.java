package leetcode.problem5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 98050
 * @Time: 2018-11-03 19:03
 * @Feature: 找最长回文子串
 */
public class Test {

    public static void main(String[] args) {

        //String str = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
        //System.out.println(judge(str));
        String str = "abc";
        System.out.println(longestPalindrome2(str));
    }

    //基本方法
    public static String longestPalindrome(String s) {
        String result = "";
        if (s.length() == 0){
            return result;
        }
        if (s.length() == 1){
            return  s;
        }
        int length = 0;
        for (int i = 0; i < s.length();i++){
            List<Integer> list = findX(s,s.charAt(i),i);
            for (Integer t : list){
                if (t > i && t+1 <= s.length()){
                    if(judge(s.substring(i,t+1))){
                        if (s.substring(i,t+1).length() > length) {
                            length = s.substring(i,t+1).length();
                            result = s.substring(i, t+1);
                        }
                    }
                }
            }
        }
        if (result == ""){
            result = s.charAt(s.length() - 1) + "";
        }
        return result;
    }

    public static List<Integer> findX(String s, Character c,int k){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< s.length();i++){
            if (s.charAt(i) == c && k != i){
                list.add(i);
            }
        }
        return list;
    }
    //判断一个字符串是不是回文字符串
    public static boolean judge(String s){
        int n = s.length()-1,i=0;
        while (i<n){
            if (s.charAt(i) == s.charAt(n)){
                i++;
                n--;
            }else {
                break;
            }
        }
        if (i>n || i == n){
            return true;
        }else {
            return false;
        }
    }

    //动态规划
    public static String longestPalindrome2(String s) {
        final int length = s.length();
        int maxLength = 0;
        int start = 0;
        boolean[][] P = new boolean [length][length];
        if (s.length() == 0){
            return "";
        }
        for (int i = 0; i < length; i++){
            P[i][i] = true;
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)){
                P[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        for (int len = 3 ; len <= length ;len ++){ //字串长度
            for (int i = 0 ; i <= length - len; i++){
                /**
                 * 子串结束地址
                 */
                int j=i+len-1;
                if(P[i+1][j-1]&&s.charAt(i)==s.charAt(j))
                {
                    P[i][j]=true;
                    maxLength=len;
                    start=i;
                }
            }
        }
        if (start == 0 && maxLength == 0){
            return s.charAt(s.length() - 1)+"";
        }else if(maxLength >= 2) {
            return s.substring(start, start + maxLength);
        }
        return null;
    }

    public static int strStr(String haystack, String needle) {
        int j =0,i;
        String temp = null;
        int result = -1;
           for (i =0;i<haystack.length();i++){
               if (j < needle.length() && haystack.charAt(i) == needle.charAt(j)){
                   if (i+needle.length() <= haystack.length()) {
                       temp = haystack.substring(i, i + needle.length());
                       if (temp.equals(needle)) {
                           result = i;
                           break;
                       }
                   }else {
                       break;
                   }
               }else {
                   j = 0;
               }
           }
           if (haystack.length() == needle.length() && needle.length() ==0 || haystack.length() != 0 && needle.length() ==0){
               return 0;
           }
         return result;
    }
}
