package leetcode.poblem35;

/**
 * @Author: 98050
 * @Time: 2018-11-23 09:35
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,7));
    }

    public static int searchInsert(int[] nums, int target) {

        int result = 0,i;
        for (i = 0; i < nums.length; i++){
            if (nums[i] == target){
                result = i;
                break;
            }else if (nums[i] > target){
                result = i;
                break;
            }
        }
        if (result == 0){
            result = i;
        }
        return result;
    }
}
