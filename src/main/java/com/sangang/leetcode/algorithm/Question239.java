package com.sangang.leetcode.algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author linsong
 * @date 2019/4/11 13:40
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 **/

public class Question239 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> window = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 当窗口的第一个元素最大时，再滑动窗口，需要把下标pop出去
            if (i >= k && i - k >= window.peek()) {
                window.pop();
            }
            // 当下标队列不为空，且新加入窗口的元素比原窗口的第一个还大，pop掉，直到最大元素在第一个或window为空
            while (window.size() > 0 && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }
            // 把下标加入队列
            window.add(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[window.peek()];
            }
        }
        return res;
    }
}
