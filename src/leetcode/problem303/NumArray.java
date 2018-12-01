package leetcode.problem303;

/**
 * @Author: 98050
 * @Time: 2018-12-01 10:31
 * @Feature:
 */
public class NumArray {

    public static void main(String[] args) {

    }



    private int[] sums;

    public  NumArray(int[] nums) {
        final int length = nums.length;
        if (length == 0){
            return;
        }
        sums = new int[length];
        sums[0] = nums[0];
        for (int i = 1; i < length; i++){
            sums[i] = sums[i-1] + nums[i];
        }
    }

    public  int sumRange(int i, int j) {

        System.out.println(i);

        if (i > 0) {
            return sums[j] - sums[i - 1];
        }
        return sums[j] - sums[i];
    }
}
