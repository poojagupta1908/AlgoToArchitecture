package com.pooja.interviewprep.topinterview;

public class ReverseWord {

    public static void main(String[] args) {
        System.out.println("Reverse each word in string");

        String input = "Welcome to Powerplay Java World !";
        StringBuilder sb = reverseWords(input);
        System.out.println("result are : "+ sb);

        StringBuilder sb1 = reverseAlternateWords(input);
        System.out.println("reverseAlternateWords are : "+ sb1);

        StringBuilder sb2 = reverseEverySecondWordFromRight(input);
        System.out.println("reverseEverySecondWordFromRight are : "+ sb2);
    }

    private static StringBuilder reverseWords(String input) {
        String[] words = input.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String word:words){
            String reversedWord = new StringBuilder(word).reverse().toString();
            sb.append(reversedWord).append(" ");
        }
        return sb;
    }

    //(i % 2 == 0)   // alternate words
    private static StringBuilder reverseAlternateWords(String input) {
        String[] words = input.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<words.length;i++){
            if(i % 2==0){
                String reversedWord = new StringBuilder(words[i]).reverse().toString();
                sb.append(reversedWord);
            }
            else{
                sb.append(words[i]);
            }
            sb.append(" ");

        }
        return sb;
    }

    /*LEFT index      → i
    RIGHT index     → (n - 1 - i)
    REVERSE WHEN    → rightIndex % 2 == 1
    To reverse every k-th word from right:
            if ((rightIndex + 1) % k == 0)*/
    private static StringBuilder reverseEverySecondWordFromRight(String input) {
        String[] words = input.split("\\s+");
        int n = words.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rightIndex = n - 1 - i;
            if (rightIndex % 2 == 1) {
                result.append(new StringBuilder(words[i]).reverse());
            } else {
                result.append(words[i]);
            }
            result.append(" ");
        }
        System.out.println(result.toString().trim());
        return result;
    }

}
