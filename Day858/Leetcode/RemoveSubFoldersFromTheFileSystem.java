//Leetcode
//1233. Remove Sub-Folders from the Filesystem - Sort by length, then put only parent into HashSet
//Time complexity: O(n * (logn + m ^ 2))
//Space complexity: O(n * m), where n = folder.length, m = average size of the strings in folder

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveSubFoldersFromTheFileSystem {

    public static void main(String[] args) {
        String[] folder = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
        System.out.println(removeSubfolders(folder));
    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparing(s -> s.length()));
        Set<String> seen = new HashSet<>();
        outer: for (String f : folder) {
            for (int i = 2; i < f.length(); ++i)
                if (f.charAt(i) == '/' && seen.contains(f.substring(0, i)))
                    continue outer;
            seen.add(f);
        }
        return new ArrayList<>(seen);
    }
}
