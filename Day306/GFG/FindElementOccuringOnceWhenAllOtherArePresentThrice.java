//GFG
//Find element occuring once when all other are present thrice
//Time complexity: O(N) 
//Space complexity: O(1) 

public class FindElementOccuringOnceWhenAllOtherArePresentThrice {

    public static void main(String[] args) {
        int N = 4;
        int arr[] = { 1, 10, 1, 1 };
        System.out.println(singleElement(arr, N));
    }

    static int singleElement(int[] arr, int N) {
        // code here
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int ans = 0;
            for (int j = 0; j < N; j++) {
                if ((arr[j] & (1 << i)) != 0)
                    ans++;
            }
            if (ans % 3 == 1)
                res += (1 << i);
        }
        return res;
    }
}
