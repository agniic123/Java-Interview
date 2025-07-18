package Zemoso;

import java.util.Stack;

public class ValidPrenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Match closing brackets
            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets were matched
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String input1 = "({[]})";
        String input2 = "(]";
        String input3 = "([)]";
        String input4 = "{[()]}";

        System.out.println(input1 + " → " + isValid(input1)); // true
        System.out.println(input2 + " → " + isValid(input2)); // false
        System.out.println(input3 + " → " + isValid(input3)); // false
        System.out.println(input4 + " → " + isValid(input4)); // true
    }
}
