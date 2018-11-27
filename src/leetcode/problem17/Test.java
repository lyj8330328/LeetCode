package leetcode.problem17;

import java.util.*;

/**
 * @Author: 98050
 * @Time: 2018-11-05 17:18
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        String str ="999";
        letterCombinations(str).forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        List<String> temp = Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        List<String> s;
        if (digits.length() == 0){
            return result;
        }else {
            s = tran(temp.get(Integer.valueOf(digits.charAt(0)+"") - 2));
        }
        if (digits.length() == 1){
            return s;
        }

        for (int i = 1 ; i < digits.length(); i++){
            List<String> k = tran(temp.get(Integer.valueOf(digits.charAt(i)+"") - 2));
            result.clear();
            for (String str : s){
                for (String str2 : k){
                    result.add(str+str2);
                }
            }
            s = new ArrayList<>(result);

        }

        return result;
    }

    public static List<String> tran(String s){
        List<String> temp = new ArrayList<>();
        for (int j = 0;j < s.length();j++){
            temp.add(s.charAt(j)+"");
        }
        return temp;
    }

}
