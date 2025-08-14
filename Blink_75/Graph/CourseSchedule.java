package Blink_75.Graph;
// This is LeetCode 207: Course Schedule,
// If there’s a cycle, you cannot finish all courses.
// We can solve it in two common ways:
// BFS (Kahn’s Algorithm) → Topological sort
// DFS → Cycle detection using recursion stack

// Here’s the Java solution using BFS (Kahn’s Algorithm),

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list and indegree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 2: Add courses with no prerequisites into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process courses
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: If we processed all courses, return true
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(solution.canFinish(numCourses1, prerequisites1)); // true

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(numCourses2, prerequisites2)); // false
    }
}
