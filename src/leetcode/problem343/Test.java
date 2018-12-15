package leetcode.problem343;

/**
 * @Author: 98050
 * @Time: 2018-12-15 11:27
 * @Feature: 整数拆分
 */
public class Test {

    public static void main(String[] args) {

    }

    public static int integerBreak(int n) {
        if (n <= 3){
            return n-1;
        }
        int[] result = new int[n+1];
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <=n; i++){
            result[i] = Math.max(2 * result[i-2],3*result[i-3] );
        }
        return result[n];
    }


    public static int integerBreak2(int n) {
        if (n <= 3){
            return n-1;
        }
        int result = 1;
        while (n > 4 ){
            result*=3;
            n-=3;
        }
        return result * n;
    }

}
