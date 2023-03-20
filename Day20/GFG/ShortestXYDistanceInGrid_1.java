//GFG
//Shortest XY Distance In Grid
//Time complexity: O(N*M)
//Space complexity: O(N*M)

import java.util.ArrayList;

public class ShortestXYDistanceInGrid_1 {

    public static void main(String[] args) {
        int N = 4;
        int M = 4;
        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        ArrayList<Character> grid1 = new ArrayList<>();
        grid1.add('X');
        grid1.add('O');
        grid1.add('O');
        grid1.add('O');
        ArrayList<Character> grid2 = new ArrayList<>();
        grid1.add('O');
        grid1.add('Y');
        grid1.add('O');
        grid1.add('Y');
        ArrayList<Character> grid3 = new ArrayList<>();
        grid1.add('X');
        grid1.add('X');
        grid1.add('O');
        grid1.add('O');
        ArrayList<Character> grid4 = new ArrayList<>();
        grid1.add('O');
        grid1.add('Y');
        grid1.add('O');
        grid1.add('O');

        grid.add(grid1);
        grid.add(grid2);
        grid.add(grid3);
        grid.add(grid4);

        System.out.println(shortestXYDist(grid, N, M));
    }

    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
            int M) {
        int[][] dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid.get(i).get(j) == 'X')
                    dist[i][j] = 0;
                else {
                    if (i - 1 >= 0) // top
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    // if(j+1<M) //right --
                    // dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    // if(i+1<N)//bottom --
                    // dist[i][j] = Math.min(dist[i][j], dist[i+1][j] + 1);
                    if (j - 1 >= 0) // left
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);

                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (grid.get(i).get(j) == 'X')
                    dist[i][j] = 0;
                else {
                    // if (i-1 >= 0) //top
                    // dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j + 1 < M) // right --
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    if (i + 1 < N)// bottom --
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    // if (j-1>=0) //left
                    // dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);

                }
            }
        }

        int ans = Integer.MAX_VALUE - 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid.get(i).get(j) == 'Y')
                    ans = Math.min(ans, dist[i][j]);
            }
        }

        return ans;
    }
}
