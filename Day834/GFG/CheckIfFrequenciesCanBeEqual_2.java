//GFG
//Check if frequencies can be equal
//Time complexity: O(N)
//Space complexity: O(1)

public class CheckIfFrequenciesCanBeEqual_2 {

    public static void main(String[] args) {
        String s = "xyyz";
        System.out.println(sameFreq(s));
    }

    static boolean sameFreq(String s) {
        // code here
        int[] freq = new int[26];
        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        if (check(freq))
            return true;
        // reduce all ch freq one by one
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;

                if (check(freq))
                    return true;

                freq[i]++;
            }
        }
        return false;
    }

    static boolean check(int freq[]) {
        int n = -1; // get firstNonZero
        for (int f : freq) {
            if (f > 0) {
                if (n == -1)
                    n = f;
                else if (f != n)
                    return false;
            }
        }
        return true;
    }
}
