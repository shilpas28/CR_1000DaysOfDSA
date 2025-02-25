//GFG
//Histogram Max Rectangular Area - Brute Force Method - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

public class HistogramMaxRectangularArea {

    public static void main(String[] args) {
        int arr[] = { 60, 20, 50, 40, 10, 50, 60 };
        System.out.println(getMaxArea(arr));
    }

    public static int getMaxArea(int arr[]) {
        // your code here
        int n = arr.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
}
