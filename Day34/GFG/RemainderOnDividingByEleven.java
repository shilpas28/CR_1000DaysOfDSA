//GFG
//Remainder on dividing by 11
//Time complexity: O(length of string x)
//Space complexity: O(1)

package GFG;

public class RemainderOnDividingByEleven {

    public static void main(String[] args) {
        String x = "1345";
        System.out.println(xmod11(x));
    }

    static int xmod11(String x) {
        // code here
        int val1 = 0;
        int val2 = 0;
        //Using rule for division by 11
        for (int i = 0; i < x.length(); i++) {
            if (i % 2 == 0)
                val1 += (int) (x.charAt(i) - '0'); //sum of even indexes
            else
                val2 += (int) (x.charAt(i) - '0'); //sum of odd indexes
        }
        return (val2 - val1) % 11 >= 0 ? (val2 - val1) % 11 : (val2 - val1) % 11 + 11;
    }

}
