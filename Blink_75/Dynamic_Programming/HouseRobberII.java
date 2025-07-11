public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    // Standard House Robber I logic but only for a subarray
    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;

        for (int i = start; i <= end; i++) {
            int temp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobberII hr = new HouseRobberII();
        System.out.println(hr.rob(new int[]{2, 3, 2})); // Output: 3
        System.out.println(hr.rob(new int[]{1, 2, 3, 1})); // Output: 4
        System.out.println(hr.rob(new int[]{1, 2, 3})); // Output: 3
    }
}
