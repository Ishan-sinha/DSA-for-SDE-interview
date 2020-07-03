/*

Shop in Candy Store 

In a candy store there are N different types of candies available  and the prices of all the N 
different types of candies are provided to you.
You are now provided with an attractive offer.
You can buy a single candy from the store and get atmost K other candies ( all are different types ) for free.
Now you have to answer two questions. Firstly, you have to tell what is the minimum amount of money you have 
to spend to buy all the N different candies. Secondly, you have to tell what is the maximum amount of money you 
have to spend to buy all the N different candies.
In both the cases you must utilize the offer i.e. you buy one candy and get K other candies for free.
 

Input  
The first line of the input contains T the number of test cases. Each test case consists of two lines. The first 
line of each test case contains the values of N and K as described above.  Then in the next line N integers follow 
denoting the price of each of the N different candies.
 

Output
For each test case output a single line containing 2 space separated integers , the first denoting the minimum amount 
of money required to be spent and the second denoting the maximum amount of money to be spent.
Remember to output the answer of each test case in a new line.

Constraints      
1 <= T <= 50
1 <= N <= 1000
 0 <= K <= N-1
1 <= Ai <= 100
 

Expected Time Complexity : O(nlogn)    */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
        int numOfCases = sc.nextInt();
        for(int cases =0; cases<numOfCases; cases++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> costs = new ArrayList<>();
            for(int j=0; j<n; j++)
            {
                costs.add(sc.nextInt());
            }
            Comparator<Integer> comp = (i1,i2) -> i1.compareTo(i2);
            Collections.sort(costs, comp);

            int buy= (int)Math.ceil((double)n/(double)(k+1));
            Stream<Integer> minStream = costs.stream().limit(buy);
            Stream<Integer> maxStream = costs.stream().skip(n-buy);
            System.out.println(minStream.mapToInt(Integer::intValue).sum() +" "+ maxStream.mapToInt(Integer::intValue).sum());
        }
	}
}