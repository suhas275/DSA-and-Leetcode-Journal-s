public class JumpGame {

    public static boolean canJump(int[] nums) {
        int reachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false; // If we can't reach this point
            }
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true; // If we can reach or pass the last index
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println("Can jump (Test 1): " + canJump(nums1)); // true
        System.out.println("Can jump (Test 2): " + canJump(nums2)); // false
    }
}
