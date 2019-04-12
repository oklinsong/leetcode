package com.sangang.leetcode.algorithm;

/**
 * @author linsong
 * @date 2019/4/12 15:43
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * <p>
 * 1 The left subtree of a node contains only nodes with keys less than the node's key.
 * 2 The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3 Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 **/

public class Question98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(9);
        root.left = left;
        root.right = right;
        System.out.println(isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    public static boolean isValidBST(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }
        // 左子树比当前节点大 或者 右子树比当前节点小  就不是二叉搜索树
        if (root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}
