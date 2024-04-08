//Leetcode
//1700. Number of Students Unable to Eat Lunch
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {
        int[] students = { 1, 1, 1, 0, 0, 1 };
        int[] sandwiches = { 1, 0, 0, 0, 1, 1 };
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int len = students.length;
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students)
            studentQueue.add(student);
        Stack<Integer> sandwichStack = new Stack<>();
        for (int i = len - 1; i >= 0; i--)
            sandwichStack.push(sandwiches[i]);
        int served = 0;
        while (!studentQueue.isEmpty() && served < studentQueue.size()) {
            if (sandwichStack.peek().equals(studentQueue.peek())) {
                sandwichStack.pop();
                studentQueue.poll();
                served = 0;
            } else {
                studentQueue.add(studentQueue.peek());
                studentQueue.poll();
                served++;
            }
        }
        return studentQueue.size();
    }
}
