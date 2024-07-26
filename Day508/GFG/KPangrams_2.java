//GFG
//K-Pangrams
//Time complexity: O(N)
//Space complexity: O(1) 

public class KPangrams_2 {

    public static void main(String[] args) {
        String str = "the quick brown fox jumps over the lazy dog";
        int k = 0;
        System.out.println(kPangram(str, k));
    }

    static boolean kPangram(String str, int k) {
        // code here
        int[] asc = new int[26];
        int charCnt = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ')
                continue;
            charCnt++;
            asc[c - 'a']++;
        }
        int cnt = 0;
        for (int i = 0; i < 26; ++i) {
            if (asc[i] == 0)
                ++cnt;
        }
        return k >= cnt && charCnt >= 26;
    }
}
