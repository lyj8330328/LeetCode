package leetcode.problem80;

/**
 * @Author: 98050
 * @Time: 2018-11-25 11:27
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,1,1,1,2};
        int k = removeDuplicates(nums);
        for (int i = 0; i < k; i++){
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        final int length = nums.length;
        if (length < 2){
            return nums.length;
        }
        int k = 0,count = 0;
        for (int i = 1; i < length; i++){
           if (nums[i] == nums[k]){
               count++;
               if (count < 2){
                   nums[++k] = nums[i];
               }
           }else {
               nums[++k] = nums[i];
               count=0;
           }
        }

        return k+1;
    }
}
