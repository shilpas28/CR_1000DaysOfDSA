//GFG
//Police and Thieves
//Time complexity: O(N)
//Space complexity: O(1)

public class PoliceAndThieves {

    public static void main(String[] args) {
        char[] arr = { 'P', 'T', 'T', 'P', 'T' };
        int k = 1;
        System.out.println(catchThieves(arr, k));
    }

    public static int catchThieves(char[] arr, int k) {
        // code here
        int n = arr.length, i = -1, j = -1;

        for (int m = 0; m < n; m++) {
            if (i == -1 && arr[m] == 'P')
                i = m;
            if (j == -1 && arr[m] == 'T')
                j = m;
            if (i != -1 && j != -1)
                break;
        }

        if (i == -1 || j == -1)
            return 0;

        int caught = 0;

        while (i < n && j < n) {
            if (Math.abs(i - j) <= k) {
                caught++;
                i++;
                while (i < n && arr[i] != 'P')
                    i++;
                j++;
                while (j < n && arr[j] != 'T')
                    j++;
            } else if (i < j) {
                i++;
                while (i < n && arr[i] != 'P')
                    i++;
            } else {
                j++;
                while (j < n && arr[j] != 'T')
                    j++;
            }
        }

        return caught;
    }
}
