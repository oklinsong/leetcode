package com.sangang.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 3, 4, 5};
        int target = 9;
        int[] result = towsum(nums, target);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(towSum1(nums, target)));
    }

    private static int[] towsum(int[] nums, int target) {
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

    private static int[] towSum1(int[] nums, int target) {
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
