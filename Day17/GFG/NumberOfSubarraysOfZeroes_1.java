//GFG - Using sum of N natural numbers formula
//Number of Subarrays of 0's
//Time complexity: O(N)
//Space compelxity: O(1)

public class NumberOfSubarraysOfZeroes_1 {
    
    public static void main(String[] args) {
        int N = 4;
        int arr[] = { 0, 0, 1, 0 };
        System.out.println(no_of_subarrays(N, arr));
    }

    static long no_of_subarrays(int N, int [] arr) {
		//Write your code here
		long res=0;
		long count=0;
		for(int i=0; i<N; i++)
		{
		    if(arr[i]==0)
		    count++;
		    else
		    {
		        res += (count)*(count+1)/2;  //Formula for sum of n natural numbers 
		        count=0;
		    }
		}
		 res += (count+1)*count/2;
		return res;
	}
}
