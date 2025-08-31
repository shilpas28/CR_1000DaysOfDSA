//GFG
//Container With Most Water
//Time complexity: O(N)
//Space complexity: O(1) 

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int arr[] = { 1, 5, 4, 3 };
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int arr[]) {
        // Code Here
        int i = 0, j = arr.length - 1, ans = 0;
        while (i < j) {
            int currWater = Math.min(arr[i], arr[j]) * (j - i);
            ans = Math.max(ans, currWater);
            if (arr[i] < arr[j])
                i++;
            else
                j--;
        }
        return ans;
    }
}
