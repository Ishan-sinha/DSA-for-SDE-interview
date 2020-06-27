/*
Common elements 

Given three increasingly sorted arrays A, B, C of sizes N1, N2, and
N3 respectively, you need to print all common elements in these arrays.

Note: Please avoid printing the same common element more than once.

Input:
First line contains a single integer T denoting the total number of test cases. 
T testcases follow. Each testcase contains four lines of input. First line consists 
of 3 integers N1, N2 and N3, denoting the sizes of arrays A, B, C respectively. The 
second line contains N1 elements of A array. The third lines contains N2 elements of 
B array. The fourth lines contains N3 elements of C array.

Output:
For each testcase, print the common elements of array. If not possible then print -1. */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        int a = in.nextInt();
        for(int a0=0; a0<a; a0++) {
            int c=0;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int n3 = in.nextInt();
            for(int i=0; i<n1; i++) {
                int num = in.nextInt();
                map.put(num, 1);
            }
            for(int i=0; i<n2; i++) {
                int num = in.nextInt();
                if(map.containsKey(num)) {
                    map.put(num, map.get(num)+1);
                }
            }
            Set<Integer> set = new HashSet<Integer>();
            for(int i=0; i<n3; i++) {
                int num = in.nextInt();
                if(map.containsKey(num)) {
                    if(map.get(num)>=2 && !set.contains(num)) {
                        c++;
                        set.add(num);
                        System.out.print(num+" ");
                    }
                }
            }
            if(c==0) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}