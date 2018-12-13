package leetcode.problem120;

import sun.applet.Main;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 98050
 * @Time: 2018-12-13 10:34
 * @Feature: 三角形最小路径和
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2);
        List<Integer> integers2 = Arrays.asList(3,4);
        List<Integer> integers3 = Arrays.asList(6,5,7);
        List<Integer> integers4 = Arrays.asList(4,1,8,3);

        List<List<Integer>> triangle = Arrays.asList(integers,integers2,integers3,integers4);

        System.out.println(minimumTotal2(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        final int size = triangle.get(triangle.size() - 1).size();
        int[][] result = new int[size][size];
        result[0][0] = triangle.get(0).get(0);
        if (size == 1){
            return result[0][0];
        }
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < size; i++){
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j - 1 >= 0){

                    if (j == triangle.get(i).size() - 1){
                        result[i][j] = result[i-1][j-1] + triangle.get(i).get(j);
                    }else {
                        result[i][j] = Math.min(result[i -1][j - 1] + triangle.get(i).get(j), result[i -1][j] + triangle.get(i).get(j));
                    }
                }else {
                    result[i][j] = result[i - 1][j] + triangle.get(i).get(j);
                }
                if (i == size - 1){
                    min = Math.min(min, result[i][j]);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%5d",result[i][j]);
            }
            System.out.println();
        }
        return min;

    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        final int size = triangle.get(triangle.size() - 1).size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = triangle.get(triangle.size() - 1).get(i);
        }

        int length = triangle.size() - 2;
        for (int i = length; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                result[j] = Math.min(triangle.get(i).get(j)+result[j], triangle.get(i).get(j)+result[j + 1]);
                System.out.printf("%5d",result[j]);
            }
            System.out.println();
        }
        return result[0];

    }

    public static int minimumTotal3(List<List<Integer>> triangle) {
        Long start = System.currentTimeMillis();
        int length = triangle.size() - 2;
        for (int i = length; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int temp = Math.min(triangle.get(i).get(j)+triangle.get(i + 1).get(j), triangle.get(i).get(j)+triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, temp);
            }
        }
        return triangle.get(0).get(0);
    }

    public static int minimumTotal4(List<List<Integer>> triangle) {
        final int size = triangle.get(triangle.size() - 1).size();
        int[] result = new int[size];
        result[0] = triangle.get(0).get(0);

        int length = triangle.size();
        for (int i = 1; i <length; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j - 1 >= 0) {
                    if (j == triangle.get(i).size() - 1){
                        result[j] = triangle.get(i).get(j) + result[j-1];
                    }else {
                        result[j] = Math.min(triangle.get(i).get(j) + result[j], triangle.get(i).get(j) + result[j - 1]);
                    }
                }else {
                    result[j] = triangle.get(i).get(j) + result[j];
                }
                System.out.printf("%5d",result[j]);
            }
            System.out.println();
        }
        return result[0];

    }
}
