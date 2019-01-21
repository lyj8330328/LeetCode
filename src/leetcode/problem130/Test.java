package leetcode.problem130;

/**
 * @Author: 98050
 * @Time: 2019-01-21 15:47
 * @Feature: 被围绕的区域
 */
public class Test {

    public static void main(String[] args) {
        char[][] temp = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(temp);
    }

    public static void solve(char[][] board) {
        int row = board.length;
        if (row == 0){
            return;
        }
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }

        for (int i = 0; i < col; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '*';
        dfs(board, i - 1,j);
        dfs(board, i + 1,j);
        dfs(board, i,j - 1);
        dfs(board, i,j + 1);
    }

}
