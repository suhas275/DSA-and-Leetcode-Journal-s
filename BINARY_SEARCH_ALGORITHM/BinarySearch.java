package BINARY_SEARCH_ALGORITHM;

public class BinarySearch {

    // Returns index of target if found, else -1
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Prevents overflow
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    // Example usage
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = bs.binarySearch(nums, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}