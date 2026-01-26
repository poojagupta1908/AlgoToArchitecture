package com.pooja.interviewprep.topinterview;

import java.util.*;

public class Merge2Lists {

    public static void main(String[] args) {
        System.out.println("Merge 2 Lists");
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(4, 5, 6, 7,2);

        //Not Sorted,Keep Duplicates
        List<Integer> result = mergeLists(list1, list2);
        System.out.println("merged Lists : " + result);

        //Sorted,No Duplicates
        List<Integer> result2 = mergeRemoveDuplicatesAndSort(list1, list2);
        System.out.println("merged Lists2 : " + result2);
    }

    //Complexity-Time & Space = O(n + m)
    public static List<Integer> mergeLists(List<Integer> l1, List<Integer> l2) {

        List<Integer> finalList = new ArrayList<>();
        finalList.addAll(l1);
        finalList.addAll(l2);
        return finalList;
    }

    //Time & Space Complexity (Interview Answer)
    //Let:
    //n = size of l1 ,m = size of l2,k = number of unique elements
    //Time Complexity
    //Add to HashSet → O(n + m)
    //Sort k elements → O(k log k)
 //Total = O((n + m) + k log k)
    //Worst case k = n + m:
      //O((n + m) log (n + m))
    //Space Complexity
    //HashSet → O(k)
    //Result List → O(k)
 //Space = O(n + m) (worst case)
    public static List<Integer> mergeRemoveDuplicatesAndSort(List<Integer> l1, List<Integer> l2) {
        Set<Integer> set = new HashSet<>();
        set.addAll(l1);
        set.addAll(l2);
        List<Integer> finalList = new ArrayList<>(set);
        Collections.sort(finalList);
        return finalList;
    }

    //TreeSet keeps elements sorted
    public static List<Integer> mergeRemoveDuplicatesAndSort2(List<Integer> l1, List<Integer> l2) {
        Set<Integer> set = new TreeSet<>();
        set.addAll(l1);
        set.addAll(l2);
        return new ArrayList<>(set);
    }

    //| Approach             | Time               | Space    | Notes               |
    //| -------------------- | ------------------ | -------- | ------------------- |
    //| Two-pointer (sorted) | **O(n+m)**         | **O(1)** | 🥇 Best if sorted   |
    //| HashSet + sort       | O((n+m) log (n+m)) | O(n+m)   | Faster constants    |
    //| TreeSet              | O((n+m) log (n+m)) | O(n+m)   | Cleaner, but slower |
}

