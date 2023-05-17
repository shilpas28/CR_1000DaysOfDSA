//GFG - does not accept as TLE
//Trace Path - Brute Force
//Time complexity: O(n*m*s)
//Space complexity: O(1)

public class TracePath {

    public static void main(String[] args) {
        int n = 1, m = 1;
        String s = "R";
        System.out.println(isPossible(n, m, s));
    }

    static int isPossible(int n, int m, String s) {
        // code here
        // int t_l = 0; int t_r= 0; int t_u =0; int t_d=0;// max consecutive l,r,ud
        // int f_lr =0; int f_ud=0;0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = i;
                int y = j;
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == 'L')
                        y -= 1;
                    else if (s.charAt(k) == 'R')
                        y += 1;
                    else if (s.charAt(k) == 'U')
                        x += 1;
                    else
                        x -= 1;

                    if (x < 0 || x >= n || y < 0 || y >= m)
                        break;
                }
                if (x >= 0 && x < n && y >= 0 && y < m)
                    return 1;
            }
        }
        return 0;
    }
}
