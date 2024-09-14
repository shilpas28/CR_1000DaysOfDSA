//GFG
//Alternate positive and negative numbers - Using ArrayList
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;

public class AlternatePositiveAndNegativeNumbers {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(4);
        arr.add(-2);
        arr.add(-1);
        arr.add(5);
        arr.add(0);
        arr.add(-5);
        arr.add(-3);
        arr.add(2);
        rearrange(arr);
        System.out.println(arr);
    }

    static void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> posNum = new ArrayList<>();
        ArrayList<Integer> negNum = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) >= 0)
                posNum.add(arr.get(i));
            else
                negNum.add(arr.get(i));
        }

        int i = 0, j = 0, k = 0;
        while (i < posNum.size() && j < negNum.size()) {
            arr.set(k, posNum.get(i));
            i++;
            k++;
            arr.set(k, negNum.get(j));
            j++;
            k++;
        }

        while (i < posNum.size()) {
            arr.set(k, posNum.get(i));
            i++;
            k++;
        }

        while (j < negNum.size()) {
            arr.set(k, negNum.get(j));
            j++;
            k++;
        }
    }
}
