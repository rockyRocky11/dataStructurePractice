package com.data.structures.practice.LeetCode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        //String s = "(){";
        //String s = "()[]{}";
        String s = "([])";
        System.out.println(isValidMapStack(s));
    }

    public static boolean isValidMapStack(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValidStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c); // Push opening brackets
            } else {
                // Check if the stack is empty or if the brackets don't match
                if (stack.isEmpty() ||
                        (c == ')' && stack.pop() != '(') ||
                        (c == '}' && stack.pop() != '{') ||
                        (c == ']' && stack.pop() != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // Ensure no unmatched opening brackets remain
    }
}
