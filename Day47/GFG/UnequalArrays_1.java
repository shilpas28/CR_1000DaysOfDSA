//GFG
//Unequal Arrays
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Collections;

public class UnequalArrays_1 {
    
    public static void main(String[] args) {
        int N = 3;
        int A[] = { 2, 5, 6 };
        int B[] = { 1, 2, 10 };
        System.out.println(solve(N, A, B));
    }

    public static long solve(int N, int[] A, int[] B) {
        // code here
        long sum = 0;
        //make two al for storing and separting odd and even ele
        ArrayList<Integer> x[]=new ArrayList[2], y[]=new ArrayList[2];
        for(int i=0;i<2;i++)
        {
            x[i]=new ArrayList<>();
            y[i]=new ArrayList<>();
        }
        //2
        for(int i = 0; i < N; i++) 
        {
           sum += A[i] - B[i];
           if(A[i]%2==0) 
            x[0].add(A[i]);
            else 
            x[1].add(A[i]);

            if(B[i]%2==0) 
            y[0].add(B[i]);
            else 
            y[1].add(B[i]);
            
        }
        // not poss to convert
        if(sum != 0 || x[0].size() != y[0].size())
        return -1;
        
        long ans = 0;
        
        // sort list one by one and take the difference.
        for(int i = 0; i < 2; i++) 
        {
           Collections.sort(x[i]);
           Collections.sort(y[i]);
        
           for(int j = 0; j < x[i].size(); j++) 
             ans += Math.abs(x[i].get(j) - y[i].get(j)) / 2;
        }
        return ans/2 ;
    }
}
