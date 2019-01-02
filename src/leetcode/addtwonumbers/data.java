package leetcode.addtwonumbers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 98050
 * @Time: 2018-12-17 15:34
 * @Feature:
 */
public class data {

    public static void main(String[] args) {

        String str = "A4301812171620550014A10357A20000A3001032A40220A50164A609692A70000A800000";
        String[] temp = str.split("A");
        List<String> result = new ArrayList<>();
        System.out.println();
        for (int i = 2; i < temp.length; i++) {
            result.add(temp[i]);
        }
        for (String s: result){
            System.out.println(s);
        }


// A4301812171620550014A10357A20000A3001032A40220A50164A609692A70000A800000

    }
}
