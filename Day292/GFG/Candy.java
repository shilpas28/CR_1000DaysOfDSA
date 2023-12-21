//GFG
//Candy
//Time complexity: O(N)
//Space complexity: O(N) 

public class Candy {

    public static void main(String[] args) {
        int N = 3;
        int[] ratings = { 1, 0, 2 };
        System.out.println(minCandy(N, ratings));
    }

    static int minCandy(int N, int ratings[]) {
        // code here
        int arr[] = new int[N];
        arr[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                arr[i] = arr[i + 1] + 1;
            else
                arr[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1] && arr[i] <= arr[i - 1])
                arr[i] = arr[i - 1] + 1;
        }
        int res = 0;
        for (int x : arr)
            res += x;
        return res;
    }
}
