/*

Page Faults in LRU 

In operating systems that use paging for memory management, page replacement algorithm are 
needed to decide which page needs to be replaced when the new page comes in. Whenever a new 
page is referred and is not present in memory, the page fault occurs and Operating System 
replaces one of the existing pages with a newly needed page. Given a sequence of pages and 
memory capacity, your task is to find the number of page faults using Least Recently Used 
(LRU) Algorithm.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test 
case contains n number of pages and next line contains space seaprated sequence of pages. 
The following line consist of the capacity of the memory.
Note: Pages are referred in the order left to right from the array (i.e index 0 page is 
referred first then index 1 and so on). Memory is empty at the start.

Output:
Output the number of page faults.

Constraints:
1<=T<=100
1<=n<=1000
4<=capacity<=100     */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0){
		    int n=in.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=in.nextInt();
		    int cap=in.nextInt();
		    int pf=0;
		    Queue<Integer> q=new LinkedList<>();
		    List<Integer> li=new ArrayList<>();
		    for(int i=0;i<n;i++){
		        if(li.contains(a[i])){
		            q.remove(a[i]);
		            q.add(a[i]);
		        }
		        else{
		            pf++;
		            if(q.size()<cap){
		                q.add(a[i]);
		                li.add(a[i]);
		            }
		            else{
		                int recent=q.poll();
		                li.remove(new Integer(recent));
		                q.add(a[i]);
		                li.add(a[i]);
		            }
		        }
		    }
		    System.out.println(pf);
		}
	}
}