//GFG
//Frogs And Jumps
//Time Complexity: O(N*log(leaves)) = O(NlogN)
//Space Complexity: O(leaves) = O(N)

public class FrogsAndJumps_1 {

    public static void main(String[] args) {
        int N = 3;
        int leaves = 4;
        int frogs[] = { 3, 2, 4 };
        System.out.println(unvisitedLeaves(N, leaves, frogs));
    }

    public static int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        int vis[] = new int[leaves + 1];
        for (int i = 0; i < N; i++) {
            int pos = frogs[i];

            if (pos <= leaves && vis[pos] == 0) {
                int temp = pos;
                while (temp <= leaves) {
                    if (vis[temp] == 0)
                        vis[temp] = 1;

                    temp += pos;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < leaves + 1; i++) {
            if (vis[i] == 0)
                count++;
        }
        return count;
    }
}
