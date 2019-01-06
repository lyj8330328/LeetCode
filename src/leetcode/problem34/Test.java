package leetcode.problem34;

/**
 * @Author: 98050
 * @Time: 2019-01-06 14:35
 * @Feature: 在排序数组中查找元素的第一个和最后一个位置
 */
public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{1};
        int[] result = searchRange(nums,1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] searchRange(int[] nums, int target) {

        final int length = nums.length;

        int[] result = new int[2];
        int start = -1,end = -1;
        result[0] = start;
        result[1] = end;

        int low = 0;
        int high = length - 1;
        int mid;
        if (length == 0){
            return result;
        }

        while (low <= high){
            mid = (low + high) / 2;
            if (nums[mid] == target){
                if (mid - 1 < 0){
                    start = mid;
                }else {
                    if (nums[mid - 1] != target){
                        start = mid;
                    }
                }
                high = mid - 1;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        low = 0;
        high = length - 1;

        while (low <= high){
            mid = (low + high) / 2;
            if (nums[mid] == target){
                if (mid + 1 == length){
                    end = mid;
                }else {
                    if (nums[mid + 1] != target){
                        end = mid;
                    }
                }
                low = mid + 1;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        result[0] = start;
        result[1] = end;

        return result;
    }

}
