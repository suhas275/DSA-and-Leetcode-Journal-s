// ✅ Approach

// We traverse the intervals in three phases:
// Before new interval: Add all intervals ending before newInterval[0].
// Overlapping intervals: Merge all intervals that overlap with newInterval.
// After new interval: Add remaining intervals.
// Finally, return the merged list.

package Blink_75.Interval;

import java.util.*;

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1. Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // 3. Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    // Driver code for testing
    public static void main(String[] args) {
        InsertInterval sol = new InsertInterval();
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        System.out.println(Arrays.deepToString(sol.insert(intervals1, newInterval1)));
        // Output: [[1,5],[6,9]]

        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
        System.out.println(Arrays.deepToString(sol.insert(intervals2, newInterval2)));
        // Output: [[1,2],[3,10],[12,16]]
    }
}

