package ITITWE23014_LTDANH_LAB3.Problem_I;

import java.util.Stack;

class DeciTOctal {
    public static String decimalToOctal(int decimal) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder octal = new StringBuilder();
        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            stack.push(decimal % 8);
            decimal = decimal / 8;
        }
        while (!stack.isEmpty()) {
            octal.append(stack.pop());
        }
        return octal.toString();
    }

    public static <T> Stack<T> concatenateStacks(Stack<T> stack1, Stack<T> stack2) {
        Stack<T> result = new Stack<>();
        while (!stack1.isEmpty()) {
            result.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            result.push(stack2.pop());
        }
        return result;
    }

    public static <T> boolean areStacksIdentical(Stack<T> stack1, Stack<T> stack2) {
        if (stack1.size() != stack2.size()) {
            return false;
        }
        Stack<T> temp1 = (Stack<T>) stack1.clone();
        Stack<T> temp2 = (Stack<T>) stack2.clone();
        while (!temp1.isEmpty()) {
            if (!temp1.pop().equals(temp2.pop())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int decimalNumber = 123;
        System.out.println("Decimal: " + decimalNumber + " => Octal: " + decimalToOctal(decimalNumber));
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);
        Stack<Integer> concatenatedStack = concatenateStacks(stack1, stack2);
        System.out.println("Concatenated Stack: " + concatenatedStack);
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();
        stack3.push(1);
        stack3.push(2);
        stack3.push(3);
        stack4.push(1);
        stack4.push(2);
        stack4.push(3);
        System.out.println("Are stack3 and stack4 identical? " + areStacksIdentical(stack3, stack4));
        stack4.push(4);
        System.out.println("Are stack3 and stack4 identical after modification? " + areStacksIdentical(stack3, stack4));
    }
}