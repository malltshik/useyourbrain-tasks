package ru.malltshik.tasks;

import java.util.Stack;

public class StringCalc {

    public static Double calc(String expression) {
        Stack<Double> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        expression = expression.replace(" ", "");
        char[] chars = expression.toCharArray();
        int N = chars.length;
        for (int i = 0; i < N; i++) {
            char operand = chars[i];
            switch (operand) {
                case '+':
                case '-':
                case '/':
                case '*':
                    ops.push(operand);
                    break;
                case ')':
                    invokeOp(nums, ops);
                    break;
                case '(':
                    break;
                default:
                    nums.push(Double.valueOf(String.valueOf(operand)));
            }
        }
        return nums.pop();
    }

    private static void invokeOp(Stack<Double> nums, Stack<Character> ops) {
        Double val = nums.pop();
        Character op = ops.pop();
        switch (op) {
            case '+':
                val = nums.pop() + val;
                break;
            case '-':
                val = nums.pop() - val;
                break;
            case '*':
                val = nums.pop() * val;
                break;
            case '/':
                val = nums.pop() / val;
                break;
        }
        nums.push(val);
    }

    public static void main(String[] args) {
        System.out.println(calc("(1 + ((2 * 2) * (3 * 3)))"));
    }

}
