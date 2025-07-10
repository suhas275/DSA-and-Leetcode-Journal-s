import java.util.*;

public class LongestIncreasingSubsequenceOptimized {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(sub, num);
            if (idx < 0) {
                idx = -(idx + 1); // find the correct insert position
            }

            if (idx == sub.size()) {
                sub.add(num);
            } else {
                sub.set(idx, num);
            }
        }

        return sub.size();
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequenceOptimized lis = new LongestIncreasingSubsequenceOptimized();

        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); // Output: 4
        System.out.println(lis.lengthOfLIS(new int[]{0,1,0,3,2,3}));         // Output: 4
        System.out.println(lis.lengthOfLIS(new int[]{7,7,7,7,7}));           // Output: 1
    }
}

