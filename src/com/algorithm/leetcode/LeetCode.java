package com.algorithm.leetcode;

import java.util.*;

/**
 * Created by Administrator
 * on 2017/7/17 19:31.
 */
public class LeetCode {

    /**
     * 1. ???????
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

    /**
     * 1. ???????
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

    //???
    /**
     * ??????????
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

    /**
     * fizz buzz????
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

    /**
     * ????????
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

    /**
     * Hamming Distance ????????
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

    /**
     * ????????
     * @param x
     * @param y
     * @return
     */
    public static int getInstance1(int x, int y){
        return Integer.bitCount(x ^ y);
    }


    //?????
    /**
     * ???????
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        int result = 0;
//        Long bit = Long.highestOneBit(num);
//        int total = 1;
//        for(int i = 1; i < bit; i++){
//            total += Math.pow(2, i);
//        }
//        result = total ^ num;
        return result;
    }

    /**
     * ???????
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
     * url??????
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

    /**
     * ???? x + -yi????
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


    /**
     * ??????????????
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
     * ???????????
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    /**
     * ??????????????
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


    /**
     * ??????????????
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


    //?????
    /**
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
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) {
                if (hashMap.containsKey(nums[i]) && (i - map.get(nums[i])) > hashMap.get(nums[i])) {
                    hashMap.put(nums[i], i - nums[i]);
                } else if( !hashMap.containsKey(nums[i]) ) {
                    hashMap.put(nums[i], 0);
                }
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }

        for(Integer i : hashMap.values()){
            if(i <= k){
                return true;
            }
        }
        return false;
    }

    /**
     * Given an array of 2n integers,
     * your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ..., (an, bn)
     * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);//??????????????????????????????????????????
        for(int i = 0; i < nums.length; i += 2){
            result += nums[i];
        }
        return result;
    }

    /**
     * Given a List of words,
     * return the words that can be typed using letters of alphabet on
     * only one row's of American keyboard like the image below.
     * ??????????????????????????.
     * @param words
     * @return
     */
    /*public static String[] findWords(String[] words) {

    }*/

