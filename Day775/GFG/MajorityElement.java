//GFG
//Majority Element - Brute Force Method - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class MajorityElement {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 1, 3, 5, 1 };
        System.out.println(majorityElement(arr));
    }

    static int majorityElement(int arr[]) {
        // code here
        // size of the given array:
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // selected element is v[i]
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of v[i]
                if (arr[j] == arr[i]) {
                    cnt++;
                }
            }
            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return arr[i];
        }
        return -1;
    }
}
