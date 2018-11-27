package leetcode.problem18;

import java.util.*;

/**
 * @Author: 98050
 * @Time: 2018-11-04 14:54
 * @Feature: 四位数之和
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 1;
        threeSum(nums).forEach(integers -> {
            for (Integer s : integers){
                System.out.print(s+"   ");
            }
            System.out.println();
        });
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = {};
        int s;
        for (int i = 0; i<nums.length;i++){
            s = target - nums[i];
            if (map.containsKey(s)){
                result[0] = i;
                result[1] = map.get(s);
            }
            map.put(nums[i],i);
        }
        return  result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        sort(nums,0,nums.length - 1);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i< nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length - 2;i ++){
            for (int j =i+1;j<nums.length;j++){
                int s = 0 - nums[i] - nums[j];
                if (map.containsKey(s) && map.get(s)!=i && map.get(s)!=j){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(s);
                    Collections.sort(temp);
                    System.out.println();
                    set.add(temp);
                }
            }

        }
        if (nums.length > 3 &&nums[nums.length-1] +nums[nums.length-2] + nums[nums.length-3] == 0){
            List<Integer> temp = Arrays.asList(nums[nums.length-1],nums[nums.length-2],nums[nums.length-3]);
            Collections.sort(temp);
            set.add(temp);
        }
        result.addAll(set);
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 3){
            return result;
        }
        sort(nums,0,nums.length - 1);
        int target,k,j;
        for (int i = 0; i < nums.length -2; i++){
            if (nums[i] >0){
                break;
            }else {
                target = 0 - nums[i];
                k = i + 1;
                j = nums.length - 1;
                while (k < j){
                    int s = nums[k] + nums [j];
                    if (s == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[k]);
                        temp.add(nums[j]);
                        set.add(temp);
                        k++;
                        j--;
                    }else if (s > target){
                        j --;
                    }else {
                        k ++;
                    }
                }
            }
        }

        result.addAll(set);
        return result;
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

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i< nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                for (int k = j+1; k< nums.length;k++){
                    for (int l = k+1 ;l < nums.length; l++){
                        if(i!=j&&j!=k&&k!=l && nums[i] + nums[j] +nums[k] + nums[l] == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        result.addAll(set);
        return result;
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 4){
            return result;
        }
        sort(nums,0,nums.length - 1);
        int sub,k,j;
        for (int i = 0; i< nums.length - 3;i++){
            for (int m = i + 1;m < nums.length - 2;m ++){
                System.out.println("执行");
                sub = target - nums[i] - nums[m];
                k = m + 1;
                j = nums.length - 1;
                while (k < j){
                    int s = nums[k] + nums [j];
                    if (s == sub){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[m]);
                        temp.add(nums[k]);
                        temp.add(nums[j]);
                        set.add(temp);
                        k++;
                        j--;
                    }else if (sub < s){
                        j --;
                    }else {
                        k ++;
                    }
                }

            }
        }
        result.addAll(set);
        return result;
    }


}
