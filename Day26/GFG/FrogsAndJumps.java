//GFG
//Frogs And Jumps
//Time Complexity: O(N^2)
//Space Complexity: O(N)

public class FrogsAndJumps {

    public static void main(String[] args) {
        int N = 3;
        int leaves = 4;
        int frogs[] = { 3, 2, 4 };
        System.out.println(unvisitedLeaves(N, leaves, frogs));
    }

    public static int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        int visited[] = new int[leaves + 1];
        for (int i = 0; i < N; i++) {
            int pos = frogs[i];
            int temp = pos;
            while (temp <= leaves) {
                if (visited[temp] == 0)
                    visited[temp] = 1;

                temp += pos;
            }
        }
        int count = 0;
        for (int i = 1; i < leaves + 1; i++) {
            if (visited[i] == 0)
                count++;
        }
        return count;
    }
}
