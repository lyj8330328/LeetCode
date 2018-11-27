package leetcode.problem8;

/**
 * @Author: 98050
 * @Time: 2018-11-07 11:07
 * @Feature:
 */
public class Test {
    public static void main(String[] args) {
        String str="+";
        System.out.println(myAtoi(str));
    }

    /**
     * 该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。
     * 如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。
     * 如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     *
     * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
     *
     * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
     *
     * 若函数不能执行有效的转换，返回 0
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        //找到字符串的第一个非空格字符
        //判断第一个字符是不是数字，如果是继续执行，不是返回0
        //判断第一个数字字符的前一位是+还是-，判断前两位是不是为空，为空那么继续执行，不为空则返回
        //如果数字的下一位不是数字，那么就中断执行
        int l=0,length = str.length();
        boolean  tag = true;
        if(length == 0){
            return 0;
        }
        double result = 0;
        for(int i =0;i<length;i++){
            if(str.charAt(i) != ' '){
                l = i;
                break;
            }
        }
        if(str.charAt(l) == '-' || str.charAt(l) == '+'){
            tag = str.charAt(l) != '-';
            l++;
            if (l >= length){
                return 0;
            }
        }
        if(str.charAt(l) >= '0' && str.charAt(l) <= '9'){
            while(l < length &&str.charAt(l) >= '0' && str.charAt(l) <= '9'){
                if (result > Integer.MAX_VALUE){
                    return tag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + (str.charAt(l) - 48);
                l++;
            }
        }else{
            return 0;
        }

        result = tag ? result : - result;
        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if (result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else {
            return (int) result;
        }

    }
}
