//GFG
//Count all triplets with given sum in sorted array
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class CountAllTripletsWithGivenSumInSortedArray {

    public static void main(String[] args) {
        int arr[] = { -3, -1, -1, 0, 1, 2 };
        int target = -2;
        System.out.println(countTriplets(arr, target));
    }

    public static int countTriplets(int[] arr, int target) {
        // Code Here
        int ans = 0, size = arr.length;
        for (int i = 0; i < size; i++) {
            int j = i + 1, k = size - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    int e1 = arr[j], e2 = arr[k], c1 = 0, c2 = 0;
                    while (j <= k && arr[j] == e1) {
                        c1++;
                        j++;
                    }

                    while (j <= k && arr[k] == e2) {
                        c2++;
                        k--;
                    }
                    if (e1 == e2) {
                        ans += (c1 * (c1 - 1)) / 2;
                    } else {
                        ans += c1 * c2;
                    }
                }
            }
        }
        return ans;
    }
}
