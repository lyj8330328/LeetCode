package leetcode.problem567;

import java.util.List;

/**
 * @Author: 98050
 * @Time: 2018-11-30 11:01
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        String s1 ="adc";
        String s2 ="dcda";
        System.out.println(checkInclusion(s1,s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        //记录s1在s2中的对应位置
        int length = Math.max(s1.length(),s2.length());
        int[] result = new int[length];
        int k =0;
        for (int i = 0; i < s2.length(); i++){
            if (s1.contains(s2.charAt(i)+"")){
                result[k] = i;
                k++;
            }
        }
        for (int x : result){
            System.out.println(x);
        }
        int count = 0;
        for (int j = 0; j < k; j+=s1.length()){

            for (int m = j; m < s1.length() - 1; m++) {
                if (result[m] + 1 == result[m + 1]) {
                    count++;
                }
            }
            if (count+1 == k){
                return true;
            }
        }
        return false;
    }
}
