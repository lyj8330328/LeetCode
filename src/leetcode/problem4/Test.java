package leetcode.problem4;

/**
 * @Author: 98050
 * @Time: 2019-01-04 12:32
 * @Feature: 寻找两个有序数组的中位数
 */
public class Test {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,2};
        int[] nums2 = new int[]{2,3,4};
        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1 + length2];
        int i = 0,j = 0,k = 0;
        while (i < length1 && j < length2){
            if (nums1[i] < nums2[j]){
                result[k] = nums1[i];
                i++;
            }else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < length1){
            result[k] = nums1[i];
            k++;
            i++;
        }
        while (j < length2){
            result[k] = nums2[j];
            k++;
            j++;
        }
        if (k % 2 == 0){
            return (result[k/2] + result[k/2 - 1]) / 2.0;
        }else {
            return result[k/2];
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        //一定要保证n≥m成立
        if (m > n){
            //交换两个数组
            int[] temp = nums1;
            nums1 = nums2;
            nums2=temp;

            //交换m和n
            int temp2 = m;
            m = n;
            n = temp2;
        }

        int imin = 0,imax = m,half = (m + n + 1) / 2;
        while (imin <= imax){
            int i = (imin + imax) / 2;
            int j = half - i;
            if (i > imin && nums1[i-1] > nums2[j]){
                //nums1[i]太大了，需要小一点
                imax = i - 1;
            }else if (i < imax && nums2[j-1] > nums1[i]){
                //nums1[i]太小了，需要大一点
                imin = i + 1;
            }else {
                //nums1[i]符合划分

                //找左边的最大值
                int leftMax = 0;
                if (i == 0){
                    leftMax = nums2[j-1];
                }else if (j == 0){
                    leftMax = nums1[i-1];
                }else {
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m + n) % 2 == 1){
                    return leftMax;
                }
                //找右边的最小值
                int rightMin = 0;
                if (i == m){
                    rightMin = nums2[j];
                }else if (j == n){
                    rightMin = nums1[i];
                }else {
                    rightMin = Math.min(nums1[i],nums2[j]);
                }
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}
