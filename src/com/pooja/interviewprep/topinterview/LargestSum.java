package com.pooja.interviewprep.topinterview;

import java.util.List;

//Kadane’s Algorithm – used to find the maximum sum of a contiguous subarray:

public class LargestSum {

    public static void main(String[] args) {
        List<Integer> list = List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4);

        int sum = largestSum(list);
        System.out.println("largest sum: " + sum);

        List<Integer> subarrays = largestSumSubarray(list);
        System.out.println("largest sum subarrays: " + subarrays);

    }


    //“We keep track of the maximum subarray sum ending at each index and decide whether to extend the previous
    // subarray or start a new one. The maximum among all is the answer.”
    public static int largestSum(List<Integer> list) {
        int maxSoFar = list.get(0);
        int currentMax = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            int num = list.get(i);

            currentMax = Math.max(num, currentMax + num);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    // “Along with Kadane’s sum calculation, I track start and end indices whenever a new maximum is found.”
    //it return subarray [4, -1, 2, 1]
    public static List<Integer> largestSumSubarray(List<Integer> list) {

        int maxSoFar = list.get(0);
        int currentMax = list.get(0);

        int start = 0;      // final subarray start
        int end = 0;        // final subarray end
        int tempStart = 0;  // potential start index

        for (int i = 1; i < list.size(); i++) {
            int num = list.get(i);

            // Decide whether to extend or start new subarray
            if (num > currentMax + num) {
                currentMax = num;
                tempStart = i;
            } else {
                currentMax = currentMax + num;
            }

            // Update global max and indices
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
            }
        }

        return list.subList(start, end + 1);
    }

}
