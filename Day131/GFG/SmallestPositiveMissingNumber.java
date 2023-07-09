//GFG
//Smallest Positive missing number
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class SmallestPositiveMissingNumber {
    
    public static void main(String[] args) {
        int N = 5;
        int arr[] = {1,2,3,4,5};
        System.out.println(missingNumber(arr, N));
    }

    public static int missingNumber(int arr[], int size)
    {
        // Your code here
        for(int i = 0; i < size; ++ i) {
            while(arr[i] >= 1 && arr[i] <= size && arr[i] != arr[arr[i]-1])
                // swap(A[i], A[A[i] - 1]);
                {
                    int t = arr[arr[i] - 1]; arr[arr[i] - 1] = arr[i];  arr[i]=t;
                }
        }
        for(int i = 0; i < size; ++ i)
            if(arr[i] != i + 1)
                return i + 1;
        return size + 1;
    }
}
