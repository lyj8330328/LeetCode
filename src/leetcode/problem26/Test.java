package leetcode.problem26;

/**
 * @Author: 98050
 * @Time: 2018-11-21 12:03
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        int[] temp = new int[]{0,0,1,1,2,2,3,4};
        System.out.println(removeDuplicates(temp));
        System.out.println("---------------------");
        for (Integer i : temp){
            System.out.println(i);
        }
    }

    public static int removeDuplicates(int[] nums) {

        int k = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[k]){
                k++;
                nums[k] = nums[i];
            }

        }
        return k+1;
    }
}
