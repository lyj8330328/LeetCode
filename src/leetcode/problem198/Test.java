package leetcode.problem198;

/**
 * @Author: 98050
 * @Time: 2018-11-25 18:04
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        int[] prices = new int[]{2,7,9,3,1};
        System.out.println(rob(prices));
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 0){
            return 0;
        }
        if (length == 1){
            return nums[0];
        }
        if (length == 2){
            return Math.max(nums[0],nums[1]);
        }

        int result = 0;
        for (int i = 2; i < length; i++){
            int temp = i - 2;
            int temp2 = 0;
            for (int k = 0; k <= temp;k++){
               temp2 = Math.max(temp2, nums[i]+nums[k]);
            }
            nums[i] = temp2;
            result = Math.max(nums[i-1],nums[i]);
        }
        return result;
    }


    public static int rob2(int[] nums) {
        final int length = nums.length;
        int[] result = new int[length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++){
            result[i] = Math.max(result[i-2]+nums[i],result[i-1]);
        }
        return result[length-1];
    }

    public static int rob3(int[] nums) {
        final int length = nums.length;
        if (length == 0){
            return 0;
        }
        if (length == 1){
            return nums[0];
        }
        if (length == 2){
            return Math.max(nums[0],nums[1]);
        }
        nums[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++){
            nums[i] = Math.max(nums[i-2]+nums[i],nums[i-1]);
        }
        return nums[length-1];
    }

}
