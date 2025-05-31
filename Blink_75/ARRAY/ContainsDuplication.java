import java.io.*;
import java.lang.*;

class Solution {

    public boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int nums[] = { 1, 2, 3, 1 };

        boolean res = sol.containsDuplicate(nums);

        // printing the result
        System.out.println(res);
    }
}

// Time Complexity: O(N*N), Because we are traversing the whole array again and
// again for every integer.

// Space Complexity: O(1), Since, we are not using any extra space.

// DETAILED EXPLANATION :
// https://takeuforward.org/data-structure/contains-duplicate-check-if-a-value-appears-atleast-twice/