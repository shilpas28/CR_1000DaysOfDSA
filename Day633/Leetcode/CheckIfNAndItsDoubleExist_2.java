//Leetcode
//1346. Check If N and Its Double Exist - Brute Force 
//Time complexity: O(N^2)
//Space complexity: O(1)

public class CheckIfNAndItsDoubleExist_2 {

    public static void main(String[] args) {
        int[] arr = { 10, 2, 5, 3 };
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && arr[i] == 2 * arr[j])
                    return true;
        return false;
    }
}
