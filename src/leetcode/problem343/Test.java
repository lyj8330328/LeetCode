package leetcode.problem343;

/**
 * @Author: 98050
 * @Time: 2018-12-15 11:27
 * @Feature: 整数拆分
 */
public class Test {

    private static int p = 0;
    private static int[] res = new int[20];

    public static void main(String[] args) {
        resolve(4,1);
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
    
    public static void resolve(int n,int min){
        if (n <= 0){
            for (int i = 0; i < p; i++) {
                System.out.printf("%5d",res[i]);
            }
            System.out.println();
        }
        for (int i = min; i <= n ; i++) {
            res[p] = i;
            p++;
            resolve(n-i,i);
            p--;
        }
    }





}
