package leetcode.problem16;


/**
 * @Author: 98050
 * @Time: 2018-11-05 13:56
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {-4,-1,4,4};
        System.out.println(threeSumClosest(nums,-1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3){
            return 0;
        }
        int result = 0 ;
        int interval = Integer.MAX_VALUE;
        sort(nums,0,nums.length-1);
        for (int i = 0 ; i < nums.length - 2; i++){
            int j = i + 1,l = nums.length - 1;
            int sub = target - nums[i];
            while (j < l){
                int temp = nums[j]+nums[l];
                if (temp == sub){
                    return target;
                }else {
                    if (interval > Math.abs(Math.abs(temp) - Math.abs(sub))){
                        interval = Math.abs(Math.abs(temp) - Math.abs(sub));
                        result = temp + nums[i];
                    }
                    if (temp < sub){
                        j++;
                    }else {
                        l--;
                    }
                }
            }
        }
        return  result;
    }


    /**
     *     快速排序
     */
    public static void sort(int[] a,int low,int high ){
        int start = low;
        int end = high;
        int key = a[low];

        if (high > low ) {
            while (start != end) {
                while (end > start && a[end] >= key) {
                    end --;
                }
                if (start < end) {
                    a[start] = a[end];
                    start ++;
                }
                while (end > start && a[start] <= key) {
                    start ++;
                }
                if (start < end) {
                    a[end] = a[start];
                    end --;
                }

            }
            a[start] = key;

            if (start - 1 >= 0) {
                sort(a, low, start - 1);
            }
            if (start + 1 < high) {
                sort(a, start + 1, high);
            }
        }
    }
}
