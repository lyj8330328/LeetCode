package leetcode.problem322;

/**
 * @Author: 98050
 * @Time: 2018-12-04 20:22
 * @Feature: 零钱兑换
 */
public class Test {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int[] coins2 = new int[]{2};
        int[] coins3 = new int[]{1,2,5,10};
        int[] coins4 = new int[]{83,186,408,419};
        int amount = 11;
        int amount2 = 3;
        int amount3 = 27;
        int amount4 = 6249;
        System.out.println(coinChange(coins,amount));
        System.out.println(coinChange(coins2,amount2));
        System.out.println(coinChange(coins3,amount3));
        System.out.println(coinChange(coins4,amount4));
    }

    public static int coinChange(int[] coins, int amount) {

        if (amount == 0){
            return 0;
        }

        final int row = coins.length + 1;
        final int col = amount + 1;
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0){
                    result[i][j] = 0;
                }else {
                    result[i][j] = col;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (j - coins[i-1] >= 0){
                    result[i][j] = Math.min(result[i-1][j], 1 + result[i][j - coins[i-1]]);
                }else {
                    result[i][j] = Math.min(result[i][j],result[i-1][j]);
                }
            }
        }

        return result[row - 1][col - 1] == col ? -1 : result[row - 1][col - 1];
    }
}
