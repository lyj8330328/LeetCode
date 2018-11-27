package leetcode.problem27;

/**
 * @Author: 98050
 * @Time: 2018-11-21 11:50
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        int[] temp = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(temp,2));
        System.out.println("-----------------------");
        for (Integer i : temp){
            System.out.println(i);
        }
    }

    public static int removeElement(int[] nums, int val) {

        int k = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (val != nums[i]){
                nums[k] = nums[i];
                count ++;
                k++;
            }
        }
        return count;
    }
}
