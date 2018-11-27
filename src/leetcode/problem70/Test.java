package leetcode.problem70;

/**
 * @Author: 98050
 * @Time: 2018-11-13 13:12
 * @Feature: 动态规划
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(climbStairsDigui(5));
        System.out.println(factorial(3));
    }

    public static int factorial(int n){
        if (n == 1 || n == 0) {
            return 1;
        }
        int [] T= new int[n+1];
        T[1] = 1;
        for (int j = 2; j <= n; j++){
            T[j]=T[j-1]*j;
        }
        return T[n];
    }

    public static int factorialDigui(int n){
        if (n == 1 || n == 0){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }

    public static int climbStairsDigui(int n){
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }else {
            return climbStairsDigui(n-1)+climbStairsDigui(n-2);
        }
    }

    public int climbStairs(int n) {
        if(n < 2){
            return 1;
        }
        int[] T = new int[n];
        T[0] = 1;
        T[1] = 2;
        for (int i = 2;i < n; i++){
            T[i] = T[i-1] + T[i-2];
        }
        return T[n-1];
    }
}
