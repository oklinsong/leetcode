package com.sangang.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Question1 {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 3, 4, 5};
        int target = 9;
        int[] result = towSum1(nums, target);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(towSum2(nums, target)));
    }

    private static int[] towSum1(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            for (; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    private static int[] towSum2(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int valueI = nums[i];
            map.put(valueI, i);
            int sub = target - valueI;
            if (map.containsKey(sub) && map.get(sub) != i) {
                return new int[]{i, map.get(sub)};
            }
        }
        return null;
    }

}
