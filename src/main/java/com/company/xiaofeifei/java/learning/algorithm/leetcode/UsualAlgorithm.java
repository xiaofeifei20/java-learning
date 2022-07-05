package com.company.xiaofeifei.java.learning.algorithm.leetcode;

import com.company.xiaofeifei.java.learning.utils.GsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: 常见的算法
 * @author: zouzy
 * @date: 2021/09/01
 **/
public class UsualAlgorithm {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j-1)){
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode before = temp.next;
            ListNode after = temp.next.next;

            temp.next = after;
            before.next = after.next;
            after.next = before;
            temp = before;
        }
        return dummy.next;
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        while (S.length() > 0) {
            int j = S.lastIndexOf(S.charAt(0));
            int i = 1;
            while (i < j) {
                int k = S.lastIndexOf(S.charAt(i));
                if (k > j) {
                    j = k;
                }
                i++;
            }
            result.add(j + 1);
            S = S.substring(j + 1);
        }
        return result;
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2 ; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int [] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    result[i]++;
                }
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        fet(root, result);
        return result;
    }

    public void fet(TreeNode root, List<Integer> result) {
        result.add(root.val);
        if (root.left != null) {
            fet(root.left, result);
        }
        if (root.right != null) {
            fet(root.right, result);
        }
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            temp.put(arr[i], temp.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> valusSet = new HashSet<>(temp.values());
        return temp.size() == valusSet.size();
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        int tem = 0;
        addd(root, tem, result);
        int res = 0;
        for (Integer data : result) {
            res += data;
        }
        return res;
    }

    public void addd(TreeNode root, int tem, List<Integer> result) {
        tem = tem * 10 + root.val;
        if (root.left != null) {
            addd(root.left, tem , result);
        }
        if (root.right != null) {
            addd(root.right, tem, result);
        }
        if (root.left == null && root.right == null) {
            result.add(tem);
        }
    }

    public int islandPerimeter(int[][] grid) {
        int islandCount = 0;
        int same = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islandCount ++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        same++;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        same++;
                    }
                }
            }
        }
        return islandCount * 4 - same * 2;
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                System.out.println("===");
                System.out.println(nums[j]);
                System.out.println(nums[j] >> i);
                System.out.println(nums[j] >> i & 1);
                System.out.println("===");
                count += (nums[j] >> i & 1);
            }
            System.out.println("***");
            System.out.println(count);
            System.out.println(count % 3);
            System.out.println((res | 1 << i));
            System.out.println("***");
            if (count % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }

    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int len = s.length();
        int dp[] = new int[len];
        Arrays.fill(dp, len-1);
        for(int i = 0; i < len; i++){
            // 注意偶数长度与奇数长度回文串的特点
            mincutHelper(s , i , i , dp);  // 奇数回文串以1个字符为中心
            mincutHelper(s, i , i+1 , dp); // 偶数回文串以2个字符为中心
        }
        return dp[len-1];
    }

    private void mincutHelper(String s, int i, int j, int[] dp){
        int len = s.length();
        while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)){
            dp[j] = Math.min(dp[j] , (i==0?-1:dp[i-1])+1);
            i--;
            j++;
        }
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<String, Boolean> result = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            result.put(words[i], false);
            for (int j = 0; j < words.length; j++) {
                if (i  == j) {
                    continue;
                }
                if (words[i].substring(0, words[i].length() -1).equals(words[j])) {
                    if (result.get(words[j]) != null && result.get(words[j])) {
                        result.put(words[i], true);
                    }
                }
            }
        }
        System.out.println(GsonUtil.toJson(result));
        return result.entrySet().stream()
                .filter(Map.Entry::getValue)
                .max((x1, x2) -> {
                    if (x1.getKey().length() != x2.getKey().length()) {
                        return x1.getKey().compareTo(x2.getKey());
                    } else {
                        return x1.getKey().length() - x2.getKey().length();
                    }
                }).get().getKey();
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> queue = new ArrayList<>();
        addNum(queue, root);
        System.out.println(GsonUtil.toJson(queue));
        for (int i = 0; i < queue.size(); i++) {
            for (int j = 0; j < queue.size(); j++) {
                if (i != j && queue.get(j) == k - queue.get(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addNum(List<Integer> queue, TreeNode node) {
        if (node == null) {
            return;
        }
        queue.add(node.val);
        if (node.left != null) {
            addNum(queue, node.left);
        }
        if (node.right != null) {
            addNum(queue, node.right);
        }
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        List<Integer> answerList = new ArrayList<>();
        Integer num = 0;
        char[] answerChar = answerKey.toCharArray();
        char current = answerChar[0];
        for (char a : answerKey.toCharArray()) {
            if (a == current) {
                num++;
            } else {
                answerList.add(num);
                num = 1;
                current = a;
            }
        }
        answerList.add(num);
        return 0;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int number = Integer.valueOf(i);
            boolean canDividing = true;
            while (true) {
                int num = number % 10;
                if (num != 0) {
                    if (i % num == 0) {
                        if (number < 10) {
                            break;
                        }
                        number = number / 10;
                    } else {
                        canDividing = false;
                        break;
                    }
                } else {
                    canDividing = false;
                    break;
                }
            }
            if (canDividing) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean canReorderDoubled(int[] arr) {
        List<Integer> arrList = new ArrayList<>(arr.length);
        Map<Integer, Integer> mapNum = new HashMap<>();
        for (int num1 : arr) {
            arrList.add(num1);
            mapNum.put(num1, mapNum.getOrDefault(num1, 0) + 1);
        }
        arrList.sort((x1, x2) -> {
                    if (x1 < 0 && x2 < 0) {
                        return x2 - x1;
                    } else {
                        return x1 - x2;
                    }
                }
        );
        System.out.println(arrList);
        System.out.println(mapNum);
        Iterator<Integer> integerIterable = arrList.iterator();
        while (integerIterable.hasNext()) {
            Integer num = integerIterable.next();
            Integer numCount = mapNum.get(num);
            Integer doubleNumCount = mapNum.getOrDefault(num * 2, numCount + 1);
            if (doubleNumCount > numCount) {
                return false;
            }
        }
        return true;
    }

    public int[] plusOne(int[] digits) {
        int plus = 1;
        for(int i = digits.length - 1 ; i >= 0; i--) {
            int result = digits[i] + plus;
            if (result >= 10) {
                digits[i] = result - 10;
                plus = 1;
            } else {
                plus = 0;
                digits[i] = result;
            }
        }
        if (plus > 0) {
            int[] lastResult = new int[digits.length + 1];
            lastResult[0] = 1;
            for (int i = 1; i < lastResult.length; i++) {
                lastResult[i] = digits[i - 1];
            }
            return lastResult;
        } else {
            return digits;
        }
    }

}
