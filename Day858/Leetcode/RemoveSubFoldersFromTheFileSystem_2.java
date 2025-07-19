//Leetcode
//1233. Remove Sub-Folders from the Filesystem - Sort folders
//Time complexity: O(n * m * log(n))
//Space complexity: O(1) (excluding space cost of sorting part), where n = folder.length, m = average size of the strings in folder

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemoveSubFoldersFromTheFileSystem_2 {

    public static void main(String[] args) {
        String[] folder = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
        System.out.println(removeSubfolders(folder));
    }

    public static List<String> removeSubfolders(String[] folder) {
        LinkedList<String> ans = new LinkedList<>();
        Arrays.sort(folder);
        for (String f : folder)
            if (ans.isEmpty() || !f.startsWith(ans.peekLast() + '/')) // need '/' to ensure a parent.
                ans.offer(f);
        return ans;
    }
}
