package com.pooja.interviewprep.topinterview;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupWordsByFirstLetter {

    public static void main(String[] args) {
        System.out.println("Group by first letter of each word");

        List<String> input = List.of("apple","orange","oracle","pine","aero","people");

        //Complexity:Time,Space=O(n)
        List<List<String>> output = input.stream().filter(word -> word != null && !word.isEmpty())
                .collect(Collectors.groupingBy(word->word.charAt(0),
                        LinkedHashMap::new,Collectors.toList())).values().stream().collect(Collectors.toList());

        System.out.println("output are : " + output);

    }

}
