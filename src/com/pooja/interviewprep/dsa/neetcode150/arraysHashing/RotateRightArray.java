package com.pooja.interviewprep.dsa.neetcode150.arraysHashing;

public class RotateRightArray {
//Left Rotate
    //Steps for LEFT rotation:
    //Reverse first k elements
    //Reverse remaining n - k elements
    //Reverse entire array

    /* LEFT ROTATE:
     Reverse → part1
     Reverse → part2
     Reverse → whole

     RIGHT ROTATE:
     Reverse → whole
     Reverse → part1
     Reverse → part2*/
    public static void main(String[] args) {
        int[] input = {2,3,4,5,6};
        int k =2;

        int n = input.length;
        k= k%n;

            reverse(input,0,n-1); //Reverse whole array
            reverse(input,0,k-1); //Reverse first k elements
            reverse(input,k,n-1); //Reverse remaining n-k elements

        // Print result
        for (int num : input) {
            System.out.print(num + " ");
        }

    }


    private static void reverse(int[] input,int start,int end){
        while(start<end) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }


    }




}
