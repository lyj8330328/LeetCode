package leetcode.problem12;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 98050
 * @Time: 2018-11-05 21:39
 * @Feature: 数字转罗马数字
 */
public class Test {
    public static void main(String[] args) {
        int num =58;
        System.out.println(intToRoman(num));

    }
    public static String intToRoman(int num) {
        if (num < 1 || num > 3999){
            return null;
        }
        Map<Integer,Character> romanMap = new HashMap<>();
        romanMap.put(1,'I');
        romanMap.put(5,'V');
        romanMap.put(10,'X');
        romanMap.put(50,'L');
        romanMap.put(100,'C');
        romanMap.put(500,'D');
        romanMap.put(1000,'M');
        int s,l,i=0,t;
        String result ="";
        while (num > 0){
            s = num % 10;
            l = (int) Math.pow(10,i);
            if (s == 4){
                result += romanMap.get(l*5);
                result += romanMap.get(l);
            }else if (s == 9){
                result += romanMap.get(l*10);
                result += romanMap.get(l);
            }else {
                for (int k = 0;k<s%5;k++){
                    result+=romanMap.get(l);
                }
                if (s / 5 > 0){
                    result+=romanMap.get(l*5);
                }
            }
            i++;
            num/=10;
        }
        return new StringBuilder(result).reverse().toString();
    }
}
