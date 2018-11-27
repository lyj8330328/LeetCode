package leetcode.problem506;

import java.util.*;

/**
 * @Author: 98050
 * @Time: 2018-11-22 22:04
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{123123,11921,1,0,123};
        for (String s : findRelativeRanks2(nums)){
            System.out.println(s);
        }
    }

    public static String[] findRelativeRanks(int[] nums) {
        int[] re = nums.clone();
        Arrays.sort(nums);
        String[] result = new String[nums.length];
        Map<Integer,String> temp2 = new HashMap<>();
        Map<Integer,String> temp = new HashMap<>();
        temp.put(1,"Gold Medal");
        temp.put(2,"Silver Medal");
        temp.put(3,"Bronze Medal");
        int count = 1,k = 0;
        for (int i = nums.length - 1; i >=0; i--){
            if (count <= 3){
                temp2.put(nums[i],temp.get(count));
                count++;
            }else {
                temp2.put(nums[i],nums.length  - i +"");
            }
        }
        for (int i = 0; i < re.length; i++){
            result[i] = temp2.get(re[i]);
        }
        return result;
    }

    public static String[] findRelativeRanks2(int[] nums) {
        int max = 0;

        for (int x: nums){
            if (x > max) {
                max = x;
            }
        }
        Integer[] res = new Integer[max+1];
        Map<Integer,String> temp = new HashMap<>();
        temp.put(1,"Gold Medal");
        temp.put(2,"Silver Medal");
        temp.put(3,"Bronze Medal");
        Map<Integer,Integer> temp2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            res[nums[i]] = nums[i];
            temp2.put(nums[i],i);
        }

        String[] result = new String[nums.length];
        int count = 1;
        for (int i = res.length - 1; i >=0; i --){
            if (res[i] != null){
                if (temp.containsKey(count)){
                    result[temp2.get(res[i])] = temp.get(count);
                    count++;
                }else {
                    result[temp2.get(res[i])] = count+"";
                    count++;
                }

            }
        }

        return result;
    }
}
