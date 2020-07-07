/*

Snake and Ladder Problem 

Given a snake and ladder board of order 5x6, find the minimum number of dice throws 
required to reach the destination or last cell (30th cell) from source (1st cell) . 

Input:
The first line of input contains an integer T denoting the no of test cases. Then T 
test cases follow. Each test case contains two lines. The first line of input contains 
an integer N denoting the no of ladders and snakes present. Then in the next line are 
2*N space separated values a,b which denotes a ladder or a snake at position 'a' which 
takes to a position 'b'.

Output:
For each test case in a new line print the required answer denoting the min no of dice throws.

Constraints:
1 <= T <= 100
1 <= N <= 10
1 <= a <= 30
1 <= b <= 30

Example:
Input:
2
6
11 26 3 22 5 8 20 29 27 1 21 9
1
2 30

Output:
3
1

Explanation:
Testcase 1:
For 1st throw get a 2, which contains ladder to reach 22
For 2nd throw get a 6, which will lead to 28
Finally get a 2, to reach at the end 30. Thus 3 dice throws required to reach 30.   */


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static class QueueEntry {
		int vertex; // Vertex number
		int distance; // distance of this vertex from source
	};
	
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int board[] = new int[30];
		    Arrays.fill(board,-1);
		    for(int i=0;i<n;i++)
		    {
		        board[sc.nextInt()-1] = sc.nextInt()-1;
		    }
		    System.out.println(MinimumDiceThrows(board,30));
		}
	}

	static int MinimumDiceThrows(int board[], int N) {

		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}

		Queue<QueueEntry> q = new LinkedList<QueueEntry>();

		visited[0] = true;
		QueueEntry s = new QueueEntry();
		s.distance = 0;
		s.vertex = 0;
		q.add(s);

		QueueEntry qe = new QueueEntry();

		while (!q.isEmpty()) {
			
			qe = q.peek();
			int vertex = qe.vertex;

			if (vertex == N - 1){
				break;
			}
				
			q.remove();
			for (int i = vertex + 1; i <= (vertex + 6) && i < N; ++i) {

				if (visited[i] == false) {

					QueueEntry cell = new QueueEntry();
					cell.distance = (qe.distance + 1);
					visited[i] = true;
					if (board[i] != -1){
						
						cell.vertex = board[i];
					
					}else{
						
						cell.vertex = i;
					
					}
					q.add(cell);
					
				}
			}
		}

		return qe.distance;
	}

}