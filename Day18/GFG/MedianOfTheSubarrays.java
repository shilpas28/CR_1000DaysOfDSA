//GFG
//Median Of The Subarrays
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.Arrays;

public class MedianOfTheSubarrays {
    
    public static void main(String[] args) {
        int N=5, M=2;
        int A[] = {2,1,3,5,4};
        System.out.println(countSubarray(N, A, M));
    }

    static long countSubarray(int N, int A[], int M) 
    { 
        // code here
        long a = help(N,A,M);
        long b = help(N,A,M+1);
        return a-b;
    }

    static long help(int n,int arr[],int m){
        int mm[] = new int[2*n+1];
        Arrays.fill(mm,0);
        long ans=0,currElement=0;
        int sum=n;
        mm[n]++;
        for(int i=0;i<n;i++){
            if(arr[i]<m){
                sum--;
                currElement-=mm[sum];
            }
            else{
                currElement+=mm[sum];
                sum++;
            }
            ans+=currElement;
            mm[sum]++;
        }
        return ans;
    }
}
