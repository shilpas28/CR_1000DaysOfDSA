//Leetcode
//338. Counting Bits - Bit manipulation
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class CountingBits {
    
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(countBits(n)));
    }

    public static int[] countBits(int n) {
        int [] l = new int[n+1];
        l[0]=0;
        
        for(int i = 1; i< n+1; i++){
            if (i%2 != 0){
                
                l[i] = (l[i/2]+1);
            
            } else{
                l[i] = (l[i/2]);
            }    
        }
        return l; 
    }
}
