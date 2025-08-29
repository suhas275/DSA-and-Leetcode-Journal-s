package Blink_75.Interval;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Traverse and merge
        for (int[] interval : intervals) {
            // If merged is empty OR no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Merge with last interval
                merged.get(merged.size() - 1)[1] = Math.max(
                        merged.get(merged.size() - 1)[1],
                        interval[1]
                );
            }
        }

        // Step 3: Convert to array
        return merged.toArray(new int[merged.size()][]);
    }

    // Main method to run in VS Code
    public static void main(String[] args) {
        MergeIntervals sol = new MergeIntervals();

        int[][] intervals1 = { {1,3}, {2,6}, {8,10}, {15,18} };
        int[][] result1 = sol.merge(intervals1);

        System.out.println("Example 1 Output:");
        for (int[] interval : result1) {
            System.out.println(Arrays.toString(interval));
        }

        int[][] intervals2 = { {1,4}, {4,5} };
        int[][] result2 = sol.merge(intervals2);

        System.out.println("\nExample 2 Output:");
        for (int[] interval : result2) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
