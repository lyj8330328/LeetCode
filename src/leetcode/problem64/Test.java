package leetcode.problem64;

/**
 * @Author: 98050
 * @Time: 2018-11-13 11:11
 * @Feature: 最小路径和
 */
public class Test {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {

        int i,j=0;
        for (i = 0; i < grid.length; i ++){
            for (j = 0; j < grid[i].length; j ++){
                if (i == 0 || j == 0){
                    if (i > 0){
                        grid[i][j] += grid[i-1][j];
                    }
                    if (j > 0){
                        grid[i][j] += grid[i][j-1];
                    }
                }else {
                    grid[i][j] += grid[i][j-1] > grid[i-1][j] ? grid[i-1][j] : grid[i][j-1];
                }
            }
        }
        return grid[i-1][j-1];
    }
}
