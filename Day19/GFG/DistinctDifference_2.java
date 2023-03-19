//GFG - Same logic as previous just a bit more readable
//Distinct Difference
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DistinctDifference_2 {
    
    public static void main(String[] args) {
        int N = 3;
        int arr[] = { 4, 3, 3 };
        System.out.println(getDistinctDifference(N, arr));
    }

    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int in:A) map.put(in,map.getOrDefault(in,0)+1);
        
        for(int i=0;i<A.length;i++)
        {
            map.put(A[i],map.get(A[i])-1);
            if(map.get(A[i])==0) map.remove(A[i]);
            
            int left=set.size();
            int right=map.size();
            ans.add(left-right);

            set.add(A[i]);
        } 
            return ans;
    }
}
