package leetcode.problem20;

/**
 * @Author: 98050
 * @Time: 2018-11-06 10:09
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        String s = "[])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        char[] str = new char[100];
        int k = -1;
        //长度为1，则直接返回false
        if (s.length()  == 1 ){
            return false;
        }
        //空字符串默认为true
        if (s.length()  == 0 ){
            return true;
        }
        str[++k] = s.charAt(0);
        for (int i = 1 ; i < s.length();i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                str[++k] = s.charAt(i);
            }else {
                if (k == -1){
                    return false;
                }
                if ((s.charAt(i) == ')' && str[k] == '(') || (s.charAt(i) == ']' && str[k] == '[') || (s.charAt(i) == '}' && str[k] == '{')){
                    k--;
                }else {
                    return false;
                }

            }
        }
        if (k == -1) {return true;}
        else {return false;}
    }
}
