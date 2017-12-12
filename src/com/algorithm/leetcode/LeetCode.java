package com.algorithm.leetcode;

import com.algorithm.algorithms.union_find.WeightedQuickUnionUF;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by HW
 * on 2017/7/17 19:31.
 */
public class LeetCode {

    /**
     * 1. two sum
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSums(int[] nums, int target){
        int[] result = new int[2];
        breakFor: for(int i = 0; i < nums.length; i++ ){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break breakFor;
                }
            }
        }
        return result;
    }


    //HashMap的使用 及其get方法的时间复杂度, 已掌握
    /**
     * 1. two sum
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSums2(int[] nums, int target){
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = hashMap.get(target - nums[i]);
                break;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return result;
    }



    //TODO 自己重做一遍
    /**
     * 7. Reverse Integer
     * 反转一个数字的各位数字，保持正负值不变
     * @param x
     * @return
     */
    public static int reverse(int x){

        int result = 0;
        while(x != 0){
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if((newResult - tail) / 10 != result){
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }


    //TODO 待做
    /**
     * 28. Implement strStr()
     * 实现类java String.indexOf方法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    //垃圾题目跳过
    /**
     * 122. Best Time to Buy and Sell Stock II
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int count = 0;
        for(int i = 0; i < prices.length-1; i++){
            if(prices[i + 1] > prices[i]) count += prices[i + 1] - prices[i];
        }
        return count;
    }



    /**
     * 128. Longest Consecutive Sequence
     * 给定一个未排序的整数数组，找到最长连续元素序列的长度。
     * 例如，
     * 给予[100,4,2200,1,3,2]
     * 连续元数最长的序列是[1,2,3,4]。 返回长度：4。
     * 您的算法应该以O（n）的复杂度运行。
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0){
            return 0;
        }
        int result = 1;
        int count = 1;
        for(int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1]){//重复数字出现情况
                continue;
            }
            if (nums[i] + 1 == nums[i + 1]){
                count++;
                result = count > result ? count : result;
            } else {
                count =1;
            }
        }
        return result;
    }


    //细看， 重做一遍
    /**
     * 128. Longest Consecutive Sequence
     * 给定一个未排序的整数数组，找到最长连续元素序列的长度。
     * 例如，
     * 给予[100,4,2200,1,3,2]
     * 连续元数最长的序列是[1,2,3,4]。 返回长度：4。
     * 您的算法应该以O（n）的复杂度运行。
     * @param num
     * @return
     */
    public int longestConsecutive1(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;//左边序列的长度
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;//右边序列的长度
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);//key表示num中的值， sum表示该值连续序列长度

                // keep track of the max length
                res = Math.max(res, sum);

                //将连续序列另一个边界的值也对应修改
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }



    //union-find 方法变形 已解决，有空复习
    /**
     * 130. Surrounded Regions
     * 给定一个包含'X'和'O'（字母O）的2D板，捕获被'X'包围的所有区域。
     * 通过将所有'O'转换成包围区域中的X'来捕获一个区域。
     * 将四面被x包围的o全部转换为x
     *   X X X X
         X O O X
         X X O X
         X O X X
            |
         X X X X
         X X X X
         X X X X
         X O X X
     * @param board
     */
    public static void solve(char[][] board) {

        int row = board.length;
        if(row > 0 ){
            int col = board[0].length;

            WeightedQuickUnionUF quickFindUF = new WeightedQuickUnionUF(row * col);

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if((i == 0 || i == row - 1 || j == 0 || j == col - 1) && board[i][j] == 'O'){//将二位数组边界为'O'的均设为与n*m处联通
                        quickFindUF.union( i*(col -1) + j, row * col -1);
                    } else if (board[i][j] == 'O'){//除了边界处的'O'，进行联通判断
                        if(board[i-1][j] == 'O'){//上方处也为'O'
                            System.out.println(true);
                            quickFindUF.union(i*(col -1) + j, (i-1)*(col -1) + j);
                        }
                        if(board[i+1][j] == 'O'){//下方处也为'O'
                            System.out.println(true);
                            quickFindUF.union(i*(col -1) + j, (i+1)*(col -1) + j);
                        }
                        if(board[i][j-1] == 'O'){//左侧处也为'O'
                            System.out.println(true);
                            quickFindUF.union(i*(col -1) + j, i*(col -1) + j - 1);
                        }
                        if(board[i][j+1] == 'O'){//右侧处也为'O'
                            System.out.println(true);
                            quickFindUF.union(i*(col -1) + j, i*(col -1) + j + 1);
                        }
                    }
                }
            }

            //判断各位置与n*m处是否联通，不连通则设为'X'
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++) {
                    if(!quickFindUF.connected(i * (col - 1) + j, row * col - 1)){
                        board[i][j] = 'X';
                    }
                }
            }
        }

    }



    //TODO 待做
    /**
     * 136 Single Number
     * 给定一个数组，除了一个数，别的数都出现两次，找出这个数
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1){
            return nums[0];
        }
        for(int i = 0; i < nums.length; i++) {
            if (i == 0 ) {
                if(nums[i] != nums[i + 1]){
                    return nums[i];
                } else {
                    continue;
                }
            }
            if (i == nums.length - 1) {
                if(nums[i - 1] != nums[i]) {
                    return nums[i];
                } else {
                    continue;
                }
            }
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return Integer.MIN_VALUE;
    }

    //位运算的运用 x ^ x = 0, 0 ^ x = x;
    /**
     * 136 Single Number
     * first , we have to know the bitwise XOR in java
     * 0 ^ N = N
     * N ^ N = 0
     * So..... if N is the single number
     * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
     * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
     * = 0 ^ 0 ^ ..........^ 0 ^ N
     * = N
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }


    /**
     * 167. Two Sum II - Input array is sorted
     * 给定一个已经按升序排序的整数数组，找到两个数字，使它们相加到一个特定的目标数。
     * 函数twoSum应该返回两个数字的索引，使它们相加到目标，其中index1必须小于index2。
     * 请注意，您返回的答案（index1和index2）都不是基于零的。
     * 您可以假设每个输入都只有一个解决方案，您可能不会使用相同的元素两次。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(!map.containsKey(numbers[i])) {
                map.put(target - numbers[i], i + 1);
            } else {
                result[0] = map.get(numbers[i]);
                result[1] = i + 1;
                break;
            }
        }
        return result;
    }






    /**
     * 169 Majority Element
     * 找出出现次数多余 n/2 的数，数组不为空，且该数存在
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        if(nums.length == 1){
            return nums[0];
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                j++;
            } else {
                j = 0;
            }
            if(j >= nums.length / 2){
                return nums[i];
            }
        }
        return nums[0];
    }


    //待细看，仔细理解
    /**
     * 169 Majority Element
     * 找出出现次数多余 n/2 的数，数组不为空，且该数存在
     * @param num
     * @return
     */
    public static int majorityElement1(int[] num) {
        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }



    //再看一遍
    /**
     * 171 Excel Sheet Column Number
     * excle ADF to number
     * 几字符串转为26进制
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            result += ((int)chars[i] - 64) * Math.pow(24 , chars.length - 1 - i);
        }
        return result;
    }



    //union-find 问题 自己解决， 有空回顾
    /**
     * 200. Number of Islands
     * 给定“1”（“土地”）和“0”（水）的二维网格图，计算岛屿数量。
     * 岛被水包围，并通过水平或垂直连接相邻的土地而形成。
     * 您可以假设网格的所有四个边缘都被水包围。
     * union-find 问题
     * @param grid
     * @return
     */
    public static int numIslands1(char[][] grid) {
        int count = 0;//
        int row = grid.length;
        if (row == 0){
            return 0;
        }
        int col = grid[0].length;
        WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(row * col);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){//grid[i][j] && grid[i-1][j]都为陆地，即上方为陆地
                /*if(i > 0 && grid[i][j] == '1' && grid[i-1][j] == '1'){
                    weightedQuickUnionUF.union(i * col + j, (i-1) * col + j);
                }*/
                if(i < row - 1 && grid[i][j] == '1' && grid[i+1][j] == '1'){//grid[i][j] && grid[i+1][j]都为陆地 即下方也为陆地
                    weightedQuickUnionUF.union(i * col + j, (i+1) * col + j);
                }
                /*if(j > 0 && grid[i][j] == '1' && grid[i][j-1] == '1'){//即左侧为陆地
                    weightedQuickUnionUF.union(i * col + j, i* col + j-1);
                }*/
                if(j < col - 1 && grid[i][j] == '1' && grid[i][j+1] == '1'){//即右侧也为陆地
                    weightedQuickUnionUF.union(i * col + j, i* col + j+1);
                }
            }
        }

        //判断该点位陆地且根节点值与其下标值相同
        int[] a = weightedQuickUnionUF.getArray();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(a[i * col + j] == (i * col + j) && grid[i][j] == '1'){
                    count ++;
                }
            }
        }
        return count;
    }


    /**
     * 216. Combination Sum III
     * 查找加数为n的k个数的所有可能组合，只能使用1到9之间的数字，并且每个组合应该是一组唯一的数字。
     * @param k
     * @param n
     * @return
     */
    /*public List<List<Integer>> combinationSum3(int k, int n) {


    }*/





    /**
     * 217. Contains Duplicate
     * 查看数组中是否存在重复值
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            } else {
                map.put(nums[i], 0);
            }
        }
        return false;
    }


    //set的使用
    /**
     * 217. Contains Duplicate
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for(Integer i : set){
            if(set.contains(nums[i])){
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }


    /**
     * 219. Contains Duplicate II
     * Given an array of integers and an integer k,
     * find out whether there are two distinct indices i and j
     * in the array such that nums[i] = nums[j]
     * and the absolute difference between i and j is at most k.
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }


    //厉害的解法， 待细看，数组下标应用， 日后重做一遍
    /**
     * 238. Product of Array Except Self
     * 给定n个整数的数组，其中n> 1，nums返回数组输出，使得output [i]等于nums [i]之外的所有num的元素的乘积。
     * 不用除法和时间复杂度为O（n）。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        /*int[] output = new int[nums.length];
        int total = 1;
        for(int i = 0; i < nums.length; i ++){
            total *= nums[i];
        }

        for(int i = 0; i < nums.length; i ++){
            output[i] = total/nums[i];
        }
        return output;*/

        int len = nums.length;
        if (len == 0)
            return nums;
        int[] output = new int[len];
        int count = 1;

        //前后两次循环相乘，得出结果
        for(int i = 0; i < len; i ++){
            output[i] = count;
            count *= nums[i];
        }
        count = 1;
        for(int i = len - 1; i >= 0; i--){
            output[i] *= count;
            count *= nums[i];
        }
        return output;
    }



    /**
     * 242. Valid Anagram
     * 判断两个字符串是否拥有相同字符
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        int i = s.length();
        int j = t.length();
        char[] c = s.toCharArray();
        char[] d = t.toCharArray();
        if(i != j) {
            return false;
        }

        int[] a = new int[26];
        for(int k = 0; k < 26; k++){
            a[k] = 0;
        }

        for(int k = 0; k < i; k++){
            a[c[k] - 97] += 1;
            a[d[k] - 97] -= 1;
        }

        for(int k = 0; k < 26; k++){
            if(a[k] != 0){
                return false;
            }
        }

        return true;
    }


    /**
     * 242. Valid Anagram
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        /*if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);*/
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }



    //数学解法，无须多看
    /**
     * 258. Add Digits
     * @param num
     * @return
     */
    public int addDigits(int num) {
        /*int sum = 0;
        while(num > 0){
            sum += (num / 10);
            num = num - 10 * sum;
        }
        if(sum < 10){
            return sum;
        } else {
            return addDigits(sum);
        }*/
        return 1 + (num - 1) % 9;
    }



    //思维巧妙，可看
    /**
     * 268 Missing Number
     * 长度为n的数组， 包含0~n的数，且不重复，找出缺少的那个数字
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int sum2 = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sum2 += (i + 1);
        }
        return sum2 - sum;
    }



    /**
     * 283 Move Zeroes
     * Given an array nums,
     * write a function to move all 0's to the end of it
     * while maintaining the relative order of the non-zero elements.
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[j] == 0){
                        continue;
                    } else {
                        int num = nums[i];
                        nums[i] = nums[j];
                        nums[j] = num;
                        break;
                    }
                }
            }
        }
    }

    //待细看
    /**
     * 283 Move Zeroes
     * Given an array nums,
     * write a function to move all 0's to the end of it
     * while maintaining the relative order of the non-zero elements.
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }


    //过于简单，可以跳过
    /**
     * 你和你的朋友一起玩下面的Nim游戏：桌上有一堆石头，每次你们轮流去掉1到3块石头。 去掉最后一块石头的人将是胜利者。
     * 你会采取第一回合去除石头。
     * 你们两个都很聪明，并且有最佳的游戏策略。 写一个函数，以确定是否可以赢得游戏给定堆中的宝石数量。
     * 例如，如果堆中有4块石头，那么你永远不会赢得比赛：无论你去掉1，2或3块石头，最后一块石头总是被你的朋友删除。
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        /*if(n < 4){
            return true;
        } else {
            return ((n - 1) % 4) == 0 || ((n - 2) % 4) == 0 || ((n - 3) % 4) == 0;
        }*/
        return !(n % 4 == 0);
    }





    /**
     * 338. Counting Bits
     * 计算 0 ~ n 每个数二进制表示中1的个数
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 0; i <= num; i++){
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    //待细看
    /**
     * 338. Counting Bits
     * 计算 0 ~ n 每个数二进制表示中1的个数
     * @param num
     * @return
     */
    public static int[] countBits1(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }



    /**
     * 344. Reverse String
     * 倒转字符串
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++){
            char a = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = a;
        }
        return new String(chars);
    }


    //while循环的使用，对半顺序反转的使用
    /**
     * 345. Reverse Vowels of a String
     * 反转字符串中元音字母的顺序
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            while(start < end && !vowels.contains(arr[start] + "")){
                start ++;
            }

            while(start < end && !vowels.contains(arr[end] + "")){
                end--;
            }

            char a = arr[start];
            arr[start] = arr[end];
            arr[end] = a;
            start ++;
            end --;
        }
        return new String(arr);
    }


    //完成，set的使用
    /**
     * 349. Intersection of Two Arrays
     * 给定两个数组，编写一个函数来计算它们的交集。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet();
        Set<Integer> integers = new HashSet<>();
        for(Integer integer : nums1){
            hashSet.add(integer);
        }

        for(Integer integer : nums2){
            if (hashSet.contains(integer)){
               integers.add(integer);
            }
        }
        int[] result = new int[integers.size()];
        int i = 0;
        for(Integer integer : integers){
            result[i++] = integer;
        }
        return result;
    }



    //正则表达式的运用
    /**
     * 383. Ransom Note
     * 判断后一个字符串中是否包含前一个字符串， 可打散
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] notes = ransomNote.toCharArray();
        char[] magas = magazine.toCharArray();
        Arrays.sort(magas);
        String newMagazine = String.valueOf(magas);
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < notes.length; i++){
            if (map.containsKey(notes[i])){
                map.put(notes[i], map.get(notes[i]) + 1);
            } else {
                map.put(notes[i], 1);
            }
        }
        String regax = "[a-z|A-Z]*";
        for(char c : map.keySet()){
            regax += c + "{" + map.get(c) + "}[a-z|A-Z]*";
        }
        return newMagazine.matches(regax);
    }

    /**
     * 383. Ransom Note
     * 判断后一个字符串中是否包含前一个字符串， 可打散
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct1(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            arr[ransomNote.charAt(i) - 'a']++;
        }

        for(int i = 0; i < magazine.length(); i++){
            arr[magazine.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++){
            if(arr[i] > 0) return  false;
        }
        return true;
    }





    //垃圾题目，跳过
    /**
     * 521. Longest Uncommon Subsequence I
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }



    /**
     * 389. Find the Difference
     * 给定两个只包含小写字母的字符串S和T。
     * 字符串T是通过随机洗牌字符串s生成的，然后在随机位置添加一个字母。
     * 查找T中添加的字母。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){//将s中出现的各字符及其次数存入map中
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for (Character c : t.toCharArray()){//遍历t, 找出其中比s多出的char
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) < 0){
                    return c;
                }
            } else {
                return c;
            }
        }
        return 'a';
    }


    //位运算的作用,牢记 x ^ x = 0, x ^ 0 = x
    /**
     * 389. Find the Difference
     * 给定两个只包含小写字母的字符串S和T。
     * 字符串T是通过随机洗牌字符串s生成的，然后在随机位置添加一个字母。
     * 查找T中添加的字母。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference1(String s, String t) {
        char result = 0;
        String st = s + t;
        for(char c : st.toCharArray()){
            result ^= c;
        }
        return result;
    }



    /**
     * 412 fizz buzz
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String s = "";
            if(i % 3 == 0){
                s += "Fizz";
            }
            if(i % 5 == 0){
                s += "Buzz";
            }
            if(s.equals("")){
                s = String.valueOf(i);
            }
            result.add(s);
        }
        return  result;
    }


    //TODO 利用循环解决, 厉害 过段时间后照样写出此方法
    /**
     * 412 fizz buzz
     * @param n
     * @return
     */
    public List<String> fizzBuzz1(int n) {
        List<String> ret = new ArrayList<>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }


    //换个角度思考， 豁然开朗
    /**
     * 419. Battleships in a Board
     * 给定一个2D板，计算出战列舰数量。 战舰以“X”表示，空槽代表“.“。 您可以假设以下规则：
     * 你收到一个有效的板，只由战舰或空槽。
     * 战列舰只能水平或垂直放置。 换句话说，它们只能由1xN（1行，N列）或Nx1（N行，1列）形成，其中N可以是任何大小。
     * 至少有一个水平或垂直的细胞分开在两艘战舰之间 - 没有相邻的战舰。
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int row = board.length;
        if (row == 0){
            return 0;
        }
        int col = board[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(board[i][j] == '.') continue;
                if(board[i][j] == 'X' && (i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.')){
                    count ++;
                }
            }
        }
        return count;
    }





    /**
     * 442 Find All Duplicates in an Array
     * 找出nums[] 中出现两次的数字
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                list.add(nums[i]);
            }
        }
        return list;
    }


    //尚未理解 待看
    /**
     * 442 Find All Duplicates in an Array
     * 找出 nums[n] 中出现两次的数字, 1 =< nums[i] <= n, 且某个数字最多出现两次
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }


    //算法无误，时间复杂度过高
    /**
     * 448. Find All Numbers Disappeared in an Array
     * 给定一个整数数组，其中1≤a[i]≤n（n =数组大小），某些元素出现两次，其他元素出现一次。
     * 找到不出现在这个数组中的[1，n]包含的所有元素。
     * 你可以在没有额外空间的情况下执行它，而在O（n）运行时呢？
     * 您可以假定返回的列表不计入额外的空间。
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(i + 1);
        }
        for(int i = 0; i < nums.length; i++){
            int j = list.indexOf(nums[i]);
            if(j != -1){
                list.remove(j);
            }
        }
        return list;
    }




    //array index 的灵活使用， 抽空复习，重做一遍
    /**
     * 448. Find All Numbers Disappeared in an Array
     * 给定一个整数数组，其中1≤a[i]≤n（n =数组大小），某些元素出现两次，其他元素出现一次。
     * 找到不出现在这个数组中的[1，n]包含的所有元素。
     * 你可以在没有额外空间的情况下执行它，而在O（n）运行时呢？
     * 您可以假定返回的列表不计入额外的空间。
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;//把该值转换为对应数数组下标
            nums[index] = Math.min(nums[index], -nums[index]);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }







    //TODO 超时
    /**
     * 454. 4Sum II
     * 有几组(i, j, k, l) 使得A[i] + B[j] + C[k] + D[l] = 0；
     * @param A 输入数组
     * @param B 输入数组
     * @param C 输入数组
     * @param D 输入数组
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int result = 0;

        Map<Integer, Integer> mapAB = new HashMap();
        Map<Integer, Integer> mapCD = new HashMap();

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int k = A[i] + B[j];
                if(mapAB.containsKey(k)){
                    mapAB.put(k, mapAB.get(k) + 1);
                } else {
                    mapAB.put(k, 1);
                }
            }
        }



        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int k = C[i] + D[j];
                if(mapCD.containsKey(k)){
                    mapCD.put(k, mapCD.get(k) + 1);
                } else {
                    mapCD.put(k, 1);
                }
            }
        }


        for(Integer integerAB : mapAB.keySet()){
            for(Integer integerCD : mapCD.keySet()){
                if(integerAB + integerCD == 0){
                    result += mapAB.get(integerAB) * mapCD.get(integerCD);
                }
            }
        }

        return result;

    }



    //TODO 待看, 重做一遍
    /**
     * 454. 4Sum II
     * 有几组(i, j, k, l) 使得A[i] + B[j] + C[k] + D[l] = 0；
     * @param A 输入数组
     * @param B 输入数组
     * @param C 输入数组
     * @param D 输入数组
     * @return
     */
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;

        Map<Integer, Integer> mapAB = new HashMap();

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int k = A[i] + B[j];
                mapAB.put(k, mapAB.getOrDefault(k, 0) + 1);
            }
        }


        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int k = C[i] + D[j];
                result += mapAB.getOrDefault( -k, 0);
            }
        }

        return result;
    }




    //写法无误， 太过耗时
    /**
     * 459. Repeated Substring Pattern
     * 判断字符串是否为某一小字符串的重复
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++){
            String regax = s.substring(0,i);
            if(s.matches("(" + regax + ")+")){
                return true;
            }
        }

        return false;
    }


    //待细看，研究
    /**
     * 459. Repeated Substring Pattern
     * 判断字符串是否为某一小字符串的重复
     * @param
     * @return
     */
    public boolean repeatedSubstringPattern1(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }



    /**
     * 461 Hamming Distance 汉明距离
     * 转换为二进制码后不同位数
     * @param x
     * @param y
     * @return
     */
    public static int getInstance(int x, int y){
        int result = 0;
        int i = x & y;
        int j = x | y;
        int k = j - i;
        while(k != 0){
            int l = k % 2;
            if(l != 0){
                result += 1;
            }
            k /= 2;
        }
        return  result;
    }

    //Integer.bitCount 计算二进制表示中1的个数
    /**
     * 461 汉明距离
     * @param x
     * @param y
     * @return
     */
    public static int getInstance1(int x, int y){
        return Integer.bitCount(x ^ y);
    }





    /**
     * 463 Island Perimeter
     * 你得到一张二维整数网格的地图，
     * 其中1代表土地，0代表水。
     * 网格完全被水包围，而且正好有一个岛（即，一个或多个相连的陆地单元）。
     * 这个岛没有“湖泊”（里面的水与岛上的水没有联系）。
     * 一个单元格是边长为1的正方形。网格为矩形，宽度和高度不超过100。
     * 确定该岛的周长。
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    perimeter += 4;
                    if(i - 1 >= 0 && grid[i - 1][j] == 1){
                        perimeter --;
                    }
                    if(i + 1 < grid.length && grid[i + 1][j] == 1){
                        perimeter --;
                    }
                    if(j - 1 >= 0 && grid[i][j - 1] == 1){
                        perimeter--;
                    }
                    if(j + 1 < grid[i].length && grid[i][j + 1] == 1){
                        perimeter--;
                    }
                }
            }
        }
        return perimeter;
    }



    /**
     * 463 Island Perimeter
     * 你得到一张二维整数网格的地图，
     * 其中1代表土地，0代表水。
     * 网格完全被水包围，而且正好有一个岛（即，一个或多个相连的陆地单元）。
     * 这个岛没有“湖泊”（里面的水与岛上的水没有联系）。
     * 一个单元格是边长为1的正方形。网格为矩形，宽度和高度不超过100。
     * 确定该岛的周长。
     * @param grid
     * @return
     */
    public static int islandPerimeter1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }




    //待解决， 位运算学习
    /**
     * 476. Number Complement
     * 给定一个正整数，输出它的补数。
     * @param num
     * @return
     */
    public static int findComplement(int num) {
//        int result = 0;
//        Long bit = Long.highestOneBit(num);//返回的值为最高位为1，其余位为0的十进制表示
//        int total = 1;
//        for(int i = 1; i < bit; i++){
//            total += math.pow(2, i);
//        }
//        result = total ^ num;
//        return result;

        int i = 0;
        int j = 0;
        while (i < num){// 该循环得出二进制表示位数与num相同，但各位都为1的数
            i += Math.pow(2, j);
            j++;
        }
        return i ^ num;
    }

    /**
     * 476. Number Complement
     * @param num
     * @return
     */
    public static int findComplement1(int num) {
        int i = 0;
        int j = 0;

        while( i < num){
            i += Math.pow(2, j);
            j++;
        }

        return i - num;
    }



    /**
     * 485 Max Consecutive Ones
     * 0, 1组成的数组，查找该数组中最大连续1的数目。
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        StringBuffer num = new StringBuffer();
        for(int i = 0; i < nums.length; i++){
            num.append(nums[i]);
        }
        String[] arr = num.toString().split("0");
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length() > result){
                result = arr[i].length();
            }
        }
        return result;
    }


    //待细看
    /**
     * 485 Max Consecutive Ones
     * 0, 1组成的数组，查找该数组中最大连续1的数目。
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes1(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
    }


    /**
     * 495. Teemo Attacking
     * 在LOL世界，有一个名叫Teemo的英雄，他的攻击可以使他的敌人Ashe处于中毒状态。
     * 现在，考虑到Teemo对Ashe的攻击上升时间序列和Teemo进攻的中毒时间，您需要输出
     * Ashe处于中毒状态的总时间。
     * 您可以假定Teemo在特定时间点的开始时发生攻击，并使Ashe立即处于中毒状态。
     * Input: [1,4], 2
     * Output: 4
     *
     * Input: [1,2], 2
     * Output: 3
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0;
        for(int i = 0; i < timeSeries.length; i++){
            if(i != timeSeries.length - 1){
                time += timeSeries[1+i] - timeSeries[i] > duration
                        ? duration : timeSeries[1+i] - timeSeries[i];
            } else {
                time += duration;
            }
        }
        return time;
    }




    //题目要求不清，无法解答
    /**
     * 496. Next Greater Element I
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return null;
    }


    //可跳过不看
    /**
     * 500. Keyboard Row
     * 给定一个单词列表，返回只能用一行字母的美国键盘输入的单词
     * @param words 要判断的字符串数组
     * @return 可以用一行键盘打出的字符串数组
     */
    public String[] findWords(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }




    //TODO 进制转换问题以及递归的使用， 可以一看
    /**
     * 504. Base 7
     * 数字转为7进制
     * @param num
     * @return
     */
    public static String convertToBase7(int num) {
        if (num < 0){
            return "-" + convertToBase7(-num);
        }
        if (num < 7){
            return num + "";
        }
        return convertToBase7(num / 7) + num % 7;
    }


    /**
     * 利用队列解决
     * 513. Find Bottom Left Tree Value
     * 给定一个二叉树，找到树的最后一行的最左边的值。
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        int length = treeNodes.size();
        int result = root.val;
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            int size = treeNodes.size();
            TreeNode node = treeNodes.poll();
            result = node.val;
            if(node.left != null){
                treeNodes.offer(node.left);
            }
            if(node.right != null){
                treeNodes.offer(node.right);
            }
            for (int i = 1; i < size; i++){
                TreeNode treeNode = treeNodes.poll();
                if(treeNode.left != null){
                    treeNodes.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    treeNodes.offer(treeNode.right);
                }
            }
        }
        return result;
    }



    //TODO 与自己的解法队列添加以及推出方向相反，瞬间简洁几倍，算法的精妙之处，日后反复研习
    /**
     * 513. Find Bottom Left Tree Value
     * 给定一个二叉树，找到树的最后一行的最左边的值。
     * @param root
     * @return
     */
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }








    //正则表达式的运用
    /**
     * 520. Detect Capital
     * 字符串是否符合'USA','usa','Usa'格式
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }




    /**
     * 535. Encode and Decode TinyURL
     * url加密解密
     */
    private static List<String> urls = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int i = Integer.valueOf(shortUrl);
        return (i < urls.size()) ? urls.get(i) : "";
    }




    //可忽略
    /**
     * 537. Complex Number Multiplication
     * 两个复数 x + -yi计算
     * @param a
     * @param b
     * @return
     */
    public static String complexNumberMultiply(String a, String b) {
        String result = "";
        int num = 0;
        int change = 0;
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        if(as.length == 2 && bs.length == 2){
            as[1] = as[1].substring(0,as[1].length() - 1);
            bs[1] = bs[1].substring(0,bs[1].length() - 1);
            try {
                num = Integer.parseInt(as[0]) * Integer.parseInt(bs[0])
                        - Integer.parseInt(as[1]) * Integer.parseInt(bs[1]);
                change = Integer.parseInt(as[0]) * Integer.parseInt(bs[1])
                        + Integer.parseInt(as[1]) * Integer.parseInt(bs[0]);
            } catch (NumberFormatException e){
                System.out.println("The input plural format is wrong!");
            }
            result = num + "+" + change + "i";
        }
        return result;
    }



    //待细看
    /**
     * 541. Reverse String II
     * 给定一个字符串和一个整数k，
     * 需要从字符串的开始计算每个2K字符的第一个k个字符，并将其倒转。
     * 如果剩下的字符小于k，则将它们全部反转。
     * 如果小于2K，但大于或等于K字符，则反转第一个k字符并将另一个字符作为原来的字符。
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int l = s.length() / (2 * k);
        int j = s.length() % (2 * k);
        for(int i = 0; i < l; i ++){
            for(int m = 0; m < k / 2; m++){
                char a = chars[i * 2 * k + m];
                chars[i * 2 * k + m] = chars[i * 2 * k + k - 1 - m];
                chars[i * 2 * k + k - 1 - m] = a;
            }
        }
        if(j >= k){
            for(int m = 0; m < k / 2; m++){
                char a = chars[l * 2 * k + m];
                chars[l * 2 * k + m] = chars[l * 2 * k + k - 1 - m];
                chars[l * 2 * k + k - 1 - m] = a;
            }
        } else {
            for(int m = 0; m < j / 2; m++){
                char a = chars[l * 2 * k + m];
                chars[l * 2 * k + m] = chars[l * 2 * k + j - 1 - m];
                chars[l * 2 * k + j - 1 - m] = a;
            }
        }

        return new String(chars);
    }


    //待细看
    /**
     * 541. Reverse String II
     * 给定一个字符串和一个整数k，
     * 需要从字符串的开始计算每个2K字符的第一个k个字符，并将其倒转。
     * 如果剩下的字符小于k，则将它们全部反转。
     * 如果小于2K，但大于或等于K字符，则反转第一个k字符并将另一个字符作为原来的字符。
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr1(String s, int k) {
        char[] ca = s.toCharArray();
        for (int left = 0; left < ca.length; left += 2 * k) {
            for (int i = left, j = Math.min(left + k - 1, ca.length - 1); i < j; i++, j--) {
                char tmp = ca[i];
                ca[i] = ca[j];
                ca[j] = tmp;
            }
        }
        return new String(ca);
    }




    //细看union-find算法
    /**
     * union-find 问题
     * 547 Friend Circles
     * 班上有N名学生。 其中有些是朋友，有的则不是朋友。 他们的友谊本质上是传递性的。
     * 例如，如果A是B的直接朋友，B是C的直接朋友，那么A是C的间接朋友。我们定义一个朋友圈是一群
     * 直接或间接的朋友的学生。
     * 给出一个N * N矩阵M代表班级学生之间的朋友关系。 如果M [i] [j] = 1，
     * 那么第i和第j个学生是彼此的直接朋友，否则不是。 你必须输出所有学生中的朋友圈数总数。
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        int n = M.length;
        WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(n);
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                if(M[i][j] == 1){
                    weightedQuickUnionUF.union(i, j);
                }
            }
        }

        return weightedQuickUnionUF.getCount();
    }


    //待细看
    /**
     * union-find 问题
     * 547 Friend Circles
     * @param M
     * @return
     */
    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public static int findCircleNum1(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }




    //正则表达式的运用
    /**
     * 551. Student Attendance Record I
     * 判断字符串中是否有多余一个'A',或多于两个连续'L'
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        if(s.matches("[a-z|A-Z]*A[a-z|A-Z]*A[a-z|A-Z]*") || s.matches("[a-z|A-Z]*L{3,}[a-z|A-Z]*")){
            return false;
        }
        return true;
    }




    /**
     * 557. Reverse Words in a String III
     * 调换一句话中各个词的字母顺序
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        StringBuffer result = new StringBuffer();
        String[] strs = s.split(" ");
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            for (int k = 0; k < chars.length / 2; k++){
                char a = chars[k];
                chars[k] = chars[chars.length - 1 - k];
                chars[chars.length - 1 - k] = a;
            }
            strs[i] = new String(chars);
            result.append(strs[i]);
            if(i == strs.length - 1){
                break;
            }
            result.append(" ");
        }
        return result.toString();
    }



    //StringBuffer reverse方法的使用 其他方法待思考
    /**
     * 557. Reverse Words in a String III
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }



    /**
     * 561. Array Partition I
     * Given an array of 2n integers,
     * your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ..., (an, bn)
     * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);//数组是对象，因而方法中指向数组的值变了，原数组也会改变
        for(int i = 0; i < nums.length; i += 2){
            result += nums[i];
        }
        return result;
    }


    //解法无误，时间复杂度为O(n^2)过于复杂
    /**
     * 565. Array Nesting
     * 给出了由N个不同整数组成的零索引数组A. 该数组包含[0，N-1]范围内的所有整数。
     * 设置0 <= K <N的S [K]定义如下：
     * S [K] = {A [K]，A [A [K]]，A [A [A [K]]]，...}。
     * 集合S [K]对于每个K是有限的，不应包含重复项。
     * 写一个给定由N个整数组成的数组A的函数，返回该数组的最大集合S [K]的大小。
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 1;
            int k = i;
            while (nums[k] != i){
                sum++;
                k = nums[k];
            }
            count = Math.max(count, sum);
        }
        return count;
    }


    //对自己解法的改进，加入了已访问标识
    /**
     * 565. Array Nesting
     * 给出了由N个不同整数组成的零索引数组A. 该数组包含[0，N-1]范围内的所有整数。
     * 设置0 <= K <N的S [K]定义如下：
     * S [K] = {A [K]，A [A [K]]，A [A [A [K]]]，...}。
     * 集合S [K]对于每个K是有限的，不应包含重复项。
     * 写一个给定由N个整数组成的数组A的函数，返回该数组的最大集合S [K]的大小。
     * @param nums
     * @return
     */
    public int arrayNesting1(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }







    //尚未做出
    /**
     * 566. Reshape the Matrix
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r * c != nums.length * nums[0].length){
            return nums;
        }
        int[][] rc = new int[r][c];
        for(int i = 0; i < r * c; i++){
            rc[i / c][i % c] = nums[i / nums[0].length][i % nums[0].length];
        }
        return  rc;
    }



    //解法出错, 无法完成
    /**
     * 575. Distribute Candies
     * 偶数数组，不同数字表示不同种类的糖果。 将这些糖果数量分配给兄妹。
     * 返回妹妹可以获得的最多种类的糖果。
     * @param candies
     * @return
     */
    public static int distributeCandies(int[] candies) {
        //分析可知可分到最大种类为出现双数次糖果种类数+出现单次糖果种类(必为偶数)/2
        int even = 0;//双数糖果种类数
        int singular = 0;//单数糖果出现次数
        Map<Integer, Integer> map = new HashMap<>();
        //计算每类糖果出现次数
        for(int i = 0; i < candies.length; i++){
            if (!map.containsKey(candies[i])){
                map.put(candies[i], 1);
            } else {
                map.put(candies[i], map.get(candies[i])+1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if((entry.getValue() % 2) == 0){//出现双数次
                even++;
            } else {
                if(entry.getValue() == 1){
                    singular ++;
                } else {
                    singular += entry.getValue() / 2 + 1;
                }
            }
        }

        return singular/2 + even;
    }



    //理解思想及hashset的使用
    /**
     * 575. Distribute Candies
     * 偶数数组，不同数字表示不同种类的糖果。 将这些糖果数量分配给兄妹。
     * 返回妹妹可以获得的最多种类的糖果。
     * @param candies
     * @return
     */
    public static int distributeCandies1(int[] candies) {
        HashSet hashSet = new HashSet();
        for(Integer integer : candies) {
            hashSet.add(integer);
            if (hashSet.size() >= candies.length) break;
        }
        //return hashSet.size() > candies.length/2 ? candies.length/2 : hashSet.size()/2;
        return Math.min(candies.length/2, hashSet.size());
    }




    //二叉树相关知识， 递归思想。 待细看
    /**
     * 617. Merge Two Binary Trees
     * 二叉树合并
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        } else if(t1 == null){
            return t2;
        } else if(t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


    //treeNode递归的使用
    /**
     * 637. Average of Levels in Binary Tree
     * 求一个二叉树每层所有节点的平均值
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        List<TreeNode> treeNodeList = new ArrayList<>();
        list.add(root.val/1.0);
        treeNodeList.add(root);
        return getAverage(treeNodeList, list);
    }
    private List<Double> getAverage(List<TreeNode> treeNodes, List<Double> doubles){
        List<TreeNode> treeNodeList = new ArrayList<>();
        double sum = 0;
        double count = 0;//统计该层有几个非空节点
        for(TreeNode treeNode : treeNodes) {
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            if (left != null){
                count ++;
                treeNodeList.add(left);
                sum += left.val;
            }
            if(right != null){
                count++;
                treeNodeList.add(right);
                sum += right.val;
            }
        }
        if (count != 0){
            doubles.add(sum/count);
            return getAverage(treeNodeList, doubles);
        } else {
            return doubles;
        }
    }


    //TODO 队列的使用 先进先出 经常复习
    /**
     * 637. Average of Levels in Binary Tree
     * 求一个二叉树每层所有节点的平均值
     * @param root
     * @return
     */
    public List<Double> averageOfLevels1(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }


    //TODO 换个思路解法一目了然，日后回顾
    /**
     * 647. Palindromic Substrings
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子字符串。
     * 具有不同起始索引或结束索引的子字符串被计为不同的子字符串，即使它们由相同的字符组成。
     * @param s
     * @return
     */
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        for(int i = 0; i < length; i++){//循环字符串的数组，求以该字符为回文中心的回文数
            getPalindromic(s, i, i);//计算奇数长度回文数
            getPalindromic(s, i, i + 1);//计算偶数长度回文数
        }
        return count;
    }
    private void getPalindromic(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count ++;
            i--;
            j++;
        }
    }



    /**
     * 给定一串字符串表示 U D L R 运动， 判断经过运动后是否还在原点
     * 657. Judge Route Circle
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char move : moves.toCharArray()){
            switch (move){
                case 'U' : x++; break;
                case 'D' : x--; break;
                case 'L' : y--; break;
                case 'R' : y++; break;
            }
        }

        return x == 0 && y == 0;
    }


    //垃圾题目， 放弃
    /**
     * 667. Beautiful Arrangement II
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        return res;
    }











    public static void main(String[] args) {

        /*String s = "hppetqceqsbhqcrgrttmjygnibdorreygvfblhfcbiltmczdvuqgtytdayrrqxrytwagghkhsvdezeiuzacuyvxawqrmplmkjmrpwbzqzcuygevhexbfvafrqzfikrstgjlenkuooqmwvhebhhgciovanaiztbszmffbrzpfscenlkqsrzwznrcctkbnnvoaduduvtanxgckqtfhsbjhvllovobllqlomqjhjlvgrxthsyqmzztukgliumtgeguqwdygovofuhonffzhevdrbozwdschawawcyeqvvypeocmtctaxyrapswsmybmxbkzbrrwmrmqgqcbuxdtwuuloqfargoqkzrlqiiecwukozljwpeulyharmckvrafsrqibaodyinnjbygsccdbkfuyketdeavxtfyttcubphnqfvkhxokjvgihkdkqgfnzkmudqohfvuycrimoyyawfkdrpokvvzwglrlbfsjdojhftvwuuwqbgvuvlethepnriyvqtgtjrcrkypgulyvturqfwjmcbbtjcqzxwuinxzaxogrbfowbfnidyvhzybjctkzsfifejhbyqubxkyyrngvldclefwgbggtlqapziszaobxybvsodpzjtmnzitcpbvcrvutfosfdvcdwzvmfkmoeadfjwhaacetxymfnhkscnvborntdbjhcmonlvplxtgxstehaozedwhspvntyxccjrrumghmaolshpbjfcpjyxdouqjunlxxeqttxbhxpuryjsjqwyzuvckrvtmihlhnbbgycnxthqtskcjgakbypnrkhduqqcdsfksjzscjivbtzmbzxezosrabwurnywhdizmktqtcnuxmjyoidpwxgwyfsrsrpzuyajkubdypzxdivrqahmzpkxufqowgpsgqdqmfvmuujzdgrthaiirugozycxguqomteyazkwwvwzbpskpctgxbwyzzwgtoufjbfkcrgymcznruyiwtrvunutosbjgyopbvbdoieamfqgzqqwjhtdxnylhavnylfzjgexqkyfqqnridnrnhwkwuxeustugyvphcmxomegerymxndkwbwvwtzsouputklcozzdmglsxjfuzkgvmcqiyrcmorghcrjsskxesjzsueotovrczjmxdpjrgrakklddxajqjiiemwzdtsftesqhhcyptaaeldhidqapzivnhwqapyttsmaboaqhcqnnvuxznyqoilbphuqyulrmxtnnvfxxykmthkuuimiqxlihfyfzlxllsayoivngiabpkyluktmieurmuwlgvzrobrejprrxtvodtzzduonaigmfdalyzeocxsmmmflfablvckbwyoxjvloalbamfppehdrvieblgmgiyhhxygivtwvfzvtgmikwndryisjqeradzhczpmujirqjojpbuzxhdohnjqdpkdulnykekgnszddnpsojsnsxeaknspecuznjxzoifbcehguwykfsyzrezdtusxwpwmywnmgvqizxqvtrgajgzdmbgfvzctobhozvdfqtnrsgnlxvnidmlppsukryghbnxaiafyvvqnbfyyangfasurmqcfoimsxlsgmaghvwxydvyflgknaeemugrlqfdorxwfzcoubluejskubuhbbloxuhimnnagnynmbbjcndiwyssbpzcqmsniayvpnxxawknxlybadjybeqctrhlgzyobyjsmjpmfzbenzfndqmguelnwsyetzsxzeplnfasgdytddhitvqqzbfxvgbrfwogadspkujrxhkcmtkhobxqedncjrtqpjwroqgzkpqiwckkwxrkapaeuqidhdvymrpdkvcumuekwpuumlfmahsuxdzgguevotayocscyxmwogrcswqufkrdnqlwnqtbjtbaxvcvuprixikpgckondravcyiurlgkoghkkeebypzizqpccdrfwtbaslvjxbwljfxvmczkrassqjwvonakhdnbpkmolkbwqztcbumuugonqlieaipjoekdoxrbhszzrsduprqjyfyosgssrjcfnmidlbettdunyyjnpayphxdzfyrwjvdxilcvohqimlxklgzciyspxxqcvibfdeensgjgpzqcmnoxwoagouylroppyquevarnictyemaqzoqxesesmcffsxurnqvkqozztvxxhzpiphguzkonowtitnziewvunuvgpufytwhlgnffzvvproxmdzvhxqekmbsewzcryjeeyjlxhgmywmlalijiypvmrpqpptipcntdygafppgldrnobzybovnhlewcxhtbuoesuhajygxbzmralrbcnqjauietpxvllbffkfrilqlmccoqwpsjidlclpwcmtnzwtghaxropfaujpkfgeqohbtvqpzekndgikpkjhyzmbvxqfdyjtnsvinnznujczrmlhwvqxweyrbqyeohadbxlpkkegvignurusomrkqpdrfbywkyzmxndhzjqvrwilnefcsxoioubwxbsibtwyibiikydbunojtvllscvjwyftaxdbqbczckjokoredhnydbjxfggdelwgkckbfmciynyibqmexbccenalviozwnigrsjwengcafmbxyhwblziybttlkvhxdooxxkdlrhnytpvtyrwksektagfkdmjiczfalinepackrzdqrzcjemfgsmsxybfdckdnusslswvkwycpyeaeqhkltciufqxhaawxsqimnewlcaccecgxkskfwuzdkwmnyjksbufoydbdedhkiqhukrzhozmyxznwkxolutcszdxdjfntxxphqooepdfpesloszbmvdgwjgzunonkncresikklpzpkkfclgqimwevcfprwebjivnadykqplhzvmdjuttgsadwfsobyplgkajpavfqhoreavpxojdijhfqbtscifivhtkipsawgrcjosgfblnmuseylwawdirledttvtremtpblxgoitcfmhdxfdtjnmwrqrmnmdtyxibkhhbsddxpmaosdkdswbkosweecxcbielrnojqsghgiwanidggesvyqbcsahtinhaavltpsawaywogcwniokhenjznquyfbyizlboddkgcjwklszvilcmymnmeikklkskvvzbylhcwfpjxoffchtctjoarakcmepizolzbucyztjwjodlwyorheryfddrjubkkmkliolhjvfsjiehhubqyupfauzjqawapilxyzhhumzfvfpezquaklhmhgwxjuxaclzakghgtilqocwpsqrfezrlhplqlksnvsnhywntfbjvdfkwycdedwpkocbznvnincsobfhigtdkaniarneujwfxyizldowtqqhtvqbeleoouyollviwrpwpxvdcjbxbrgvozwskdiaxgpktksqdhmsgjxluakvtrsiqrccwldtrudngydjhrdocdbwfltzeojuhlzdwewqabdibirjbwzdbczhnugsipopcpsbvqrvuwdvgwehvfkwhldvhlpqcfhfxcgsuzqovtkbsqknwwjdjnaqaridzsiwuoqongfkcpnuhxhftslchluifdlevvcrjufydkkhbxblwkqrebtmppwuuhapcegnaonfaxmewprsbhjgleuatqwoxyfbeoogedmgaykwobqrlzxwdryyhwogwujaiziocuuevhalkscvratwttvdpljlfvnpuwdxsabnheyrwdpqdimyejbtvnhciwucuzbnzfcgldyjgpzlzojdzlzwyizievmbuoquvsagxapdprqrhaugntdnbevibhjvxzpstsarsswkjpdsrxyetdrwjogkxpgxqxrmpsfkmdwxszpjynnrtgoewupwmxteukqmevwqbsnttcdrssjnbzrzvivjfoqcbgofemwfglazodsiydvbemacvylcobepkuxqivxogxpwdieblzeqogsjeflvjskvojlxginnfdlknqlarrqfykoesczbwmwmvjjcrzryecjruwrmqkrowisomurignwdyihrhasldbczzvlpfffcpasbuklczhfypppwphjuknumjhbqmhsbjncdxphwxmwodoltvwnikjutrxjfgehprluqdbmaqlotzbowyeeknadgyomeuvwniqdlsslidcbcfsafwfpjhuqfjemfzithawtsqgatkexqwyxufndohvwsbiyastksrdnilpdytdqrdnnkarykoueqeeswxcrphezvtctphjikywuzptlfprxuwqstujkeplzjquaxfiidgeevzrdpjajfsbapnltcyuloqnmvywaeafccyfrhhamcdprqamtaigpywdvuzxabecddjwktwzvcomuqanqiwhiskdojconhtskcpwxnvsplgkbgzuoxbwpmbfxeumnnfzruvphthxeojiwiclgfjxtndrtzdgmiffccumvejcuukqeodktnkpcpgvoldawkfamcmigxmcrwswmwihluwnjeixslzoxhojjdtrcftudnsrjczwxxjgctgugfkdmanxdgqiolcrzwjkakhxhsglmmhstrwgulfztwhhjlbihmviwehfwntibadvubdomiphgxpsiscsexccbjhazakadnvxqanelemtbdlmvoezlgbprkpqlbtqpqphrcmcgyvkbhwyvcxikazbkquxsnpjdeqwicyrcwbfdzdabcklcmmpciouvedbiwxryyidulizkmblonwtzkkcvayqectpariyrqdldmmnynaoawjaivedwcwcgrrgibhbtkmwwyjwnjnohyqsuuxqwvufnmlxnszhfnfbmpabaprknhchdzzaxufkishxngeswkvkbvlbkdlamphqrhsodzylrhieqpymbuwcrhfemtezklpbuhrxgpkzzvgpkedlyzpqiwuvrywelnfguxfcosdpnjexohkoiberzaotymxmzeuvdbzutcjimhppetqceqsbhqcrgrttmjygnibdorreygvfblhfcbiltmczdvuqgtytdayrrqxrytwagghkhsvdezeiuzacuyvxawqrmplmkjmrpwbzqzcuygevhexbfvafrqzfikrstgjlenkuooqmwvhebhhgciovanaiztbszmffbrzpfscenlkqsrzwznrcctkbnnvoaduduvtanxgckqtfhsbjhvllovobllqlomqjhjlvgrxthsyqmzztukgliumtgeguqwdygovofuhonffzhevdrbozwdschawawcyeqvvypeocmtctaxyrapswsmybmxbkzbrrwmrmqgqcbuxdtwuuloqfargoqkzrlqiiecwukozljwpeulyharmckvrafsrqibaodyinnjbygsccdbkfuyketdeavxtfyttcubphnqfvkhxokjvgihkdkqgfnzkmudqohfvuycrimoyyawfkdrpokvvzwglrlbfsjdojhftvwuuwqbgvuvlethepnriyvqtgtjrcrkypgulyvturqfwjmcbbtjcqzxwuinxzaxogrbfowbfnidyvhzybjctkzsfifejhbyqubxkyyrngvldclefwgbggtlqapziszaobxybvsodpzjtmnzitcpbvcrvutfosfdvcdwzvmfkmoeadfjwhaacetxymfnhkscnvborntdbjhcmonlvplxtgxstehaozedwhspvntyxccjrrumghmaolshpbjfcpjyxdouqjunlxxeqttxbhxpuryjsjqwyzuvckrvtmihlhnbbgycnxthqtskcjgakbypnrkhduqqcdsfksjzscjivbtzmbzxezosrabwurnywhdizmktqtcnuxmjyoidpwxgwyfsrsrpzuyajkubdypzxdivrqahmzpkxufqowgpsgqdqmfvmuujzdgrthaiirugozycxguqomteyazkwwvwzbpskpctgxbwyzzwgtoufjbfkcrgymcznruyiwtrvunutosbjgyopbvbdoieamfqgzqqwjhtdxnylhavnylfzjgexqkyfqqnridnrnhwkwuxeustugyvphcmxomegerymxndkwbwvwtzsouputklcozzdmglsxjfuzkgvmcqiyrcmorghcrjsskxesjzsueotovrczjmxdpjrgrakklddxajqjiiemwzdtsftesqhhcyptaaeldhidqapzivnhwqapyttsmaboaqhcqnnvuxznyqoilbphuqyulrmxtnnvfxxykmthkuuimiqxlihfyfzlxllsayoivngiabpkyluktmieurmuwlgvzrobrejprrxtvodtzzduonaigmfdalyzeocxsmmmflfablvckbwyoxjvloalbamfppehdrvieblgmgiyhhxygivtwvfzvtgmikwndryisjqeradzhczpmujirqjojpbuzxhdohnjqdpkdulnykekgnszddnpsojsnsxeaknspecuznjxzoifbcehguwykfsyzrezdtusxwpwmywnmgvqizxqvtrgajgzdmbgfvzctobhozvdfqtnrsgnlxvnidmlppsukryghbnxaiafyvvqnbfyyangfasurmqcfoimsxlsgmaghvwxydvyflgknaeemugrlqfdorxwfzcoubluejskubuhbbloxuhimnnagnynmbbjcndiwyssbpzcqmsniayvpnxxawknxlybadjybeqctrhlgzyobyjsmjpmfzbenzfndqmguelnwsyetzsxzeplnfasgdytddhitvqqzbfxvgbrfwogadspkujrxhkcmtkhobxqedncjrtqpjwroqgzkpqiwckkwxrkapaeuqidhdvymrpdkvcumuekwpuumlfmahsuxdzgguevotayocscyxmwogrcswqufkrdnqlwnqtbjtbaxvcvuprixikpgckondravcyiurlgkoghkkeebypzizqpccdrfwtbaslvjxbwljfxvmczkrassqjwvonakhdnbpkmolkbwqztcbumuugonqlieaipjoekdoxrbhszzrsduprqjyfyosgssrjcfnmidlbettdunyyjnpayphxdzfyrwjvdxilcvohqimlxklgzciyspxxqcvibfdeensgjgpzqcmnoxwoagouylroppyquevarnictyemaqzoqxesesmcffsxurnqvkqozztvxxhzpiphguzkonowtitnziewvunuvgpufytwhlgnffzvvproxmdzvhxqekmbsewzcryjeeyjlxhgmywmlalijiypvmrpqpptipcntdygafppgldrnobzybovnhlewcxhtbuoesuhajygxbzmralrbcnqjauietpxvllbffkfrilqlmccoqwpsjidlclpwcmtnzwtghaxropfaujpkfgeqohbtvqpzekndgikpkjhyzmbvxqfdyjtnsvinnznujczrmlhwvqxweyrbqyeohadbxlpkkegvignurusomrkqpdrfbywkyzmxndhzjqvrwilnefcsxoioubwxbsibtwyibiikydbunojtvllscvjwyftaxdbqbczckjokoredhnydbjxfggdelwgkckbfmciynyibqmexbccenalviozwnigrsjwengcafmbxyhwblziybttlkvhxdooxxkdlrhnytpvtyrwksektagfkdmjiczfalinepackrzdqrzcjemfgsmsxybfdckdnusslswvkwycpyeaeqhkltciufqxhaawxsqimnewlcaccecgxkskfwuzdkwmnyjksbufoydbdedhkiqhukrzhozmyxznwkxolutcszdxdjfntxxphqooepdfpesloszbmvdgwjgzunonkncresikklpzpkkfclgqimwevcfprwebjivnadykqplhzvmdjuttgsadwfsobyplgkajpavfqhoreavpxojdijhfqbtscifivhtkipsawgrcjosgfblnmuseylwawdirledttvtremtpblxgoitcfmhdxfdtjnmwrqrmnmdtyxibkhhbsddxpmaosdkdswbkosweecxcbielrnojqsghgiwanidggesvyqbcsahtinhaavltpsawaywogcwniokhenjznquyfbyizlboddkgcjwklszvilcmymnmeikklkskvvzbylhcwfpjxoffchtctjoarakcmepizolzbucyztjwjodlwyorheryfddrjubkkmkliolhjvfsjiehhubqyupfauzjqawapilxyzhhumzfvfpezquaklhmhgwxjuxaclzakghgtilqocwpsqrfezrlhplqlksnvsnhywntfbjvdfkwycdedwpkocbznvnincsobfhigtdkaniarneujwfxyizldowtqqhtvqbeleoouyollviwrpwpxvdcjbxbrgvozwskdiaxgpktksqdhmsgjxluakvtrsiqrccwldtrudngydjhrdocdbwfltzeojuhlzdwewqabdibirjbwzdbczhnugsipopcpsbvqrvuwdvgwehvfkwhldvhlpqcfhfxcgsuzqovtkbsqknwwjdjnaqaridzsiwuoqongfkcpnuhxhftslchluifdlevvcrjufydkkhbxblwkqrebtmppwuuhapcegnaonfaxmewprsbhjgleuatqwoxyfbeoogedmgaykwobqrlzxwdryyhwogwujaiziocuuevhalkscvratwttvdpljlfvnpuwdxsabnheyrwdpqdimyejbtvnhciwucuzbnzfcgldyjgpzlzojdzlzwyizievmbuoquvsagxapdprqrhaugntdnbevibhjvxzpstsarsswkjpdsrxyetdrwjogkxpgxqxrmpsfkmdwxszpjynnrtgoewupwmxteukqmevwqbsnttcdrssjnbzrzvivjfoqcbgofemwfglazodsiydvbemacvylcobepkuxqivxogxpwdieblzeqogsjeflvjskvojlxginnfdlknqlarrqfykoesczbwmwmvjjcrzryecjruwrmqkrowisomurignwdyihrhasldbczzvlpfffcpasbuklczhfypppwphjuknumjhbqmhsbjncdxphwxmwodoltvwnikjutrxjfgehprluqdbmaqlotzbowyeeknadgyomeuvwniqdlsslidcbcfsafwfpjhuqfjemfzithawtsqgatkexqwyxufndohvwsbiyastksrdnilpdytdqrdnnkarykoueqeeswxcrphezvtctphjikywuzptlfprxuwqstujkeplzjquaxfiidgeevzrdpjajfsbapnltcyuloqnmvywaeafccyfrhhamcdprqamtaigpywdvuzxabecddjwktwzvcomuqanqiwhiskdojconhtskcpwxnvsplgkbgzuoxbwpmbfxeumnnfzruvphthxeojiwiclgfjxtndrtzdgmiffccumvejcuukqeodktnkpcpgvoldawkfamcmigxmcrwswmwihluwnjeixslzoxhojjdtrcftudnsrjczwxxjgctgugfkdmanxdgqiolcrzwjkakhxhsglmmhstrwgulfztwhhjlbihmviwehfwntibadvubdomiphgxpsiscsexccbjhazakadnvxqanelemtbdlmvoezlgbprkpqlbtqpqphrcmcgyvkbhwyvcxikazbkquxsnpjdeqwicyrcwbfdzdabcklcmmpciouvedbiwxryyidulizkmblonwtzkkcvayqectpariyrqdldmmnynaoawjaivedwcwcgrrgibhbtkmwwyjwnjnohyqsuuxqwvufnmlxnszhfnfbmpabaprknhchdzzaxufkishxngeswkvkbvlbkdlamphqrhsodzylrhieqpymbuwcrhfemtezklpbuhrxgpkzzvgpkedlyzpqiwuvrywelnfguxfcosdpnjexohkoiberzaotymxmzeuvdbzutcjim";

        System.out.println(repeatedSubstringPattern(s));*/
        //System.out.println( distributeCandies(new int[]{1000, 1, 1, 1}) );
        /*char[][] a ={{'X','X','X','X'},{'X','O','O','X'},{'X','X','X','X'},{'X','O','X','X'}};
        solve(a);
        System.out.println(a[1][2]);*/
        System.out.println(checkIdCard("460104199310290312"));
    }

    private static boolean checkIdCard(String idCard) {
        if(idCard.length() != 18)
            return false;
        int[] coefficients = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String[] lastNumber = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        int result = 0;
        for(int i = 0; i < 17; i++){
            result += Integer.parseInt(String.valueOf(idCard.charAt(i))) * coefficients[i];
        }
        return String.valueOf(idCard.charAt(17)).equals(lastNumber[result % 11]);
    }

}
