//GFG
//The Celebrity Problem
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Stack;

public class TheCelebrityProblem {

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 1 } };
        System.out.println(celebrity(mat));
    }

    public static int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (mat[a][b] == 1)
                st.push(b);
            else
                st.push(a);
        }

        int celeb = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != celeb && (mat[i][celeb] == 0 || mat[celeb][i] == 1))
                return -1;
        }
        return celeb;
    }
}
