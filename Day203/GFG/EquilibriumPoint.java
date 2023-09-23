//GFG - Brute force method - not accepted as TLE
//Equilibrium Point 
//Time complexity: O(2*N)
//Space complexity: O(1)

package GFG;

public class EquilibriumPoint {
    
    public static void main(String[] args) {
        int n = 5 ;
        long A[] = {1,3,5,2,2};
        System.out.println(equilibriumPoint(A, n));
    }

    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        if(n==1) return 1;
        long sum = 0;
        for(long x : arr){
            sum+=x;
        }
        
        long sum1 = arr[0];
        sum = sum-arr[0];
        
        for(int i=1; i<n; i++){
            sum = sum - arr[i];
            if(sum==sum1) return i+1;
            sum1 = sum1+arr[i];
        }
        return -1;
    }
}
