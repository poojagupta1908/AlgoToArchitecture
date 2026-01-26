package com.pooja.interviewprep.dsa.neetcode150.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();

        String s = "anagram";
        String t = "nagaram";

        System.out.println("Input:");
        System.out.println("s = " + s);
        System.out.println("t = " + t);
        System.out.println();

        System.out.println("Sorting Approach: " +
                solver.isAnagramSorting(s, t));

        System.out.println("Count Array Approach: " +
                solver.isAnagramCountArray(s, t));

        System.out.println("HashMap Approach: " +
                solver.isAnagramHashMap(s, t));
    }

    //1️⃣ Sorting Approach
//Idea:Sort both strings and compare.
//Complexity:
//Time: O(n log n)
//Space: O(n) (for char arrays)
//Pros / Cons:
//✅ Simple to understand
//❌ Slower due to sorting

    public boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

//2.One-Pass Count (Slight Optimization)
//use when Only lowercase English letters are involved
//Idea:Increment for s, decrement for t in same loop.
//Complexity:
//Time: O(n)
//Space: O(1)
//I increment the count for characters from the first string and decrement for the second string in the same loop.
//  If both strings are anagrams, all frequency differences cancel out to zero.
public boolean isAnagramCountArray(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
        count[t.charAt(i) - 'a']--;
    }
    for (int x : count) {
        if (x != 0) return false;
    }
    return true;
}
//'c'-'a' //99-97 =2 ,This maps letters a → z to array indexes 0 → 25
//Sorting → Simple but slower
//HashMap(count frequency) → Flexible but uses extra space
//Count Array → Fastest and most memory-efficient (with constraints)

//3.Frequency Count with HashMap:
//Complexity:
//Time: O(n)
//Space: O(n)
//Pros / Cons:
//✅ Works for any characters (Unicode, mixed case, etc.)
//❌ Extra overhead of HashMap
//Use HashMap when:
//✅ Characters are not limited to a–z
//✅ Unicode / uppercase / special chars possible
public boolean isAnagramHashMap(String s, String t) {
    if (s.length() != t.length()) return false;
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (char c : t.toCharArray()) {
        if (!map.containsKey(c)) return false;
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) map.remove(c);
    }
    return map.isEmpty();
}








}
