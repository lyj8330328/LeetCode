package leetcode.problem63;

/**
 * @Author: 98050
 * @Time: 2018-11-12 18:25
 * @Feature: 不同路径2
 */
public class Test {

    public static void main(String[] args) {
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i,j = 0;
        for (i = 0 ; i < obstacleGrid.length;i++){
            for (j = 0; j < obstacleGrid[i].length;j++){
                if (i == 0 || j == 0){
                    if (obstacleGrid[i][j] == 1){
                        obstacleGrid[i][j] = -1;
                    }else {
                        if (j > 0){

                            if (obstacleGrid[i][j - 1] == -1) {
                                obstacleGrid[i][j] = -1;
                            } else {
                                obstacleGrid[i][j] = 1;
                            }

                        }
                        if (i > 0){
                            if (obstacleGrid[i - 1][j] == -1){
                                obstacleGrid[i][j] = -1;
                            } else {
                                obstacleGrid[i][j] = 1;
                            }
                        }
                        if (i == 0 && j == 0){
                            obstacleGrid[i][j] = 1;
                        }
                    }
                }else {
                    if (obstacleGrid[i][j] == 1){
                        obstacleGrid[i][j] = -1;
                    }else {
                        if (obstacleGrid[i - 1][j] < 0 || obstacleGrid[i][j - 1] < 0) {
                            obstacleGrid[i][j] = obstacleGrid[i - 1][j] < 0 ? obstacleGrid[i][j - 1] : obstacleGrid[i - 1][j];
                        } else if (obstacleGrid[i - 1][j] > 0 && obstacleGrid[i][j - 1] > 0) {
                            obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                        }
                    }
                }
            }
        }
        if (obstacleGrid[i-1][j-1] == -1){
            return 0;
        }
        return obstacleGrid[i-1][j-1] ;
    }
}

