//Leetcode
//2582. Pass the Pillow
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class PassThePillow {

    public static void main(String[] args) {
        int n = 4, time = 5;
        System.out.println(passThePillow(n, time));
    }

    public static int passThePillow(int n, int time) {
        int ind = 1;
        int bool = 1;
        for (int i = 0; i < time; i++) {
            if (bool == 1) {
                if (ind < n)
                    ind++;
                else {
                    ind = ind - 1;
                    bool = 0;
                }
            } else {
                if (ind > 1)
                    ind = ind - 1;
                else {
                    ind = ind + 1;
                    bool = 1;
                }
            }
        }
        return ind;
    }
}
