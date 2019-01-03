package leetcode.problem74;

/**
 * @Author: 98050
 * @Time: 2019-01-03 13:52
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        int[][] num = new int[2][3];
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //先在矩阵的最后一列中找到一个比target大的值所在的行
        int row = matrix.length;
        if (row == 0){
            return false;
        }
        int col = matrix[0].length;
        if (col == 0){
            return false;
        }
        int tag = 0;
        if (row == 1){
            return binary_search(matrix[0], target);
        }else {
            for (int i = 0; i < row; i++) {
                if (matrix[i][col - 1] > target){
                    tag = i;
                    break;
                }if(matrix[i][col - 1] == target){
                    return true;
                }
            }
            return binary_search(matrix[tag], target);
        }
    }

    public  boolean binary_search(int[] num,int key){
        int low = 0,high = num.length - 1,mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (num[mid] == key){
                return true;
            }else if (num[mid] > key){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return false;
    }
}
