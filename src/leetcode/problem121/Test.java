package leetcode.problem121;

/**
 * @Author: 98050
 * @Time: 2018-11-25 17:29
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            for (int j = i+1; j < prices.length; j++){
                if (prices[j] >= prices[i]){
                    result = Math.max(result,(prices[j] - prices[i]));
                }
            }
        }
        return result > 0 ? result : 0;
    }

    public static int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length == 0){
            return 0;
        }
        int min = prices[0],result = 0;
        for (int i = 1; i < length; i++){
            result = Math.max(result,prices[i] - min);
            min = Math.min(prices[i],min);
        }
        return result > 0 ? result : 0;
    }
}
