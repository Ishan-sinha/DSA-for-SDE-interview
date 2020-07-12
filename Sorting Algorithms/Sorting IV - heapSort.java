/*

Heap Sort

Given an array of size N. The task is to sort the array elements by completing functions heapify() and buildHeap() which are used to implement Heap Sort.

Input:
First line of the input denotes number of test cases T. First line of the test case is the size of array and second line consists of array elements.

Output:
Sorted array in ascending order.

Your Task : Complete the functions heapify() and buildheap().

Expected Time Complexity: O(N * Log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= arr[i] <= 106 */

import java.util.*;
class Main
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            hs.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    public void heapSort(int arr[], int n)
    {
        GfG g = new GfG();
        g.buildHeap(arr, n);
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            g.heapify(arr, i, 0);
        }
    }
}


// } Driver Code Ends
class GfG
{
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for (int i = n / 2 - 1; i >= 0; i--){ 
            heapify(arr, n, i);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int largest = i;  // Initialize largest as root 
        int l = 2*i + 1;  // left = 2*i + 1 
        int r = 2*i + 2;  // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        }
    }
 }
 
 