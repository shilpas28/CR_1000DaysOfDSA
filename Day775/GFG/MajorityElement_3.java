//GFG
//Majority Element - Optimal Method 
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class MajorityElement_3 {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 1, 3, 5, 1 };
        System.out.println(majorityElement(arr));
    }

    static int majorityElement(int arr[]) {
        // code here
        // size of the given array:
        int n = arr.length;
        int cnt = 0; // count
        int el = 0; // Element
        // applying the algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = arr[i];
            } else if (el == arr[i])
                cnt++;
            else
                cnt--;
        }
        // checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el)
                cnt1++;
        }

        if (cnt1 > (n / 2))
            return el;
        return -1;
    }
}