    /**
     * ???? 0 ~ n ???????????1?????
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

    //???
    /**
     * ???? 0 ~ n ???????????1?????
     * @param num
     * @return
     */
    public static int[] countBits1(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    /**
     * ????????????????
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

    /**
     * ????????????????
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


    //???
    /**
     * ?????????????????????k??
     * ?????????????????????2K?????????k???????
     * ?????????????k????????????????
     * ??????2K????????????K?????
     * ????????k?????????????????
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int l = s.length() / (2 * k); //??????2k
        int j = s.length() % (2 * k); //???????????????;
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


    //???
    /**
     * ?????????????????????k??
     * ?????????????????????2K?????????k???????
     * ?????????????k????????????????
     * ??????2K????????????K?????
     * ????????k?????????????????
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

    /**
     * Island Perimeter
     * ????????????????
     * ????1?????????0???????
     * ???????????/????????????????
     * ??????????????????????????????????????????????????????????
     * ???????????????????????????????????????
     * ?????????????1?????????
     * ?????????????????????100??
     * ?????????????
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
     * Island Perimeter
     * ????????????????
     * ????1?????????0???????
     * ???????????/????????????????
     * ??????????????????????????????????????????????????????????
     * ???????????????????????????????????????
     * ?????????????1?????????
     * ?????????????????????100??
     * ?????????????
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


    //???????
    /**
     * Reshape the Matrix
     * ????????r * c ????
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

    //??union-find?????????
    /**
     * union-find ????
     * Friend Circles
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        int num = 1;
        int N = M.length;
        int[] students = new int[N];
        for(int i = 0; i < students.length; i++){
            students[i] = i;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(M[i][j] == 1){
                    for(int k = 0; k < N; k++){
                        if(students[k] == students[i]){
                            students[k] = students[j];
                        }
                    }
                }
            }
        }
        Arrays.sort(students);
        for(int i = 0; i < N-1; i++){
            if(students[i] != students[i + 1]){
                num++;
            }
        }
        return num;
    }


    /**
     * union-find ????
     * Friend Circles
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


    //?????
    /**
     * union-find ????
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int r = grid.length;
        int col = grid[0].length;
        int[] nums = new int[r * col];
        for(int i = 0; i < r * col; i++){
            nums[i] = i;
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && grid[i][j-1] == '1' && (j - 1) > 0){
                    for(int k = 0; k < r * col; k++){
                        if(nums[k] == nums[i * j]){
                            nums[k] = nums[i *(j - 1)];
                        }
                    }
                }

                if(grid[i][j] == '1' && grid[i][j+1] == '1' && (j + 1) < col){
                    for(int k = 0; k < r * col; k++){
                        if(nums[k] == nums[i * j]){
                            nums[k] = nums[i *(j + 1)];
                        }
                    }
                }

                if(grid[i - 1][j] == '1' && grid[i][j] == '1' && (i - 1) > 0){
                    for(int k = 0; k < r * col; k++){
                        if(nums[k] == nums[i * j]){
                            nums[k] = nums[(i - 1) *j];
                        }
                    }
                }

                if(grid[i][j] == '1' && grid[i][j] == '1' && (i + 1) < r){
                    for(int k = 0; k < r * col; k++){
                        if(nums[k] == nums[i * j]){
                            nums[k] = nums[(i + 1) * j];
                        }
                    }
                }
            }
        }

        int num = 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] != nums[i + 1]){
                num++;
            }
        }
        return num;
    }


    /**
     * Find All Duplicates in an Array
     * ???????????????1??a[i]??N??N =???????,???????????????????
     * ??????????????????????????
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

    /**
     * Single Number
     * ????????????????????????????????????????????????????????????
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

    //???????ü??
    /**
     * Single Number
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
     * Max Consecutive Ones
     * 0, 1???????????????????1????
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


    //???
    /**
     * Max Consecutive Ones
     * 0, 1???????????????????1????
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes1(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
    }

    //?????
    /**
     * ?????????????7????
     * @param num
     * @return
     */
    public static String convertToBase7(int num) {
        String result = "";
        while(num > 7){
            int re = num % 7;
            num /= 7;
            result = re + result;
        }
        result = num + result;
        return result;
    }

    /**
     * Move Zeroes
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

    //?????????????
    /**
     * Move Zeroes
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

    /**
     * Excel Sheet Column Number
     * excle ADF ? ????
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

    /**
     * Majority Element
     * ???????????????????n/2?????????????????????
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


    //???
    /**
     *
     * Majority Element
     * ???????????????????n/2?????????????????????
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


    /**
     * Missing Number
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

    //?????????
    /**
     * 258. Add Digits
     * ?????
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


    //????????????????
    /**
     * 520. Detect Capital
     * ??????????????
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
       return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

    //??????
    /**
     * ????????
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }


    //????????
    /**
     * 383. Ransom Note
     * ???????????????????
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
     * ???????????????????
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

    //正则表达式的运用
    /**
     * 551. Student Attendance Record I
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        if(s.matches("[a-z|A-Z]*A[a-z|A-Z]*A[a-z|A-Z]*") || s.matches("[a-z|A-Z]*L{3,}[a-z|A-Z]*")){
            return false;
        }
        return true;
        //!s.matches(".*LLL.*|.*A.*A.*");
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


    //二叉树相关知识， 递归思想。
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


    //待做
    /**
     * 28. Implement strStr()
     * 实现类java String。indexOf方法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }



















    public static void main(String[] args) {

        String s = "hppetqceqsbhqcrgrttmjygnibdorreygvfblhfcbiltmczdvuqgtytdayrrqxrytwagghkhsvdezeiuzacuyvxawqrmplmkjmrpwbzqzcuygevhexbfvafrqzfikrstgjlenkuooqmwvhebhhgciovanaiztbszmffbrzpfscenlkqsrzwznrcctkbnnvoaduduvtanxgckqtfhsbjhvllovobllqlomqjhjlvgrxthsyqmzztukgliumtgeguqwdygovofuhonffzhevdrbozwdschawawcyeqvvypeocmtctaxyrapswsmybmxbkzbrrwmrmqgqcbuxdtwuuloqfargoqkzrlqiiecwukozljwpeulyharmckvrafsrqibaodyinnjbygsccdbkfuyketdeavxtfyttcubphnqfvkhxokjvgihkdkqgfnzkmudqohfvuycrimoyyawfkdrpokvvzwglrlbfsjdojhftvwuuwqbgvuvlethepnriyvqtgtjrcrkypgulyvturqfwjmcbbtjcqzxwuinxzaxogrbfowbfnidyvhzybjctkzsfifejhbyqubxkyyrngvldclefwgbggtlqapziszaobxybvsodpzjtmnzitcpbvcrvutfosfdvcdwzvmfkmoeadfjwhaacetxymfnhkscnvborntdbjhcmonlvplxtgxstehaozedwhspvntyxccjrrumghmaolshpbjfcpjyxdouqjunlxxeqttxbhxpuryjsjqwyzuvckrvtmihlhnbbgycnxthqtskcjgakbypnrkhduqqcdsfksjzscjivbtzmbzxezosrabwurnywhdizmktqtcnuxmjyoidpwxgwyfsrsrpzuyajkubdypzxdivrqahmzpkxufqowgpsgqdqmfvmuujzdgrthaiirugozycxguqomteyazkwwvwzbpskpctgxbwyzzwgtoufjbfkcrgymcznruyiwtrvunutosbjgyopbvbdoieamfqgzqqwjhtdxnylhavnylfzjgexqkyfqqnridnrnhwkwuxeustugyvphcmxomegerymxndkwbwvwtzsouputklcozzdmglsxjfuzkgvmcqiyrcmorghcrjsskxesjzsueotovrczjmxdpjrgrakklddxajqjiiemwzdtsftesqhhcyptaaeldhidqapzivnhwqapyttsmaboaqhcqnnvuxznyqoilbphuqyulrmxtnnvfxxykmthkuuimiqxlihfyfzlxllsayoivngiabpkyluktmieurmuwlgvzrobrejprrxtvodtzzduonaigmfdalyzeocxsmmmflfablvckbwyoxjvloalbamfppehdrvieblgmgiyhhxygivtwvfzvtgmikwndryisjqeradzhczpmujirqjojpbuzxhdohnjqdpkdulnykekgnszddnpsojsnsxeaknspecuznjxzoifbcehguwykfsyzrezdtusxwpwmywnmgvqizxqvtrgajgzdmbgfvzctobhozvdfqtnrsgnlxvnidmlppsukryghbnxaiafyvvqnbfyyangfasurmqcfoimsxlsgmaghvwxydvyflgknaeemugrlqfdorxwfzcoubluejskubuhbbloxuhimnnagnynmbbjcndiwyssbpzcqmsniayvpnxxawknxlybadjybeqctrhlgzyobyjsmjpmfzbenzfndqmguelnwsyetzsxzeplnfasgdytddhitvqqzbfxvgbrfwogadspkujrxhkcmtkhobxqedncjrtqpjwroqgzkpqiwckkwxrkapaeuqidhdvymrpdkvcumuekwpuumlfmahsuxdzgguevotayocscyxmwogrcswqufkrdnqlwnqtbjtbaxvcvuprixikpgckondravcyiurlgkoghkkeebypzizqpccdrfwtbaslvjxbwljfxvmczkrassqjwvonakhdnbpkmolkbwqztcbumuugonqlieaipjoekdoxrbhszzrsduprqjyfyosgssrjcfnmidlbettdunyyjnpayphxdzfyrwjvdxilcvohqimlxklgzciyspxxqcvibfdeensgjgpzqcmnoxwoagouylroppyquevarnictyemaqzoqxesesmcffsxurnqvkqozztvxxhzpiphguzkonowtitnziewvunuvgpufytwhlgnffzvvproxmdzvhxqekmbsewzcryjeeyjlxhgmywmlalijiypvmrpqpptipcntdygafppgldrnobzybovnhlewcxhtbuoesuhajygxbzmralrbcnqjauietpxvllbffkfrilqlmccoqwpsjidlclpwcmtnzwtghaxropfaujpkfgeqohbtvqpzekndgikpkjhyzmbvxqfdyjtnsvinnznujczrmlhwvqxweyrbqyeohadbxlpkkegvignurusomrkqpdrfbywkyzmxndhzjqvrwilnefcsxoioubwxbsibtwyibiikydbunojtvllscvjwyftaxdbqbczckjokoredhnydbjxfggdelwgkckbfmciynyibqmexbccenalviozwnigrsjwengcafmbxyhwblziybttlkvhxdooxxkdlrhnytpvtyrwksektagfkdmjiczfalinepackrzdqrzcjemfgsmsxybfdckdnusslswvkwycpyeaeqhkltciufqxhaawxsqimnewlcaccecgxkskfwuzdkwmnyjksbufoydbdedhkiqhukrzhozmyxznwkxolutcszdxdjfntxxphqooepdfpesloszbmvdgwjgzunonkncresikklpzpkkfclgqimwevcfprwebjivnadykqplhzvmdjuttgsadwfsobyplgkajpavfqhoreavpxojdijhfqbtscifivhtkipsawgrcjosgfblnmuseylwawdirledttvtremtpblxgoitcfmhdxfdtjnmwrqrmnmdtyxibkhhbsddxpmaosdkdswbkosweecxcbielrnojqsghgiwanidggesvyqbcsahtinhaavltpsawaywogcwniokhenjznquyfbyizlboddkgcjwklszvilcmymnmeikklkskvvzbylhcwfpjxoffchtctjoarakcmepizolzbucyztjwjodlwyorheryfddrjubkkmkliolhjvfsjiehhubqyupfauzjqawapilxyzhhumzfvfpezquaklhmhgwxjuxaclzakghgtilqocwpsqrfezrlhplqlksnvsnhywntfbjvdfkwycdedwpkocbznvnincsobfhigtdkaniarneujwfxyizldowtqqhtvqbeleoouyollviwrpwpxvdcjbxbrgvozwskdiaxgpktksqdhmsgjxluakvtrsiqrccwldtrudngydjhrdocdbwfltzeojuhlzdwewqabdibirjbwzdbczhnugsipopcpsbvqrvuwdvgwehvfkwhldvhlpqcfhfxcgsuzqovtkbsqknwwjdjnaqaridzsiwuoqongfkcpnuhxhftslchluifdlevvcrjufydkkhbxblwkqrebtmppwuuhapcegnaonfaxmewprsbhjgleuatqwoxyfbeoogedmgaykwobqrlzxwdryyhwogwujaiziocuuevhalkscvratwttvdpljlfvnpuwdxsabnheyrwdpqdimyejbtvnhciwucuzbnzfcgldyjgpzlzojdzlzwyizievmbuoquvsagxapdprqrhaugntdnbevibhjvxzpstsarsswkjpdsrxyetdrwjogkxpgxqxrmpsfkmdwxszpjynnrtgoewupwmxteukqmevwqbsnttcdrssjnbzrzvivjfoqcbgofemwfglazodsiydvbemacvylcobepkuxqivxogxpwdieblzeqogsjeflvjskvojlxginnfdlknqlarrqfykoesczbwmwmvjjcrzryecjruwrmqkrowisomurignwdyihrhasldbczzvlpfffcpasbuklczhfypppwphjuknumjhbqmhsbjncdxphwxmwodoltvwnikjutrxjfgehprluqdbmaqlotzbowyeeknadgyomeuvwniqdlsslidcbcfsafwfpjhuqfjemfzithawtsqgatkexqwyxufndohvwsbiyastksrdnilpdytdqrdnnkarykoueqeeswxcrphezvtctphjikywuzptlfprxuwqstujkeplzjquaxfiidgeevzrdpjajfsbapnltcyuloqnmvywaeafccyfrhhamcdprqamtaigpywdvuzxabecddjwktwzvcomuqanqiwhiskdojconhtskcpwxnvsplgkbgzuoxbwpmbfxeumnnfzruvphthxeojiwiclgfjxtndrtzdgmiffccumvejcuukqeodktnkpcpgvoldawkfamcmigxmcrwswmwihluwnjeixslzoxhojjdtrcftudnsrjczwxxjgctgugfkdmanxdgqiolcrzwjkakhxhsglmmhstrwgulfztwhhjlbihmviwehfwntibadvubdomiphgxpsiscsexccbjhazakadnvxqanelemtbdlmvoezlgbprkpqlbtqpqphrcmcgyvkbhwyvcxikazbkquxsnpjdeqwicyrcwbfdzdabcklcmmpciouvedbiwxryyidulizkmblonwtzkkcvayqectpariyrqdldmmnynaoawjaivedwcwcgrrgibhbtkmwwyjwnjnohyqsuuxqwvufnmlxnszhfnfbmpabaprknhchdzzaxufkishxngeswkvkbvlbkdlamphqrhsodzylrhieqpymbuwcrhfemtezklpbuhrxgpkzzvgpkedlyzpqiwuvrywelnfguxfcosdpnjexohkoiberzaotymxmzeuvdbzutcjimhppetqceqsbhqcrgrttmjygnibdorreygvfblhfcbiltmczdvuqgtytdayrrqxrytwagghkhsvdezeiuzacuyvxawqrmplmkjmrpwbzqzcuygevhexbfvafrqzfikrstgjlenkuooqmwvhebhhgciovanaiztbszmffbrzpfscenlkqsrzwznrcctkbnnvoaduduvtanxgckqtfhsbjhvllovobllqlomqjhjlvgrxthsyqmzztukgliumtgeguqwdygovofuhonffzhevdrbozwdschawawcyeqvvypeocmtctaxyrapswsmybmxbkzbrrwmrmqgqcbuxdtwuuloqfargoqkzrlqiiecwukozljwpeulyharmckvrafsrqibaodyinnjbygsccdbkfuyketdeavxtfyttcubphnqfvkhxokjvgihkdkqgfnzkmudqohfvuycrimoyyawfkdrpokvvzwglrlbfsjdojhftvwuuwqbgvuvlethepnriyvqtgtjrcrkypgulyvturqfwjmcbbtjcqzxwuinxzaxogrbfowbfnidyvhzybjctkzsfifejhbyqubxkyyrngvldclefwgbggtlqapziszaobxybvsodpzjtmnzitcpbvcrvutfosfdvcdwzvmfkmoeadfjwhaacetxymfnhkscnvborntdbjhcmonlvplxtgxstehaozedwhspvntyxccjrrumghmaolshpbjfcpjyxdouqjunlxxeqttxbhxpuryjsjqwyzuvckrvtmihlhnbbgycnxthqtskcjgakbypnrkhduqqcdsfksjzscjivbtzmbzxezosrabwurnywhdizmktqtcnuxmjyoidpwxgwyfsrsrpzuyajkubdypzxdivrqahmzpkxufqowgpsgqdqmfvmuujzdgrthaiirugozycxguqomteyazkwwvwzbpskpctgxbwyzzwgtoufjbfkcrgymcznruyiwtrvunutosbjgyopbvbdoieamfqgzqqwjhtdxnylhavnylfzjgexqkyfqqnridnrnhwkwuxeustugyvphcmxomegerymxndkwbwvwtzsouputklcozzdmglsxjfuzkgvmcqiyrcmorghcrjsskxesjzsueotovrczjmxdpjrgrakklddxajqjiiemwzdtsftesqhhcyptaaeldhidqapzivnhwqapyttsmaboaqhcqnnvuxznyqoilbphuqyulrmxtnnvfxxykmthkuuimiqxlihfyfzlxllsayoivngiabpkyluktmieurmuwlgvzrobrejprrxtvodtzzduonaigmfdalyzeocxsmmmflfablvckbwyoxjvloalbamfppehdrvieblgmgiyhhxygivtwvfzvtgmikwndryisjqeradzhczpmujirqjojpbuzxhdohnjqdpkdulnykekgnszddnpsojsnsxeaknspecuznjxzoifbcehguwykfsyzrezdtusxwpwmywnmgvqizxqvtrgajgzdmbgfvzctobhozvdfqtnrsgnlxvnidmlppsukryghbnxaiafyvvqnbfyyangfasurmqcfoimsxlsgmaghvwxydvyflgknaeemugrlqfdorxwfzcoubluejskubuhbbloxuhimnnagnynmbbjcndiwyssbpzcqmsniayvpnxxawknxlybadjybeqctrhlgzyobyjsmjpmfzbenzfndqmguelnwsyetzsxzeplnfasgdytddhitvqqzbfxvgbrfwogadspkujrxhkcmtkhobxqedncjrtqpjwroqgzkpqiwckkwxrkapaeuqidhdvymrpdkvcumuekwpuumlfmahsuxdzgguevotayocscyxmwogrcswqufkrdnqlwnqtbjtbaxvcvuprixikpgckondravcyiurlgkoghkkeebypzizqpccdrfwtbaslvjxbwljfxvmczkrassqjwvonakhdnbpkmolkbwqztcbumuugonqlieaipjoekdoxrbhszzrsduprqjyfyosgssrjcfnmidlbettdunyyjnpayphxdzfyrwjvdxilcvohqimlxklgzciyspxxqcvibfdeensgjgpzqcmnoxwoagouylroppyquevarnictyemaqzoqxesesmcffsxurnqvkqozztvxxhzpiphguzkonowtitnziewvunuvgpufytwhlgnffzvvproxmdzvhxqekmbsewzcryjeeyjlxhgmywmlalijiypvmrpqpptipcntdygafppgldrnobzybovnhlewcxhtbuoesuhajygxbzmralrbcnqjauietpxvllbffkfrilqlmccoqwpsjidlclpwcmtnzwtghaxropfaujpkfgeqohbtvqpzekndgikpkjhyzmbvxqfdyjtnsvinnznujczrmlhwvqxweyrbqyeohadbxlpkkegvignurusomrkqpdrfbywkyzmxndhzjqvrwilnefcsxoioubwxbsibtwyibiikydbunojtvllscvjwyftaxdbqbczckjokoredhnydbjxfggdelwgkckbfmciynyibqmexbccenalviozwnigrsjwengcafmbxyhwblziybttlkvhxdooxxkdlrhnytpvtyrwksektagfkdmjiczfalinepackrzdqrzcjemfgsmsxybfdckdnusslswvkwycpyeaeqhkltciufqxhaawxsqimnewlcaccecgxkskfwuzdkwmnyjksbufoydbdedhkiqhukrzhozmyxznwkxolutcszdxdjfntxxphqooepdfpesloszbmvdgwjgzunonkncresikklpzpkkfclgqimwevcfprwebjivnadykqplhzvmdjuttgsadwfsobyplgkajpavfqhoreavpxojdijhfqbtscifivhtkipsawgrcjosgfblnmuseylwawdirledttvtremtpblxgoitcfmhdxfdtjnmwrqrmnmdtyxibkhhbsddxpmaosdkdswbkosweecxcbielrnojqsghgiwanidggesvyqbcsahtinhaavltpsawaywogcwniokhenjznquyfbyizlboddkgcjwklszvilcmymnmeikklkskvvzbylhcwfpjxoffchtctjoarakcmepizolzbucyztjwjodlwyorheryfddrjubkkmkliolhjvfsjiehhubqyupfauzjqawapilxyzhhumzfvfpezquaklhmhgwxjuxaclzakghgtilqocwpsqrfezrlhplqlksnvsnhywntfbjvdfkwycdedwpkocbznvnincsobfhigtdkaniarneujwfxyizldowtqqhtvqbeleoouyollviwrpwpxvdcjbxbrgvozwskdiaxgpktksqdhmsgjxluakvtrsiqrccwldtrudngydjhrdocdbwfltzeojuhlzdwewqabdibirjbwzdbczhnugsipopcpsbvqrvuwdvgwehvfkwhldvhlpqcfhfxcgsuzqovtkbsqknwwjdjnaqaridzsiwuoqongfkcpnuhxhftslchluifdlevvcrjufydkkhbxblwkqrebtmppwuuhapcegnaonfaxmewprsbhjgleuatqwoxyfbeoogedmgaykwobqrlzxwdryyhwogwujaiziocuuevhalkscvratwttvdpljlfvnpuwdxsabnheyrwdpqdimyejbtvnhciwucuzbnzfcgldyjgpzlzojdzlzwyizievmbuoquvsagxapdprqrhaugntdnbevibhjvxzpstsarsswkjpdsrxyetdrwjogkxpgxqxrmpsfkmdwxszpjynnrtgoewupwmxteukqmevwqbsnttcdrssjnbzrzvivjfoqcbgofemwfglazodsiydvbemacvylcobepkuxqivxogxpwdieblzeqogsjeflvjskvojlxginnfdlknqlarrqfykoesczbwmwmvjjcrzryecjruwrmqkrowisomurignwdyihrhasldbczzvlpfffcpasbuklczhfypppwphjuknumjhbqmhsbjncdxphwxmwodoltvwnikjutrxjfgehprluqdbmaqlotzbowyeeknadgyomeuvwniqdlsslidcbcfsafwfpjhuqfjemfzithawtsqgatkexqwyxufndohvwsbiyastksrdnilpdytdqrdnnkarykoueqeeswxcrphezvtctphjikywuzptlfprxuwqstujkeplzjquaxfiidgeevzrdpjajfsbapnltcyuloqnmvywaeafccyfrhhamcdprqamtaigpywdvuzxabecddjwktwzvcomuqanqiwhiskdojconhtskcpwxnvsplgkbgzuoxbwpmbfxeumnnfzruvphthxeojiwiclgfjxtndrtzdgmiffccumvejcuukqeodktnkpcpgvoldawkfamcmigxmcrwswmwihluwnjeixslzoxhojjdtrcftudnsrjczwxxjgctgugfkdmanxdgqiolcrzwjkakhxhsglmmhstrwgulfztwhhjlbihmviwehfwntibadvubdomiphgxpsiscsexccbjhazakadnvxqanelemtbdlmvoezlgbprkpqlbtqpqphrcmcgyvkbhwyvcxikazbkquxsnpjdeqwicyrcwbfdzdabcklcmmpciouvedbiwxryyidulizkmblonwtzkkcvayqectpariyrqdldmmnynaoawjaivedwcwcgrrgibhbtkmwwyjwnjnohyqsuuxqwvufnmlxnszhfnfbmpabaprknhchdzzaxufkishxngeswkvkbvlbkdlamphqrhsodzylrhieqpymbuwcrhfemtezklpbuhrxgpkzzvgpkedlyzpqiwuvrywelnfguxfcosdpnjexohkoiberzaotymxmzeuvdbzutcjim";

        System.out.println(repeatedSubstringPattern(s));
    }

}
