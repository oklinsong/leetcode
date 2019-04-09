package com.sangang.leetcode.algorithm;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Question15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> mapNums = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            mapNums.put(nums[i], i);
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int value0 = nums[i];
            int target = 0 - value0;
            twoSum(nums, target, i, mapNums, lists);
        }
        return lists;
    }

    private static List<List<Integer>> twoSum(int[] nums, int target, int index, Map<Integer, Integer> map,
                                              List<List<Integer>> result) {

        for (int i = 0; i < nums.length; i++) {
            if (index == i) {
                continue;
            }
            int valueI = nums[i];
            int sub = target - valueI;
            if (map.containsKey(sub) && map.get(sub) != i && map.get(sub) != index) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[index]);
                temp.add(valueI);
                temp.add(sub);
                result.add(temp);
            }
        }
        return result;
    }
}
