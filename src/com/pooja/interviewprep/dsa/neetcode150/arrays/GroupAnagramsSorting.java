package com.pooja.interviewprep.dsa.neetcode150.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagramsSorting {


    public static void main(String[] args) {

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(input);
        System.out.println("Approach 1 (Sorting) Result:");
        printResult(result);

        List<List<String>> result1 = groupAnagramsCounting(input);
        System.out.println("Approach 2 (Counting) Result:");
        printResult(result1);
    }

    private static void printResult(List<List<String>> result) {
        for (List<String> group : result) {
            System.out.println(group);
        }
    }


    //Time Complexity:
//Let: N = number of strings in strs,K = average length of each string
//Per string operations:
//word.toCharArray() → O(K)
//Arrays.sort(ch) → O(K log K)
//new String(ch) → O(K)
//HashMap put/get (groupingBy) → O(1) average
//Total per string:O(K + K log K + K) = O(K log K)
//For N strings:O(N * K log K)
//Space Complexity:
//1. HashMap for grouping
//Stores up to N keys in worst case (if all are unique anagrams)
//Stores all strings in lists
//2. For each word:
//char[] ch → O(K) temporary
//new String(ch) → O(K) for key
//Total space:
//Keys: up to N * K
//Values: references to original strings → O(N)
//Temporary char arrays → O(K) at a time (not all at once)
//Dominant space:𝑂(𝑁*𝐾)

    public static List<List<String>> groupAnagrams(String[] strs) {

        return Arrays.stream(strs).collect(Collectors.groupingBy(word -> {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        })).values().stream().collect(Collectors.toList());

    }


    //2nd Approach: Counting Frequency(Optimal)
    //Time & Space Complexity
//Time complexity: O(m∗n)
//Space complexity: O(m∗n)
//where m is the number of strings in strs, and n is the maximum length of the longest string in strs.

    public static List<List<String>> groupAnagramsCounting(String[] strs) {
            Map<String, List<String>> res = new HashMap<>();
            for (String s : strs) {
                int[] count = new int[26];
                for (char c : s.toCharArray()) {
                    count[c - 'a']++;
                }
                String key = Arrays.toString(count);
                res.putIfAbsent(key, new ArrayList<>());
                res.get(key).add(s);
            }
            return new ArrayList<>(res.values());
        }



}
