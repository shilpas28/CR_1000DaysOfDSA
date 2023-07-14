//GFG
//Implement two stacks in an array
//Time complexity: O(1) for all the four methods.
//Space complexity: O(1) for all the four methods.

package GFG;

public class ImplementTwoStacksInAnArray {

    static class twoStacks {
        int arr[];
        int size;
        int top1, top2;

        twoStacks() {
            size = 100;
            arr = new int[100];
            top1 = -1;
            top2 = size;
        }

        // Function to push an integer into the stack1.
        void push1(int x) {
            // check if space exists
            if (top2 - top1 > 1)
                arr[++top1] = x;
        }

        // Function to push an integer into the stack2.
        void push2(int x) {
            if (top2 - top1 > 1)
                arr[--top2] = x;
        }

        // Function to remove an element from top of the stack1.
        int pop1() {
            if (top1 >= 0) {
                int x = arr[top1--];
                return x;
            }
            return -1;
        }

        // Function to remove an element from top of the stack2.
        int pop2() {
            if (top2 < size) {
                int x = arr[top2++];
                return x;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        twoStacks ts = new twoStacks();
        ts.push1(2);
        ts.push1(3);
        ts.push2(4);
        System.out.println(ts.pop1());
        System.out.println(ts.pop2());
        System.out.println(ts.pop2());
    }
}
