package leetcode.problem69;

/**
 * @Author: 98050
 * @Time: 2019-01-06 13:26
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int low = 1;
        int high = x / 2;
        int mid;
        while (low <= high){
            mid = (low + high) / 2;
            int temp = x / mid;
            if (temp == mid){
                return mid;
            }else if (temp < mid){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return high;
    }

}
