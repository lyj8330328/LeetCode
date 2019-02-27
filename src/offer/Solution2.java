package offer;

import java.util.*;

/**
 * @Author: 98050
 * @Time: 2019-02-26 12:52
 * @Feature:
 */

public class Solution2 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //1.一维变二维，找起点
        char[][] result = new char[rows][cols];
        char first = str[0];
        String path = Arrays.toString(str);
        Map<Integer,Integer> map = convert(result,matrix,rows,cols,first);
        //2.从起点开始遍历
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (find(result,entry.getKey(),entry.getValue(),rows,cols,path,"")){
                return true;
            }
        }
        return false;
    }

    private boolean find(char[][] result, Integer i, Integer j, int rows, int cols, String path,String string) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || result[i][j] == '#'){
            return false;
        }
        string += result[i][j];
        if (string.equals(path)){
            return true;
        }
        boolean tag =
        find(result, i - 1, j, rows, cols, path, string) ||
        find(result, i + 1, j, rows, cols, path, string) ||
        find(result, i, j - 1, rows, cols, path, string) ||
        find(result, i, j + 1, rows, cols, path, string);
        if (tag){
            return true;
        }
        result[i][j] = '#';
        return false;
    }


    private Map<Integer, Integer> convert(char[][] result, char[] matrix, int rows, int cols, char first) {
        Map<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[index ++];
                if (result[i][j] == first){
                    map.put(i, j);
                }
            }
        }
        return map;
    }


}