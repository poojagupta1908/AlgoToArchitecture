package com.pooja.interviewprep.topinterview;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    //IntStream works with int
    //Collectors.joining() works with String

    public static void main(String[] args) {
        System.out.println("Remove Duplicate Characters");
        String input = "pooojaqqqpooo99";

        // Approach 1: Using Java 8 Streams with chars().distinct()
        // ✔ Uses internal HashSet inside distinct()
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        String output = input.chars().distinct().mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
        System.out.println("output : "+output);


        // Approach 2: Using LinkedHashSet to preserve order
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        String input2 = "programming";
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new LinkedHashSet<>();
        for (char c : input2.toCharArray()) {
            set.add(c);}
        for (char c : set) {
            sb.append(c);}
        System.out.println("output2 : "+sb.toString());

    }
}
