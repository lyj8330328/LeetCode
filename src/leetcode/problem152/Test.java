package leetcode.problem152;

/**
 * @Author: 98050
 * @Time: 2018-12-15 15:40
 * @Feature: 乘积最大子序列
 */
public class Test {


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(maxProduct3(nums));
    }

    public static int maxProduct(int[] nums) {

        final int length = nums.length;
        int tag = Integer.MIN_VALUE;
        if (length == 1){
            return nums[0];
        }
        int[][] result = new int[length][length];
        for (int i = 0; i < length; i++) {
            result[i][i] = nums[i];
            tag = Math.max(result[i][i], tag);
        }
        for (int i = 2; i <= length; i++) {
            for (int j = 0; j <= length - i  ; j++) {
                int col = i + j - 1;
                result[j][col] = result[j][col - 1] * nums[col];
                tag = Math.max(tag, result[j][col]);
            }
        }
        return tag;
    }

    public static int maxProduct2(int[] nums) {

        final int length = nums.length;
        int tag = Integer.MIN_VALUE;
        if (length == 1){
            return nums[0];
        }
        int[] result = nums.clone();

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= length - i  ; j++) {
                int col = i + j - 1;
                if (col != j){
                    result[j] *= nums[col];
                }
                tag = Math.max(tag, result[j]);
            }
        }
        return tag;
    }


    public static int maxProduct3(int[] nums) {
        final int length = nums.length;
        int max = nums[0],min = nums[0],result = nums[0];
        if (length == 1){
            return result;
        }
        for (int i = 1; i < length; i++) {
            if (nums[i] >= 0){
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
            }else {
                int temp = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(temp * nums[i], nums[i]);
            }
            result = Math.max(result, max);
        }

        return result;
    }
}
