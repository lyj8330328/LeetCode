package leetcode.problem53;

/**
 * @Author: 98050
 * @Time: 2018-11-07 22:29
 * @Feature: 最大子序列之和——动态规划
 */
public class Test {
    public static void main(String[] args) {
        int[] num = {8,-19,5,-4,20};
        int s = maxSubArray4(num);
        System.out.println(s);
    }

    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE ;
        final int length = nums.length;
        int [][] P = new int[length][length];
        for (int i = 0; i < length; i++){
            P[i][i] = nums[i];
            result = result < P[i][i] ? P[i][i] : result;
        }
        for (int len = 2; len <= length; len ++){
            for (int i = 0; i <= length - len; i ++){
                int j = i + len - 1;
                int temp = P[i][j-1] + nums[j];
                P[i][j] = temp;
                result = result <= temp ? temp : result;
            }
        }
        return  result;
    }

    public static int maxSubArray2(int[] nums) {
        int result = Integer.MIN_VALUE ;
        final int length = nums.length;
        int [] P = nums.clone();
        for (int len = 1; len <= length; len ++){
            for (int i = 0; i <= length - len; i ++){
                int j = i + len - 1;
                int temp;
                if (i == j){
                    temp = P[i];
                }else {
                    temp =P[i] + nums[j];
                }
                P[i] = temp;
                result = result <= temp ? temp : result;
            }
        }
        return  result;
    }


    public static int maxSubArray4(int[] nums) {
        int result = Integer.MIN_VALUE ;
        final int length = nums.length;
        for (int i = 0; i < length; i++){
            if (nums[i] + result > result) {
                result = nums[i] + result;
            }else {
                if (nums[i] < nums[i - 1]){
                    result = Integer.MIN_VALUE;
                    i--;
                }else {
                    result = nums[i];
                }
            }

        }

        return  result;
    }
}
