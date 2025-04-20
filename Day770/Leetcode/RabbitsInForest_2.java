//Leetcode
//781. Rabbits in Forest
//Time complexity: O(N)
//Space complexity: O(1) 

public class RabbitsInForest_2 {

    public static void main(String[] args) {
        int[] answers = { 1, 1, 2 };
        System.out.println(numRabbits(answers));
    }

    public static int numRabbits(int[] answers) {
        int c[] = new int[1000], res = 0;
        for (int i : answers)
            if (c[i]++ % (i + 1) == 0)
                res += i + 1;
        return res;
    }
}
