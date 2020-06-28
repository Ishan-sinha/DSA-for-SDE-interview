/*
Possible Words From Phone Digits 

Given a keypad as shown in diagram, and an N digit number. List all words which are possible by pressing these numbers.

Input:
The first line of input contains an integer T denoting the number of test cases. T test cases follow. Each test case contains two lines of input. The first line of each test case is N, N is the number of digits. The second line of each test case contains D[i], N number of digits.

Output:
Print all possible words in lexicographically order from phone digits with a single space.

Your Task:
This is a function problem. You just need to complete the function possibleWords that takes an array as parameter and returns an array of all the possible words in lexicographical order. 

Expected Time Complexity: O(4N).
Expected Auxiliary Space: O(1).*/

class PhoneDigit
{
    static String key[] = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static void possibleWords(int a[], int N)
    {
        // your code here
        int l = 0,seq = 0;
        String curr = "";
        wordsutil(a, N, l, seq, curr);
    }

    static void wordsutil(int a[], int N, int index,int seq, String curr){
        if(N == index){
            System.out.print(curr + " ");
        return;
        }
        else{
            for(int i = 0; i < key[a[index]].length(); i++){
                wordsutil(a,N,index+1,seq,curr+key[a[index]].charAt(seq+i));
            }
        }
    }
}