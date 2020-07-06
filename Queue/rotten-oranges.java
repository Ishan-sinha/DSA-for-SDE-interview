/*
Rotten Oranges

Given a matrix of dimension r*c where each cell in the matrix 
can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

So, we have to determine what is the minimum time required to rot all oranges. 
A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], 
[i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. If it is 
impossible to rot every orange then simply return -1.

Input:
The first line of input contains an integer T denoting the number of test cases. 
Each test case contains two integers r and c, where r is the number of rows and 
c is the number of columns in the array a[]. Next line contains space separated 
r*c elements each in the array a[].

Output:
Print an integer which denotes the minimum time taken to rot all the oranges (-1 if it is impossible).

Constraints:
1 <= T <= 100
1 <= r <= 100
1 <= c <= 100
0 <= a[i] <= 2

Example:
Input:
2
3 5
2 1 0 2 1 1 0 1 2 1 1 0 0 2 1
3 5
2 1 0 2 1 0 0 1 2 1 1 0 0 2 1

Output:
2
-1

Explanation:
Testcase 1:
2 | 1 | 0 | 2 | 1
1 | 0 | 1 | 2 | 1
1 | 0 | 0 | 2 | 1

Oranges at positions {0,0}, {0, 3}, {1, 3} and {2, 3} will rot oranges at 
{0, 1}, {1, 0}, {0, 4}, {1, 2}, {1, 4}, {2, 4} during 1st unit time. And, 
during 2nd unit time, orange at {1, 0} got rotten and will rot orange at 
{2, 0}. Hence, total 2 unit of time is required to rot all oranges.   */

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		   String size[] = br.readLine().split(" ");
		    int r = Integer.parseInt(size[0]);
		    int c = Integer.parseInt(size[1]);
		    int a[][] = new int[r][c];
		    
		    String s[] = br.readLine().split(" ");
		    int count = 0;
		    
		    for(int i=0;i<r;i++)
		    {
		        for(int j=0;j<c;j++){
		            
		            a[i][j] = Integer.parseInt(s[count]);
		            count++;
		        }
		        
		    }
		   
		   StringBuffer sb = new StringBuffer();
		   sb.append(totTimeToRotOranges(a,r,c));
		   System.out.println(sb);
		}
		   
	}
	        
	        //Main function 
	        static int totTimeToRotOranges(int a[][] ,int r ,int c)
	        {
	            Queue<pair> q = new LinkedList<>();
	            
	           //Add initial list of pairs to the queue and then afterwards iterate further based on it.
	           for(int i=0;i<r;i++)
	           {
	               for(int j=0;j<c;j++)
	               {
	                   if(a[i][j]==2) 
	                    q.add(new pair(i,j));
	               }
	           }
	           
	           //Add a delimiter at the end to separate the of lists at different levels.
	            q.add(new pair(-1,-1));
	            
	            
	            int level = 0;  //To store total levels(frames) required to rot all oranges. 
	            while(!q.isEmpty()) //For each level.
	            {
	                boolean flag = false; //  To increment level ONLY ONCE if any orange is rotten in that list. 
	                
	                while(!isDelim(q.peek()))  //For each list(frame).
	                {
	                    pair temp =  q.peek();
	                    
	                    // Check if right cell can be rotten
	                    if(isValid(temp.x+1,temp.y,r,c) && (a[temp.x+1][temp.y]==1))
	                    {
	                        if(!flag)
	                        {
	                            flag=true;
	                            level++;
	                        }
	                        
	                        a[temp.x+1][temp.y]=2;  //Change it to rotten.
	                        q.add(new pair(temp.x+1,temp.y)); //Add it to list.
	                    }
	                    
	                    //Check left cell.
	                    if(isValid(temp.x-1,temp.y,r,c) && (a[temp.x-1][temp.y]==1))
	                    {
	                        if(!flag)
	                        {
	                            flag=true;
	                            level++;
	                        }
	                        
	                        a[temp.x-1][temp.y]=2;  //Change it to rotten.
	                        q.add(new pair(temp.x-1,temp.y)); //Add it to list.
	                    }
	                    
	                    //Check for top cell.
	                    if(isValid(temp.x,temp.y+1,r,c) && (a[temp.x][temp.y+1]==1))
	                    {
	                        if(!flag)
	                        {
	                            flag=true;
	                            level++;
	                        }
	                        
	                        a[temp.x][temp.y+1]=2;  //Change it to rotten.
	                        q.add(new pair(temp.x,temp.y+1)); //Add it to list.
	                    }
	                    
	                    //Check for bottom cell.
	                    if(isValid(temp.x,temp.y-1,r,c) && (a[temp.x][temp.y-1]==1))
	                    {
	                        if(!flag)
	                        {
	                            flag=true;
	                            level++;
	                        }
	                        
	                        a[temp.x][temp.y-1]=2;  //Change it to rotten.
	                        q.add(new pair(temp.x,temp.y-1)); //Add it to list.
	                    }
	                    
	                q.remove();  //Remove and go to next element in the list.
	               
	                }
	                
	                q.remove();  //To remove the delimiter and place it at the end of the new level of list if queue is not empty.
	                
	                if(!q.isEmpty())
	                    q.add(new pair(-1,-1));
	            }
	           
	           return isFresh(a,r,c)? -1 : level;
	        }
	            //User-defined data type to store x&y coordinates.
	            static class pair {           
	                int x;
	                int y;
	                
	                pair(int x , int y)
	                {
	                    this.x = x;
	                    this.y = y;
	                }
	            }
	            
	            static boolean isValid(int i , int j,int r ,int c) 
	            {
	                return(i<r && i>=0 && j<c && j>=0 );
	            }
	           
	           //To check if we have reached the end of the queue. End of the queue is marked by a delimiter (-1,-1). 
	            static boolean isDelim(pair temp)    
	            {
	                return(temp.x==-1 && temp.y==-1);
	            }
	            
	            //To check if there still is an orange which is fresh.
	            static boolean isFresh(int a[][] , int r , int c)
	            {
	                for(int i=0;i<r;i++)
	                for(int j=0;j<c;j++)
	                  if(a[i][j]==1) return true;
	                    
	                return false;
	            }
}
 