package com.sangang.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author linsong
 * @date 2019/4/10 14:01
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 **/

public class Question20 {

    public static void main(String[] args) {
        System.out.println(isValid("((][))[]{}"));
    }

    public static boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char right = map.get(c);
                if (stack.empty() || right != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
