//GFG
//Reverse Coding
//Time complexity: O(1)
//Space complexity: O(1)

public class ReverseCoding {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(sumOfNaturals(n));
    }

    static int sumOfNaturals(int n) {
        // code here
        int mod = 1000000007;
        long ans=(((long)n*(n+1))/2)%mod;
        return (int)ans;
    }
}
