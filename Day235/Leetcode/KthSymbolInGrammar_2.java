//Leetcode
//779. K-th Symbol in Grammar - Bit Count Approach
//Time complexity: O(logk) - The time complexity is O(log k) as the time taken to convert the number to binary and 
//count the 1-bits is logarithmic with respect to k.
//Space complexity: O(1) -  The space complexity is O(1) as no extra space is used apart from the input and output variables. 

package Leetcode;

public class KthSymbolInGrammar_2 {

    public static void main(String[] args) {
        int n = 1, k = 1;
        System.out.println(kthGrammar(n, k));
    }

    public static int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }
}
