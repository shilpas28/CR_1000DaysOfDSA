//GFG
//Find maximum volume of a cuboid
//Time complexity: O(1)
//Space complexity: O(1)

public class FindMaximumVolumeOfACuboid {

    public static void main(String[] args) {
        double perimeter = 22, area = 15;
        System.out.println(maxVolume(perimeter, area));
    }

    static double maxVolume(double perimeter, double area) {
        // code here
        double l = (double) (perimeter - Math.sqrt(perimeter * perimeter - 24 * area)) / 12;
        double height = (perimeter / 4) - (2 * (l));
        double ans = l * l * height;
        return ans;
    }
}
