//Leetcode
//1700. Number of Students Unable to Eat Lunch
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class NumberOfStudentsUnableToEatLunch_3 {

    public static void main(String[] args) {
        int[] students = { 1, 1, 1, 0, 0, 1 };
        int[] sandwiches = { 1, 0, 0, 0, 1, 1 };
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        for (int student : students)
            counts[student]++;

        int remaining = sandwiches.length;
        for (int sandwich : sandwiches) {
            if (counts[sandwich] == 0)
                break;
            if (remaining-- == 0)
                break;
            counts[sandwich]--;
        }

        return remaining;
    }
}
