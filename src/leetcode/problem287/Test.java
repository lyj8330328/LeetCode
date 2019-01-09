package leetcode.problem287;

/**
 * @Author: 98050
 * @Time: 2019-01-08 21:46
 * @Feature: 寻找重复数
 */
public class Test {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        return -1;
    }

    /**
     * 折半查找
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int length = nums.length;
        int low = 1;
        int high = length - 1;
        int mid,count = 0;
        while (low <= high){
            mid = (low + high) / 2;
            for (int i = 0; i < length; i++) {
                if (nums[i] <= nums[mid]){
                    count ++;
                }
            }
            if (count <= mid){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }
}
