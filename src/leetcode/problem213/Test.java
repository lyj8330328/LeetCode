package leetcode.problem213;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 98050
 * @Time: 2018-11-28 10:31
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{2,7,9,3,1};
        int[] nums2 = new int[]{2,3,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
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
        int t1 = compute(nums,2,length-1);
        int t2 = compute(nums,3,length);

        return Math.max(t1,t2);
    }

    private static int compute(int[] nums, int start, int end) {
        int length = nums.length;
        int[] result = new int[length];
        if (start == 2){
            result[0] = nums[0];
            result[1] = Math.max(nums[0],nums[1]);
        }else {
            result[1] = nums[1];
            result[2] = Math.max(nums[1],nums[2]);
        }
        for (int i = start;i < end; i++){
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }
        return result[end - 1];
    }


}
