package ProblemC;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        while (Input.hasNextLine()) {
            String input_string = Input.nextLine();
            boolean is_balanced = checkBalanced(input_string);
            System.out.println(is_balanced);
        }
    }

    public static boolean checkBalanced(String input_string) {
        Stack<Character> stack = new Stack<>();
        for (char c : input_string.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == ')' && top != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}