package leetcode.problem33;

/**
 * @Author: 98050
 * @Time: 2019-01-07 21:35
 * @Feature: 搜索旋转排序数组
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search2(nums, 1));
    }

    public static int search(int[] nums, int target) {
        final int length = nums.length;
        if (length == 0){
            return -1;
        }
        int low;
        int high;
        int mid;
        int tag = 0;
        int min = nums[0];
        //1.先找到最小值的位置
        for (int i = 0; i < length; i++) {
            if (nums[i] < min){
                tag = i;
                min = nums[i];
            }
        }

        low = tag;
        high = tag + length - 1;

        while (low <= high){
            int temp = (low + high) / 2;
            if (temp > length - 1){
                mid = temp - length;
            }else {
                mid = temp;
            }
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                high = temp - 1;
            }else {
                low = temp + 1;
            }
        }

        return -1;

    }

    public static int search2(int[] nums, int target) {
        final int length = nums.length;
        if (length == 0){
            return -1;
        }
        int low = 0;
        int high = length - 1;
        int mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < nums[high]){
                //右半部分有序
                if (target > nums[mid] && target<= nums[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }else {
                //左半部分有序
                if (target >= nums[0] && target < nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


}
