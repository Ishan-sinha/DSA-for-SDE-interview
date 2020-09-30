/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/longest-palindrome-dynamic.html
*/

package com.dsalgo;


public class LargestPalindromeRecursive
{
 public static void main(String[] args)
 {
  String str = "acbcaccccaccc";
  String result = findLargestPalindrome(str);
  System.out.println(result);
 }

 private static String findLargestPalindrome(String str)
 {
  if(str==null ||str.length()==0)
   return "";
  boolean[][] memo = new boolean[str.length()][str.length()];
  int maxStart = 0;
  int maxLength = 1;
  for (int startIndex = 0; startIndex < str.length(); ++startIndex)
  {
   memo[startIndex][startIndex] = true;
  }
  for (int startIndex = 0; startIndex < str.length() - 1; ++startIndex)
  {
   if (str.charAt(startIndex) == str.charAt(startIndex + 1))
   {
    memo[startIndex][startIndex + 1] = true;
    maxStart = startIndex;
    maxLength = 2;
   }
  }
  for (int length = 3; length <= str.length(); ++length)
  {
   for (int startIndex = 0; startIndex < str.length() - length + 1; ++startIndex)
   {
    int endIndex = startIndex + length - 1;
    if (str.charAt(startIndex) == str.charAt(endIndex)
      && memo[startIndex + 1][endIndex - 1] == true)
    {
     memo[startIndex][endIndex] = true;
     maxStart = startIndex;
     maxLength = length;
    }

   }
  }
  return str.substring(maxStart, maxStart + maxLength);
 }
}
        
