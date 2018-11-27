package leetcode.problem58;

/**
 * @Author: 98050
 * @Time: 2018-11-24 22:59
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2(" a"));

    }

    public static int lengthOfLastWord(String s) {
        String[] result = s.split("");
        System.out.println(result.length);
        return result[result.length - 1].length();
    }

    public static int lengthOfLastWord2(String s) {
        String str = s.trim();
        if(str.length() == 0 || str.equals(" ")){
            return 0;
        }
        int length = str.length(),i = 0;
        for (i = length - 1; i >= 0; i --){
            if (str.charAt(i) == ' '){
                break;
            }
        }
        if (i < 0) {
            return str.length();
        }
        return length - i - 1;
    }
}
