//GFG
//Find H-Index
//Time complexity: O(N)
//Space complexity: O(N) 

public class FindHIndex_2 {

    public static void main(String[] args) {
        int citations[] = { 3, 0, 5, 3, 0 };
        System.out.println(hIndex(citations));
    }

    // Function to find hIndex
    public static int hIndex(int[] citations) {
        // code here
        int arr[] = new int[citations.length + 1];
        int temp = 0;
        // this portion for mapping the citations[] values into arr[] array
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length + 1)
                arr[arr.length - 1]++;
            else
                arr[citations[i]]++;
        }
        // For matching the citation values from arr[]
        for (int i = arr.length - 1; i >= 0; i--) {
            temp += arr[i];
            if (temp >= i)
                return i;
        }
        return 0;
    }
}
