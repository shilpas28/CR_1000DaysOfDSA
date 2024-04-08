//Leetcode
//1700. Number of Students Unable to Eat Lunch
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class NumberOfStudentsUnableToEatLunch_2 {

    public static void main(String[] args) {
        int[] students = { 1, 1, 1, 0, 0, 1 };
        int[] sandwiches = { 1, 0, 0, 0, 1, 1 };
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int circleStudentCount = 0, squareStudentCount = 0;
        for (int student : students) {
            if (student == 1)
                squareStudentCount++;
            else
                circleStudentCount++;
        }
        for (int sandwich : sandwiches) {
            if (sandwich == 1) {
                if (squareStudentCount > 0)
                    squareStudentCount--;
                else
                    break;
            }
            if (sandwich == 0) {
                if (circleStudentCount > 0)
                    circleStudentCount--;
                else
                    break;
            }
        }
        return squareStudentCount + circleStudentCount;
    }
}
