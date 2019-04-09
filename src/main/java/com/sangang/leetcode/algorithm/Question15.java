package com.sangang.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Question15 {
    public static void main(String[] args) {
        int[] num = new int[]{-1, 0, 1, 2, -1, -4, 2};
        System.out.println(threeSum(num).toString());
    }

    private static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            int low = i + 1;
            int high = num.length - 1;
            int sum = 0 - num[i];
            while (low < high) {
                if (num[low] + num[high] == sum) {
                    lists.add(Arrays.asList(num[i], num[low], num[high]));
                    while (low < high && num[low] == num[low - 1]) low++;
                    while (low < high && num[high] == num[high - 1]) high--;
                    low++;
                    high--;
                } else if (num[high] + num[low] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return lists;
    }


}
