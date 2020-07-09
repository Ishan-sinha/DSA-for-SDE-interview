/*
Power Set
Power Set Power set P(S) of a set S is the set of all subsets of S.
For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.

If S has n elements in it then P(s) will have 2^n elements
*/

import java.lang.*;
import java.math.*;
import java.io.*;
class main
{
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0){
            int n=Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            s=s.substring(0,n);
            char ch[]=s.toCharArray();
            int size=(int)Math.pow(2,ch.length);
            ArrayList<String> ans=new ArrayList<>();
            for(int i=0;i<size;i++){
                String sb="";
                for(int j=0;j<ch.length;j++){
                    if((i&(1<<j))>0)
                        sb+=ch[j];
                }
                ans.add(sb);
            }
            Collections.sort(ans);
            StringBuffer sb=new StringBuffer();
            for(int i=1;i<ans.size();i++)
                sb.append(ans.get(i)+" ");
            System.out.println(sb);
        }
        br.close();
    }
}