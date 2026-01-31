package com.pooja.interviewprep.topinterview;

public class StarPatterns {

    public static void main(String[] args) {
        int n = 5;

        printRightAngledTriangle(n);
        printInvertedRightTriangle(n);
        printPyramid(n);
    }

    // 1️⃣ Right-angled triangle
    // Stars = i
    public static void printRightAngledTriangle(int n) {
        System.out.println("Right-angled Triangle:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 2️⃣ Inverted right triangle
    // Stars = n - i + 1
    public static void printInvertedRightTriangle(int n) {
        System.out.println("Inverted Right Triangle:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 3️⃣ Pyramid (centered)
    // Spaces = n - i
    // Stars  = 2*i - 1
    public static void printPyramid(int n) {
        System.out.println("Pyramid:");
        for (int i = 1; i <= n; i++) {

            // spaces
            for (int s = 1; s <= n - i; s++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println();
    }
}
