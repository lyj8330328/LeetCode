package leetcode.problem304;

/**
 * @Author: 98050
 * @Time: 2018-12-01 22:15
 * @Feature:
 */
class NumMatrix {

    private int[][] result;

    public NumMatrix(int[][] matrix) {

        int row = matrix.length;
        if (row == 0){
            return;
        }
        int col = matrix[0].length;
        result = new int[row][col];
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (j == 0){
                    result[i][j] = matrix[i][j];
                }else {
                    result[i][j] = matrix[i][j] + result[i][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int sum = 0;
        if (col1 == 0){
            for (int i = row1; i <= row2; i++){
                sum += result[i][col2];
            }
        }else {
            for (int i = row1; i <= row2; i++) {
                sum += result[i][col2] - result[i][col2 - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int[][] nums = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(nums);
    }
}
