package leetcode.problem200;

/**
 * @Author: 98050
 * @Time: 2019-01-21 14:19
 * @Feature: 岛屿个数
 */
public class Test {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        if (row == 0){
            return count;
        }
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count ++;
                    for (int k = 0; k < row; k++) {
                        for (int l = 0; l < col; l++) {
                            System.out.printf("%5c",grid[k][l]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid,int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1,j);
        dfs(grid, i + 1,j);
        dfs(grid, i,j - 1);
        dfs(grid, i,j + 1);
    }
}
