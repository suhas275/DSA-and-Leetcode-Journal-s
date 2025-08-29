// 🔹 Approach (Greedy Algorithm)

// This problem is the opposite of "Maximum number of non-overlapping intervals".

// Instead of maximizing non-overlapping intervals,

// We remove intervals until they are all non-overlapping.

// 👉 The greedy way:

// Sort intervals by end time.

// Iterate through, always picking the interval with the earliest end (to leave space for future intervals).

// If the current interval overlaps, remove it.

// Count how many removals needed.

package Blink_75.Interval;

import java.util.*;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        int[][] intervals1 = {{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        int[][] intervals3 = {{1,2},{2,3}};

        System.out.println("Output 1: " + sol.eraseOverlapIntervals(intervals1)); // Expected 1
        System.out.println("Output 2: " + sol.eraseOverlapIntervals(intervals2)); // Expected 2
        System.out.println("Output 3: " + sol.eraseOverlapIntervals(intervals3)); // Expected 0
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Step 1: Sort by end time (greedy approach)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0; // number of intervals removed
        int prevEnd = Integer.MIN_VALUE;

        // Step 2: Traverse intervals
        for (int[] interval : intervals) {
            if (interval[0] < prevEnd) {
                // Overlap found -> remove current interval
                count++;
            } else {
                // No overlap -> update the end marker
                prevEnd = interval[1];
            }
        }
        return count;
    }
}
