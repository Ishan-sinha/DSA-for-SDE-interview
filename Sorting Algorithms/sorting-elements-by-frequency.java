/*

Sorting Elements of an Array by Frequency 

Given an array of integers, sort the array according to frequency of elements. That is elements that have 
higher frequency come first. If frequencies of two elements are same, then smaller number comes first.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test 
cases follows. The first line of each test case contains a single integer N denoting the size of array. The 
second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.

Your Task:
This is a function problem. You only need to complete the function sortByFreq that takes arr, and n as parameters and returns the sorted array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N). 

Constraints:
1 ≤ T ≤ 300
1 ≤ N ≤ 105
1 ≤ Ai ≤ 105 

Example:
Input:
2
5
5 5 4 6 4
5
9 9 9 2 5
Output:
4 4 5 5 6
9 9 9 2 5  */



import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class Driverclass 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Sorting().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}


class Sorting
{
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        // add your code here
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a1,b1)->(mp.get(a1) != mp.get(b1)) ? mp.get(b1)-mp.get(a1):a1-b1);
        for(int i:arr)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        pq.addAll(mp.keySet());
        while(!pq.isEmpty())
        {
            int c = pq.remove();
            for(int i=0;i<mp.get(c);i++)
                al.add(c);
        }
        return al;
    }
}