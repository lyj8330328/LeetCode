package leetcode.problem746;

/**
 * @Author: 98050
 * @Time: 2019-01-21 17:26
 * @Feature:
 */
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);

        System.out.println(solution.pop());
        System.out.println(solution.pop());

        solution.push(4);
        solution.push(5);

        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());

    }
}