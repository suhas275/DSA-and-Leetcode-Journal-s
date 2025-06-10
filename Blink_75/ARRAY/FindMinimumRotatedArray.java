public class FindMinimumRotatedArray {

    // Function to find the minimum element in a rotated sorted array
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If middle element is greater than the rightmost, minimum is to the right
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, minimum is at mid or to the left
                right = mid;
            }
        }

        return nums[left]; // left == right is the index of the minimum
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Minimum in nums1: " + findMin(nums1)); // Output: 1
        System.out.println("Minimum in nums2: " + findMin(nums2)); // Output: 0
        System.out.println("Minimum in nums3: " + findMin(nums3)); // Output: 11
    }
}
