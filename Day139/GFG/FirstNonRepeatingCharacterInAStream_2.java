//GFG
//First non-repeating character in a stream - Store frequency and index together
//Time complexity: O(N*26)
//Space complexity:  O(26)

package GFG;

public class FirstNonRepeatingCharacterInAStream_2 {
    public static void main(String[] args) {
        String A = "aabc";
        System.out.println(FirstNonRepeating(A));
    }

    public static String FirstNonRepeating(String A) {
        // code here
        StringBuilder ans = new StringBuilder();
        int n = A.length();
        int freq[][] = new int[26][2]; // store freq and idx;
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            freq[ch - 'a'][0]++; // increase frequency
            freq[ch - 'a'][1] = i; // store the idx
            int res_ch = -1;
            // get the character with freq 1 and lowest idx(asked first non repeating)
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) { // track the min index
                if (freq[j][0] == 1 && freq[j][1] < min) {
                    min = freq[j][1];
                    res_ch = j; // and store its corresponding character
                }
            }
            if (res_ch == -1) {
                ans.append("#");
            } else {
                ans.append((char) (res_ch + 'a'));
            }
        }
        return ans.toString();
    }
}
