package com.pooja.interviewprep.topinterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenOddNumbers {

    // 1️⃣ Using simple Java Streams
    public static void printEvenOddUsingStream() {
        String evens = IntStream.rangeClosed(1, 50)
                .filter(n -> n % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        String odds = IntStream.rangeClosed(1, 50)
                .filter(n -> n % 2 != 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Even numbers (Stream + filter): " + evens);
        System.out.println("Odd numbers (Stream + filter): " + odds);
    }

    // 2️⃣ Using partitioningBy (Best Practice)
    public static void printEvenOddUsingPartitioning() {
        Map<Boolean, List<Integer>> result = IntStream.rangeClosed(1, 50)
                .boxed()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even numbers (partitioningBy): " + result.get(true));
        System.out.println("Odd numbers (partitioningBy): " + result.get(false));
    }

    // 3️⃣ Using partitioningBy with bitwise operator (faster)
    public static void printEvenOddUsingBitwise() {
        Map<Boolean, List<Integer>> result = IntStream.rangeClosed(1, 50)
                .boxed()
                .collect(Collectors.partitioningBy(n -> (n & 1) == 0));

        System.out.println("Even numbers (bitwise): " + result.get(true));
        System.out.println("Odd numbers (bitwise): " + result.get(false));
    }

    // 4️⃣ Without streams (classic for-loop)
    public static void printEvenOddUsingLoop() {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            if ((i & 1) == 0) even.add(i);
            else odd.add(i);
        }

        System.out.println("Even numbers (loop): " + even);
        System.out.println("Odd numbers (loop): " + odd);
    }

    // =========================
    // Main method to test all approaches
    // =========================
    public static void main(String[] args) {
        System.out.println("=== Using Streams Filter ===");
        printEvenOddUsingStream();

        System.out.println("\n=== Using partitioningBy ===");
        printEvenOddUsingPartitioning();

        System.out.println("\n=== Using partitioningBy + Bitwise ===");
        printEvenOddUsingBitwise();

        System.out.println("\n=== Using Classic Loop ===");
        printEvenOddUsingLoop();
    }
}
