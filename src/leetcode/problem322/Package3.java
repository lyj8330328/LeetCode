package leetcode.problem322;

/**
 * @Author: 98050
 * @Time: 2018-12-05 19:33
 * @Feature: 多重背包
 */
public class Package3 {

    public static void main(String[] args) {
        int[] w = new int[]{1,2,3};
        int[] v = new int[]{6,10,20};
        int[] nums = new int[]{10,5,2};
        int capacity = 8;

        System.out.println(maxValue(w,v,nums,capacity));
        System.out.println(maxValue2(w,v,nums,capacity));
    }

    private static int maxValue(int[] w, int[] v, int[] nums, int capacity) {
        int row = w.length + 1;
        int col = capacity + 1;
        int[][] result = new int[row][col];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (j < w[i - 1]){
                    result[i][j] = result[i-1][j];
                }else {
                    //准备放k件物品
                    int count = Math.min(nums[i - 1], j/w[i - 1]);
                    result[i][j] = Math.max(result[i - 1][j-count * w[i-1]] + count * v[i-1],result[i-1][j]);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%5d",result[i][j]);
            }
            System.out.println();
        }

        int[] way = new int[row];
        getGoods(result,way,w,v,nums,row-1,col-1);
        System.out.println("选择的物品重量为：");
        for (int i = 0; i < row; i++) {
            if (way[i] != 0){
                System.out.println("重量为"+w[i - 1]+"的物品"+way[i]+"个");
            }
        }
        System.out.println();

        return result[row - 1][col - 1];
    }

    private static void getGoods(int[][] result, int[] goods,int[] w,int[] v,int[] nums,int i,int j) {
        if (i >= 1) {
            if (result[i][j] == result[i - 1][j]) {
                goods[i] = 0;
                getGoods(result, goods, w, v, nums, i - 1, j);
            } else {
                int count = Math.min(nums[i - 1], j / w[i - 1]);
                if (j - count * w[i - 1] >= 0 && result[i][j] == result[i - 1][j - count * w[i - 1]] + count * v[i - 1]) {
                    goods[i] = count;
                    getGoods(result, goods, w, v, nums, i - 1, j - count * w[i - 1]);
                }
            }
        }
    }

    private static int maxValue2(int[] w, int[] v, int[] nums, int capacity) {
        //优化
        int length = capacity + 1;
        int[] result = new int[length];

        for (int j = 0; j < w.length; j++){
            for (int i = length - 1; i >= 1; i--) {
                if (w[j] <= i){
                    int count = Math.min(nums[j],i / w[j]);
                    result[i] = Math.max(result[i],result[i - w[j]*count]+v[j]*count);
                }
            }
        }

        return result[length-1];
    }
}
