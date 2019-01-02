package leetcode.problem162;

/**
 * @Author: 98050
 * @Time: 2019-01-02 12:46
 * @Feature: 寻找峰值
 */
public class Test {

    public static void main(String[] args) {

    }

    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int low = 0,high = length - 1,mid,temp = 0;
        if (length == 1){
            return 0;
        }
        if (length == 2){
            return nums[0] > nums[1] ? 0: 1;
        }
        while (low < high){
            mid = (low + high) / 2;
            if (mid - 1 < 0){
                temp = 1;
            }
            if (mid + 1 == length){
                temp = -1;
            }
            mid += temp;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }else {
                if (nums[mid] < nums[mid + 1]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        if (low == high){
            return high;
        }
        return -1;
    }
}
