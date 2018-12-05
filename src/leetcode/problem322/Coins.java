package leetcode.problem322;

/**
 * @Author: 98050
 * @Time: 2018-12-05 14:16
 * @Feature: 零钱兑换问题Ⅱ（换钱的方法数）
 */
public class Coins {

    public static void main(String[] args) {
        int[] coins = new int[]{2,3,5,6};
        int[] coins2 = new int[]{1,2,5};
        int amount = 10;
        int amount2 = 11;
        System.out.println(coinsChange(coins,amount));
        System.out.println(coinsChange(coins2,amount2));
    }

    private static int coinsChange(int[] coins, int amount) {

        int row = coins.length + 1;
        int col = amount + 1;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0 && i != 0){
                    result[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (j >= coins[i - 1]) {
                    result[i][j] = result[i - 1][j] + result[i][j - coins[i - 1]];
                }else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%5d",result[i][j]);
            }
            System.out.println();
        }

        return result[row - 1][col - 1];
    }
}
