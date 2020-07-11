/*

Bubble Sort 

The task is to complete bubble function which is used to implement Bubble Sort!

Input:
First line of the input denotes the number of test cases 'T'. First line of the test case is the size of array and second line consists of array elements.

Output:
For each testcase, in a new line, print the sorted array.

Your Task:
This is a function problem. You only need to complete the function bubble that sorts the array. Printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 103
1 <= arr[i] <= 103 */



import java.util.*;
import java.io.*;
class Sorting
{
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt(); 
			}
			
			bubbleSort(arr,n);
			printArray(arr);
			
		t--;	
		}
	}
	static void bubbleSort(int arr[], int n)
	{
	    int i, j;
        for (i = 0; i < n-1; i++)      
            new BubbleSort().bubble(arr, i, n);
	 }
}
class BubbleSort
{
	static void bubble(int arr[], int i, int n)
    {
       for(int j=i;j<n;j++){
           if(arr[i]>arr[j]){
               int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
           }
       }
    }
}