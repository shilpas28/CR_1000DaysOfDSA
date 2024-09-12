//Leetcode
//1684. Count the Number of Consistent Strings
//Time complexity: O((words.length*(lengthiest string in words).length)
//Space complexity: O(26) 

public class CountTheNumberOfConsistentStrings {

    public static void main(String[] args) {
        String allowed = "abc";
        String[] words = { "a", "b", "c", "ab", "ac", "bc", "abc" };
        System.out.println(countConsistentStrings(allowed, words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int arr[] = new int[26];
        for (char i : allowed.toCharArray()) {
            arr[i - 'a'] = 1;
        }
        int count = 0;
        for (String k : words) {
            count += findConsistentString(arr, k);
        }
        return count;
    }

    public static int findConsistentString(int arr[], String k) {
        int flag = 1;
        for (int i = 0; i < k.length(); i++) {
            if (arr[k.charAt(i) - 'a'] == 0) {
                flag = 0;
                break;
            }
        }
        return flag;
    }
}
