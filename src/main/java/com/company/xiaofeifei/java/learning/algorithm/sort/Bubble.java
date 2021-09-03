package com.company.xiaofeifei.java.learning.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 *
 * @author zouzy
 * @date 2019-12-24
 */
public class Bubble {

    public static void main(String[] args) {
        int arrLength = 10;
        int[] arr = new int[arrLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        bubble(arr);
    }

    public static void bubble(int[] arr) {
        if (null == arr || arr.length <= 0) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (flag) {
                break;
            }
        }
    }
}
