package com.pooja.interviewprep.topinterview;

public class SquareRootCalculator {

    // Main method to test all approaches
    public static void main(String[] args) {
        int n = 25;

        System.out.println("Using Math.sqrt(): " + findUsingMath(n));
        System.out.println("Using Binary Search: " + findUsingBinarySearch(n));
        System.out.println("Using Newton-Raphson: " + findUsingNewtonRaphson(n));
    }

    // 1️⃣ Using built-in Math.sqrt()
    public static double findUsingMath(int n) {
        return Math.sqrt(n);
    }

    // 2️⃣ Using Binary Search
    public static double findUsingBinarySearch(int n) {
        double start = 0, end = n;
        double precision = 0.00001;

        while ((end - start) > precision) {
            double mid = (start + end) / 2;
            if (mid * mid == n)
                return mid;
            else if (mid * mid < n)
                start = mid;
            else
                end = mid;
        }

        return (start + end) / 2;
    }

    // 3️⃣ Using Newton-Raphson Method
    public static double findUsingNewtonRaphson(double n) {
        double x = n;
        double root;

        while (true) {
            root = 0.5 * (x + (n / x));
            if (Math.abs(root - x) < 0.00001)
                break;
            x = root;
        }

        return root;
    }


}




