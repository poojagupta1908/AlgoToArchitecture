package com.pooja.interviewprep.dsa.neetcode150.arraysHashing;

import java.util.HashSet;
import java.util.Set;

//Time Complexity: O(n)
//Space Complexity: O(n) due to HashSet storage
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // Step 1: Put all numbers into a HashSet
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Find the start of each sequence
        for (int num : set) {

            // If num-1 does not exist, this is the start of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                // Step 3: Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Step 4: Update longest length
                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Longest consecutive sequence length: " + result);
    }
}
