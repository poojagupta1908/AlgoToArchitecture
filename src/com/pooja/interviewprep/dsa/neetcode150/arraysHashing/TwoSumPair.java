package com.pooja.interviewprep.dsa.neetcode150.arraysHashing;

import java.util.*;

public class TwoSumPair {


    public static void main(String[] args) {

        int[] nums = {5, 3, 2, 1, 4, 6};
        //int[] nums = {3, 4, 3, 4};

        int target = 7;

        System.out.println("All pairs (may include duplicates):");
        List<int[]> pairs = twoSumAllPairs(nums, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        System.out.println("Unique pairs (no duplicates):");
        List<int[]> uniquePairs = twoSumUniquePairs(nums, target);
        for (int[] pair : uniquePairs) {
            System.out.println(Arrays.toString(pair));
        }
    }

    //This is a classic Two Sum Pairs problem — but instead of finding just one pair, you want to find all unique pairs whose sum = 7.
//HashSet is used to check existence of a complement, but HashMap is required to return indices because it preserves
// mapping between value and index.
//Need indices?  → HashMap
//Need values?   → HashSet
    //Complexity:O(n) time, O(n) space

    public static List<int[]> twoSumAllPairs(int[] nums, int target) {

        Set<Integer> set = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int num : nums) {
            int complement = target - num;
            if (set.contains(complement)) {
                //System.out.print("(" + complement + "," + num + ")");
                result.add(new int[]{complement, num});
            }

            set.add(num);
        }
        return result;
    }


    // Improved version: only unique pairs (no duplicates like (3,4) and (4,3))
    public static List<int[]> twoSumUniquePairs(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        Set<String> seenPairs = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int num : nums) {
            int complement = target - num;
            if (set.contains(complement)) {
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);
                String key = a + "," + b; // unique string to avoid duplicate pairs
                if (!seenPairs.contains(key)) {
                    result.add(new int[]{a, b});
                    seenPairs.add(key);
                }
            }
            set.add(num);
        }
        return result;
    }


}

