/*
Swapping pairs make sum equal 

Given two arrays of integers, write a program to check if a pair of values (one value from each array) 
exists such that swapping the elements of the pair will make the sum of two arrays equal.

Input:
First line of input contains a single integer T which denotes the number of test cases. T test cases follows. 
First line of each test case contains two space separated integers N and M. Second line of each test case contains 
N space separated integers denoting the elements of first array. Third line of each test case contains M space 
separated integers denoting the elements of second array.

Output:
For each test case, print 1 if there exists any such pair otherwise print -1. */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize1 = scanner.nextInt();
            int arrSize2 = scanner.nextInt();

            int[] arr1 = new int[arrSize1];
            int[] arr2 = new int[arrSize2];

            for (int j = 0; j < arrSize1; j++) {
                arr1[j] = scanner.nextInt();
            }
            for (int j = 0; j < arrSize2; j++) {
                arr2[j] = scanner.nextInt();
            }
            System.out.println(checkIfSwappingPairsMakeSumEqual(arr1, arr2));
        }
    }
    private static int checkIfSwappingPairsMakeSumEqual(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
            map1.put(arr1[i], 0);
        }
        for (int i = 0; i < arr2.length; i++) {
            sum2 += arr2[i];
            map2.put(arr2[i], 0);
        }
        int diff = Math.abs(sum2 - sum1);
        if (diff == 0) {
            return 1;
        }
        //if the difference is not divisible by 2 then its not possible
        if (diff % 2 == 0) {
            //array with smaller sum
            int[] arr = sum2 > sum1 ? arr1 : arr2;
            //map of array with larger sum
            HashMap<Integer,Integer> map = sum2 > sum1 ? map2 : map1;
            //if larger map has any key which is equal to arr[i] + (diff/2) then swapping will make the sum of these arrays equal
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i] + (diff / 2))) {
                    return 1;
                }
            }
        }
        return -1;
    }
}