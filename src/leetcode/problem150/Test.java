package leetcode.problem150;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: 98050
 * @Time: 2018-11-21 11:16
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        String[] temp = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(temp));
    }

    public static int evalRPN(String[] tokens) {

        List<String> tag = Arrays.asList("+","-","*","/");
        int[] result = new int[tokens.length];
        int k =0;
        for (int i = 0; i < tokens.length; i ++){
            if (tag.contains(tokens[i])){
                int temp = 0;
                switch (tokens[i]){
                    case "+":
                        temp = Integer.valueOf(result[k-2]) + Integer.valueOf(result[k-1]);
                        break;
                    case "-":
                        temp = Integer.valueOf(result[k-2]) - Integer.valueOf(result[k-1]);
                        break;
                    case "*":
                        temp = Integer.valueOf(result[k-2]) * Integer.valueOf(result[k-1]);
                        break;
                    case "/":
                        temp = Integer.valueOf(result[k-2]) / Integer.valueOf(result[k-1]);
                        break;
                        default:
                }
                result[k-1] = 0;
                result[k-2] = temp;
                k --;
            }else {
                result[k++] = Integer.valueOf(tokens[i]);
            }

        }
        return result[0];
    }

}
