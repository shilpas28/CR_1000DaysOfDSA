//GFG
//Distinct Difference
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DistinctDifference {
    
    public static void main(String[] args) {
        int N = 3;
        int arr[] = { 4, 3, 3 };
        System.out.println(getDistinctDifference(N, arr));
    }

    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        // code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        Set<Integer> s1= new HashSet<>();
          Set<Integer> s2= new HashSet<>();
           
        for(int i=0; i<N; i++)
        {
           
            for(int j=i+1; j<N; j++)
            {
                s2.add(A[j]);
            }
            al.add(s1.size()- s2.size());
            s2.clear();
            s1.add(A[i]);
            
        }
        return al;
    }
}
