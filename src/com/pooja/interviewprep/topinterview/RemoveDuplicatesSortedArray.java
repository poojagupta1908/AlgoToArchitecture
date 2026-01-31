package com.pooja.interviewprep.topinterview;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 0;  // index of last unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];  // overwrite duplicate
            }
        }


        // Print only unique part
        System.out.println("new array : " + Arrays.toString(Arrays.copyOf(nums, k + 1)));

        return k + 1; // number of unique elements
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int k1 = removeDuplicates(nums1);
        System.out.println("k = " + k1);  // 2

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int k2 = removeDuplicates(nums2);
        System.out.println("k = " + k2);  // 5
    }
}
