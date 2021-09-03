package com.company.xiaofeifei.java.learning.algorithm.leetCode;

/**
 * 用来刷leetcode的草稿
 * @author zouzy
 * @date 2020-01-14
 */
public class Draft {

    public static void main(String[] args) {
        UsualAlgorithm algorithm = new UsualAlgorithm();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        System.out.println(algorithm.minCut("aab"));
        System.out.println(algorithm.minCut("a"));
        System.out.println(algorithm.minCut("ab"));
    }

}
