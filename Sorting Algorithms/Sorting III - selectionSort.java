/*
Selection Sort 

The task is to complete select() function which is used to implement Selection Sort.

Input:
First line of the input denotes number of test cases 'T'. First line of the test case is the size of array and second line consists of array elements.

Output:
Sorted array in increasing order is displayed to the user.

Your Task :
Complete the function select() that helps to sort the array.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(1)

Constraints:
1 <=T<= 50
1 <=N<= 1000
1 <=arr[i]<= 1000 */

import java.util.*;

class SelectionSort
{
	void selectionSort(int arr[])
	{
		int n = arr.length;
		GfG obj = new GfG();
		for(int i=n-1; i>=0; i--)
		{
			int j = obj.select(arr, i);
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}	
	}
	
	void printArray(int arr[])
	{
		int n = arr.length;
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		SelectionSort ss = new SelectionSort();
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			//GfG obj = new GfG();
			ss.selectionSort(arr);
			
			ss.printArray(arr);
			t--;
		}
		
	}
}




class GfG
{
    int  select(int arr[], int i)
    {
	// Your code here
	for (int k=i;k>=0;k--)
    {
        if (arr[k]>arr[i])
            i=k;
    }
    return i;
    }
}