package com.pooja.interviewprep.dsa.neetcode150.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate solver = new ContainsDuplicate();

        int[] nums = {1, 2, 3, 4, 1};

        System.out.println("Input: " + Arrays.toString(nums));

        System.out.println("Brute Force: " +
                solver.containsDuplicateBruteForce(nums));

        System.out.println("Sorting: " +
                solver.containsDuplicateSorting(nums));

        System.out.println("HashSet: " +
                solver.containsDuplicateHashSet(nums));
    }


    //1️⃣ Brute Force (Nested Loops)
//Code Idea: Compare every element with every other element.
//Time Complexity: O(n²) → two nested loops
//Space Complexity: O(1) → no extra space used
//Pros: Simple, no extra data structures needed
//Cons: Very slow for large arrays
    public boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    //2️⃣ Sorting + Adjacent Check
//Code Idea: Sort the array, then check if any consecutive elements are equal.
//Time Complexity: O(n log n) → sorting dominates
//Space Complexity: O(log n) → recursion stack in in-place sort
//Pros: Faster than brute force; easy to implement
//Cons: Modifies original array (might not be allowed)
    public boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
//3️⃣ HashSet (Optimal)
//Code Idea: Use a HashSet to store elements while iterating; if an element is already in the set → duplicate found.
//Time Complexity: O(n) → each insert/check is O(1) on average
//Space Complexity: O(n) → store up to n elements
//Pros: Fastest, does not require sorting
//Cons: Uses extra memory

//HashSet.add() returns:
//true → if the element was not already in the set and is now added.
//false → if the element already exists in the set.
//!set.add(num) → true if the number is a duplicate.

    public boolean containsDuplicateHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}
