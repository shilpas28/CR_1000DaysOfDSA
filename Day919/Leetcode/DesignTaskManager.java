//Leetcode
//3408. Design Task Manager
//Time complexity: Initialization (constructor) - O(NlogN), add - O(logN), edit - O(logN), rmv - O(logN), execTop - O(logN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DesignTaskManager {

    private static class TaskManager {

        Map<Integer, int[]> mp; // taskId -> {userId, priority}
        TreeSet<int[]> st; // {priority, taskId}

        public TaskManager(List<List<Integer>> tasks) {
            mp = new HashMap<>();
            st = new TreeSet<>((a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0]; // sort by priority
                return a[1] - b[1]; // tie -> smaller taskId
            });

            for (List<Integer> task : tasks) {
                int userId = task.get(0), taskId = task.get(1), priority = task.get(2);
                st.add(new int[] { priority, taskId });
                mp.put(taskId, new int[] { userId, priority });
            }
        }

        public void add(int userId, int taskId, int priority) {
            st.add(new int[] { priority, taskId });
            mp.put(taskId, new int[] { userId, priority });
        }

        public void edit(int taskId, int newPriority) {
            int[] p = mp.get(taskId);
            st.remove(new int[] { p[1], taskId }); // old {priority, taskId}
            st.add(new int[] { newPriority, taskId });
            mp.put(taskId, new int[] { p[0], newPriority });
        }

        public void rmv(int taskId) {
            int[] p = mp.get(taskId);
            st.remove(new int[] { p[1], taskId });
            mp.remove(taskId);
        }

        public int execTop() {
            if (mp.isEmpty())
                return -1;
            int[] top = st.last(); // highest priority
            int taskId = top[1];
            int userId = mp.get(taskId)[0];
            st.remove(top);
            mp.remove(taskId);
            return userId;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> tasks = new ArrayList<>();
        tasks.add(new ArrayList<>(Arrays.asList(1, 101, 10)));
        tasks.add(new ArrayList<>(Arrays.asList(2, 102, 20)));
        tasks.add(new ArrayList<>(Arrays.asList(3, 103, 15)));
        TaskManager taskManager = new TaskManager(tasks); // Initializes with three tasks for Users 1, 2, and 3.
        taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
        taskManager.edit(102, 8); // Updates priority of task 102 to 8.
        taskManager.execTop(); // return 3. Executes task 103 for User 3.
        taskManager.rmv(101); // Removes task 101 from the system.
        taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
        taskManager.execTop(); // return 5. Executes task 105 for User 5.
    }

}
