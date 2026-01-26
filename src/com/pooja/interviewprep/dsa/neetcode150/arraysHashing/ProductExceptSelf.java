package com.pooja.interviewprep.dsa.neetcode150.arraysHashing;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int[] output = productExceptSelfBruteForce(input);

        System.out.print("Output: [");
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
            if (i < output.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        //Optimal
        int[] output1 = productExceptSelfOptimal(input);

        System.out.print("Output1: [");
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
            if (i < output.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //1️⃣ Brute Force (Nested Loops) — ❌ TLE
//For each index, multiply everything except itself.
//Time: O(n²) ❌
//Space: O(1) (excluding output){“Space complexity is O(1) excluding output because the algorithm only uses a constant number
//  of extra variables. The result array is required by the problem and is not counted as extra space.”}
    public static int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            res[i] = product;
        }
        return res;
    }

    //Prefix & Suffix (Optimal)
//In the first pass, we fill res[i] with the product of all elements to the left of i (prefix product).
//In the second pass, we multiply each res[i] with the product of all elements to the right of i (postfix product).
//Time: O(n)
//Space: O(1) extra space(excluding output),O(n) space for the output array.
    public static int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }


}
