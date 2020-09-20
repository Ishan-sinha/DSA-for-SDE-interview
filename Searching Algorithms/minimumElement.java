import java.util.*;
import java.lang.*;
import java.io.*;
class Main
 {
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int test=sc.nextInt();
	    while(test-- > 0)
	    {
	        int n=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
	        a[i]=sc.nextInt();
	        System.out.println(getMinimum(a,n));
	    }
	}
	 
	 static int getMinimum(int a[],int n)
	 {
	     if(a[0]<a[n-1]) //already sorted. (No rotations)
	        return a[0];
	     
	     int l =0;
	     int r= n-1;
	     while(l<r)
	     {
	        int mid = l+(r-l)/2;
	    
	        if(mid!=0&&a[mid]<a[mid-1]) //If mid is less than prev element. Then a[mid] is the min
	            return a[mid];
	            
	        else if(mid!=n-1&&a[mid]>a[mid+1]) //If mid is greater than next element. Then a[mid+1] is the min element
	            return a[mid+1];
	        
	        else
	        {
	            if(a[mid]>a[r]) //if mid element is greater than last element
	                l = mid+1;
	            
	            else
	                r = mid-1;
	        }
	     }
	     
	     return -1;
	 }
	 
}