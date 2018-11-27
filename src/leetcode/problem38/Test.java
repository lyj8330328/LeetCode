package leetcode.problem38;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 98050
 * @Time: 2018-11-22 10:47
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {

        String temp = "";
        for (int i = 1; i < 6; i++){
            if (i == 1) {
                temp = get("1");
            }
            else {
                temp = get(temp);
            }
        }
        System.out.println(temp);
    }

    public static String get(String value){

        String str = "";
        int k = 0,i;
        for (i = 1; i < value.length(); i++){
            if (value.charAt(i) != value.charAt(k)){
                str +=((i-k)+""+value.charAt(k));
                k=i;
            }
        }
        str+=(i-k)+""+value.charAt(k);
        return str;
    }
}
