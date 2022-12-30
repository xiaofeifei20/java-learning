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

        char[][] data = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
        System.out.println(algorithm.isValidSudoku(data));
    }

}
