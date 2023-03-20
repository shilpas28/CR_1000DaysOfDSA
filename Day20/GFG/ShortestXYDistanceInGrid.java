//GFG
//Shortest XY Distance In Grid
//Time complexity:
//Space complexity:

import java.util.ArrayList;

public class ShortestXYDistanceInGrid {

    static class Pair{
            int a; int b;
            Pair(int a, int b)
            {
                this.a=a; this.b=b;
            }
        }

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
        // code here
        ArrayList<Pair> x = new ArrayList<>();
        ArrayList<Pair> y = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid.get(i).get(j) == 'X')
                    x.add(new Pair(i, j));

                if (grid.get(i).get(j) == 'Y')
                    y.add(new Pair(i, j));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < x.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                ans = Math.min(ans, Math.abs(x.get(i).a - y.get(j).a) + Math.abs(x.get(i).b - y.get(j).b));
                ;
            }
        }
        return ans;

    }
}
