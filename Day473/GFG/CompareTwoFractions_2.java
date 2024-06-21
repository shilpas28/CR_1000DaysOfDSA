//GFG
//Compare two fractions
//Time complexity: O(len|str|)
//Space complexity: O(1)

public class CompareTwoFractions_2 {

    public static void main(String[] args) {
        String str = "5/6, 11/45";
        System.out.println(compareFrac(str));
    }

    static String compareFrac(String str) {
        // Code here
        String[] arr = str.split(",");
        double[] dd = new double[2];
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            String[] a = s.trim().split("/");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            dd[i] = ((double) x / (double) y);

        }
        if (dd[0] > dd[1])
            return arr[0].trim();
        else if (dd[1] > dd[0])
            return arr[1].trim();
        else
            return "equal";
    }
}
