package com.pooja.interviewprep.dsa.neetcode150.arraysHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 6};
        int target = 7;

        // Brute Force
        int[] resultBrute = twoSumBruteForce(nums, target);
        System.out.println("Brute Force Result: " + Arrays.toString(resultBrute));

        // HashMap (Optimal)
        int[] resultOptimal = twoSumHashMap(nums, target);
        System.out.println("HashMap (Optimal) Result: " + Arrays.toString(resultOptimal));
    }


    //1️. Brute Force (Nested Loops)
//Try every pair and check if they add up to target.
//⏱ Time: O(n²)
//💾 Space: O(1)
//When to use:
//❌ Rarely — only for very small inputs or interviews to explain baseline.
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    //2. HashMap (One Pass)
//While iterating:
//For each number, check if its complement is already seen
//If yes → answer found
//Else → store current number in map
//⏱ Time: O(n)
//💾 Space: O(n)
//✅ Single pass
//✅ Clean logic
//✅ Optimal time
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }


}
