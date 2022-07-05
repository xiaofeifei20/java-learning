package com.company.xiaofeifei.java.learning.algorithm.leetcode;

import com.company.xiaofeifei.java.learning.utils.GsonUtil;

import java.util.Arrays;

/**
 * 用来刷leetcode的草稿
 * @author zouzy
 * @date 2020-01-14
 */
public class Draft {

    public static void main(String[] args) {
        UsualAlgorithm algorithm = new UsualAlgorithm();

        System.out.println(Arrays.toString(algorithm.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(algorithm.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(algorithm.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(algorithm.plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(algorithm.plusOne(new int[]{1, 9, 9})));
    }

}
