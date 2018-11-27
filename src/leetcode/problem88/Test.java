package leetcode.problem88;

import java.util.Arrays;

/**
 * @Author: 98050
 * @Time: 2018-11-23 11:20
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge3(nums1,3,nums2,3);
        for (int x :nums1){
            System.out.println(x);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        for (int i = 0; i < nums1.length; i++){
            if (m == nums1.length){
                break;
            }
            if (nums1[i] > nums2[k]){
                int t = m - 1;
                while (t >= i){
                    nums1[t+1] = nums1[t];
                    t--;
                }
                nums1[i] = nums2[k];
                k++;
                m++;
            }else if (i >= m ){
                nums1[i] = nums2[k];
                k++;
            }
        }
    }

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {

    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        for (int i = m; i < nums1.length; i++){
            nums1[i] = nums2[k];
            k++;
        }
        Arrays.sort(nums1);
    }
}
