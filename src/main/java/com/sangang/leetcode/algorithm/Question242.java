package com.sangang.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linsong
 * @date 2019/4/12 13:58
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 **/

public class Question242 {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "art"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (sMap.get(si) != null) {
                sMap.put(si, sMap.get(si) + 1);
            } else {
                sMap.put(si, 1);
            }
            if (tMap.get(ti) != null) {
                tMap.put(ti, tMap.get(ti) + 1);
            } else {
                tMap.put(ti, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            int siCount = sMap.get(si);
            Integer tiCount = tMap.get(si);
            if (tiCount == null || siCount != tiCount) {
                return false;
            }
        }
        return true;
    }
}
