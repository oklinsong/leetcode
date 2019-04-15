package com.sangang.leetcode.algorithm;

/**
 * @author linsong
 * @date 2019/4/14 10:27
 * <p>
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 **/

public class Question11 {
    public static void main(String[] args) {
        int[] height = {10, 8, 9, 2, 5, 4, 8, 3, 10};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }

    /**
     * 时间复杂度O(n2)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 1;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int w = j - i;
                int h = Math.min(height[i], height[j]);
                max = Math.max(w * h, max);
            }
        }
        return max;
    }

    /**
     * 时间复杂度O(N)
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int width = j - i;
            int h = Math.min(height[i], height[j]);
            maxArea = Math.max(h * width, maxArea);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
