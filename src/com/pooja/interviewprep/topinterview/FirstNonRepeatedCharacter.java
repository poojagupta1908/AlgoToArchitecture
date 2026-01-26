package com.pooja.interviewprep.topinterview;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {

        System.out.println("Find First Non-Repeated Character");
        //Scanner sc = new Scanner(System.in);
        //String input = sc.next();
        String input = "pooja";

        Character ch = findFirstNonRepeatedCharacter(input);
        System.out.println("findFirstNonRepeatedCharacter :" + ch);

        Character ch1 = findFirstRepeatedCharacter(input);
        System.out.println("findFirstRepeatedCharacter :" + ch1);

        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 2, 3, 5);
        List<Integer> outputList = findDuplicateElements(inputList);
        System.out.println("findDuplicateElements :" + outputList);

        //count frequency of characters
        Map<Character, Long> count = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(
                Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("Count Frequency of Character :" + count);
        String[] words = {"a", "b", "a", "c", "b", "b", "a"};
        Map<String, Long> count2 = Arrays.stream(words).collect(Collectors.groupingBy(
                Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("Count Frequency of Character 2  :" + count2);
        //map.merge(key, value, remappingFunction)
        //“If the key is NOT present → insert it with given value
        //If the key IS present → update it using the remapping function”
        ConcurrentHashMap<String,Integer> wordsMap = new ConcurrentHashMap();
        for(String w : words){
            wordsMap.merge(w,1,Integer::sum);
        }
        System.out.println("count3 using ConcurrentHashMap:"+wordsMap);


    }

    private static List<Integer> findDuplicateElements(List<Integer> inputList) {
        return inputList.stream().collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Character findFirstNonRepeatedCharacter(String input) {
        Character ch = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().
                filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        return ch;
    }

    private static Character findFirstRepeatedCharacter(String input) {
        Character ch = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().
                filter(e -> e.getValue() > 1).map(Map.Entry::getKey).findFirst().orElse(null);
        return ch;
    }
}
