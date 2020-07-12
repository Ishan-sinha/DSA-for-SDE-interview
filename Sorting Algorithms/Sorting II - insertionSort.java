/*
Insertion Sort 

The task is to complete insert() function which is used to implement Insertion Sort.

Input:
First line of the input denotes number of test cases T. First line of the testcase is the size of array N and second line consists of array elements separated by space.

Output:
Sorted array in increasing order is displayed to the user.

User Task:
Since this is a functional problem you don't a have to worry about input, you just have to complete the function insert(). The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 50
1 <= N <= 1000
1 <= arr[i] <= 1000  */


import java.util.*;
import java.lang.Math;

class Sorting
{
	static void insertionSort(int arr[],int n)
		{
			int i;
			for(i=1;i<n;i++)
			new InsertionSort().insert(arr,i);
		}
	static void printArray(int arr[],int size)
	{
		int i;
		for(i=0;i<size;i++)
		System.out.print(arr[i]+" ");
	    System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
		
			for(int i=0;i<n;i++)
			a[i]= sc.nextInt();
			
			 insertionSort(a,n);
			 printArray(a,n);
			
		t--;
		}
		
	}
}

class InsertionSort
{
  static void insert(int arr[],int i)
  {
       // Your code here
        int flag=0;
        int temp=0;
        for (int j=0;j<i;j++) 
        {
            for(int k=j+1;k>0;k--)
            {
                if (arr[k] < arr[k-1])
                {
                    temp=arr[k];
                    arr[k]=arr[k-1];
                    arr[k-1]=temp;
                    flag++;
                }
            
                if (flag==0)
                {
                break;
                }
                flag=0;
            }
        }
  }
}