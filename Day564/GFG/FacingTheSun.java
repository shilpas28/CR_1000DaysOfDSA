//GFG
//Facing the sun
//Time complexity: O(N)
//Space complexity: O(1)

public class FacingTheSun {

    public static void main(String[] args) {
        int[] height = { 7, 4, 8, 2, 9 };
        System.out.println(countBuildings(height));
    }

    // Returns count buildings that can see sunlight
    public static int countBuildings(int[] height) {
        // code here
        int ans = 1, mx = height[0];
        for (int x : height) {
            if (x > mx) {
                mx = x;
                ans++;
            }
        }
        return ans;
    }
}
