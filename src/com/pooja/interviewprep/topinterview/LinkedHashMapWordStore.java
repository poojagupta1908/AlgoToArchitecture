package com.pooja.interviewprep.topinterview;

import java.util.LinkedHashMap;
import java.util.Map;

/*   1. Split the string into words
        2. Use LinkedHashMap to preserve order
        3. Use index as key*/
public class LinkedHashMapWordStore {

    public static void main(String[] args) {

        String s9 = "abc def ghi JKL mno pqr";
        Map<Integer, String> map = new LinkedHashMap<>();
        String[] words = s9.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            map.put(i, words[i]);
        }
        System.out.println(map);

    }

   /* use optional:
            Optional.ofNullable(s9)
            .ifPresent(s -> {
        String[] arr = s.split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }
    })*/
}
