package leetcode.problem322;

/**
 * @Author: 98050
 * @Time: 2018-12-05 16:35
 * @Feature: 完全背包问题
 */
public class Package2 {

    public static void main(String[] args) {
        int[] w = new int[]{2,3,4,7};
        int[] v = new int[]{1,3,5,9};
        int capacity = 10;

        System.out.println(maxValue(w,v,capacity));
        System.out.println(maxValue2(w,v,capacity));

    }

    private static int maxValue(int[] w, int[] v, int capacity) {

        int row = w.length + 1;
        int col = capacity + 1;
        int[][] result = new int[row][col];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (j < w[i - 1]){
                    result[i][j] = result[i-1][j];
                }else {
                    result[i][j] = Math.max(result[i][j-w[i-1]] + v[i-1],result[i-1][j]);
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
        getGoods(result,way,w,v,row-1,col-1);
        System.out.println("选择的物品重量为：");
        for (int i = 0; i < row; i++) {
            if (way[i] != 0){
                System.out.printf("%5d",w[i - 1]);
            }
        }
        System.out.println();

        return result[row-1][col-1];
    }

    private static void getGoods(int[][] result, int[] goods,int[] w,int[] v,int i,int j) {
        if (i >= 1){
            if (result[i][j] == result[i-1][j]){
                goods[i - 1] = 0;
                getGoods(result,goods,w,v,i-1,j);
            }else if (j - w[i - 1] >= 0 && result[i][j] == result[i][j-w[i - 1]] + v[i - 1]){
                goods[i] = 1;
                getGoods(result,goods,w,v,i,j - w[i - 1]);
            }
        }
    }

    private static int maxValue2(int[] w, int[] v, int capacity) {

        //优化
        int length = capacity + 1;
        int[] result = new int[length];

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < w.length; j++){
                if (i >= w[j]){
                    result[i] = Math.max(result[i],result[i - w[j]] + v[j]);
                }
            }
        }

        return result[length-1];
    }
}
