//GFG
//Array Operations
//Time complexity: O(N)
//Space complexity: O(1)

public class ArrayOperations {

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {3,0,4,5};
        System.out.println(arrayOperations(n, arr));
    }

    public static int arrayOperations(int n, int[] arr) {
        // code here
        int cnt = 0;
        boolean flag = false, allNonZero = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                if (flag == false)
                    cnt++;
                flag = true;
            } else {
                allNonZero = false;
                flag = false;
            }
        }
        if (allNonZero)
            return -1;
        return cnt;
    }
}
