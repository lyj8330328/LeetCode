package leetcode.problem746;

/**
 * @Author: 98050
 * @Time: 2018-11-23 09:51
 * @Feature:
 */
public class Test {

    public static void main(String[] args) {
        int[] cost = new int[]{0,0,0,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n < 2){
            return cost[0];
        }
        int[] T = new int[n];
        T[0] = cost[0];
        T[1] = Math.min(cost[1],cost[0]+cost[1]);
        for (int i = 2; i < n; i++){
            if (i + 1 == n){
                //最后一个台阶
                //1.从倒数第二个直接上来
                //2.从倒数第三个上来
                T[i] = Math.min(T[i - 1],T[i-2] + cost[i]);
            }else {
                T[i] = Math.min(cost[i] + T[i - 1], cost[i] + T[i - 2]);
            }
        }
        for (int x : T){
            System.out.println(x);
        }
        return T[n-1];

    }
}
