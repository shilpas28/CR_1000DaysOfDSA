//GFG
//Pair with given sum in a sorted array
//Time complexity: O(N)
//Space complexity: O(1) 

public class PairWithGivenSumInASortedArray {

    public static void main(String[] args) {
        int arr[] = { -1, 1, 5, 5, 7 };
        int target = 6;
        System.out.println(countPairs(arr, target));
    }

    static int countPairs(int arr[], int target) {
        // Complete the function
        int ans = 0, st = 0, end = arr.length - 1;
        while (st < end) {
            int currSum = arr[st] + arr[end];
            if (currSum > target) {
                end--;
            } else if (currSum < target) {
                st++;
            } else {
                int e1 = arr[st], e2 = arr[end], c1 = 0, c2 = 0;
                while (st <= end && arr[st] == e1) {
                    st++;
                    c1++;
                }
                while (st <= end && arr[end] == e2) {
                    end--;
                    c2++;
                }
                if (e1 == e2) {
                    ans += (c1 * (c1 - 1)) / 2;
                } else {
                    ans += c1 * c2;
                }
            }
        }
        return ans;
    }
}
