import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);
        int n = nums.length;

        // Step 2: Iterate through the array
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;       // left pointer
            int k = n - 1;       // right pointer

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++; // need a larger number
                } else if (sum > 0) {
                    k--; // need a smaller number
                } else {
                    // Valid triplet found
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Skip duplicates for j and k
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return result;
    }

    // Test the method
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> triplets = ts.threeSum(nums);
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}
