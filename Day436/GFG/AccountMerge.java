//GFG
//Account Merge
//Time complexity: O(n*m*logn) - where n is the size of accounts and m is the size of the number of strings for a name.
//Space complexity: O(n*m) - where n is the size of accounts and m is the size of the number of strings for a name.

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountMerge {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<List<String>>();
        accounts.add(new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John", "johnnybravo@mail.com")));
        System.out.println(accountsMerge(accounts));
    }

    // Function to find the root of the set
    static int[] par;

    // Function to merge accounts
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // code here
        int n = accounts.size();
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        // s1
        Map<String, Integer> m1 = new HashMap<>();
        // itr for each email
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (m1.containsKey(mail)) { // same person exisits , need to perform union

                    int person = m1.get(mail);
                    union(i, person);
                } else {
                    // If the email doesn't have an owner, set the current account as the owner
                    m1.put(mail, i);
                }
            }
        }
        // s2
        // map to store merger acc
        Map<Integer, TreeSet<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // find the rep
            int root = find(i);
            List<String> al = accounts.get(i);

            // make a new tree set and if enc first time and put the list
            if (!map.containsKey(root)) // logn
                map.put(root, new TreeSet<String>());

            map.get(root).addAll(al.subList(1, al.size())); // emails start from 2nd
        }
        // print the ans
        List<List<String>> res = new ArrayList<List<String>>();

        for (int root : map.keySet()) {
            String name = accounts.get(root).get(0);
            ArrayList<String> curr = new ArrayList<>(map.get(root));
            curr.add(0, name);

            res.add(curr);
        }
        // Return the final merged accounts
        return res;
    }

    static int find(int idx) { // path compression
        if (idx == par[idx])
            return idx;
        return par[idx] = find(par[idx]);
    }

    static void union(int x, int y) {
        int x_rep = find(x), y_rep = find(y);
        if (x_rep == y_rep)
            return;
        par[y_rep] = x_rep;
    }
}
