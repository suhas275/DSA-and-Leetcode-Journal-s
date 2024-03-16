class a {
    public int findKthLargest(int[] nums, int K) {
        // Ensure K is within valid range (1 to len(nums))
        if (K < 1 || K > nums.length) {
            throw new IllegalArgumentException("Invalid K: K must be between 1 and the length of the array");
        }

        // Adjust K to be the index of the Kth largest element (0-based indexing)
        K = nums.length - K;

        return quickSelect(nums, 0, nums.length - 1, K);
    }

    private int quickSelect(int[] nums, int l, int r, int K) {
        int pivot = nums[r], p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, p, i);
                p++;
            }
        }
        swap(nums, p, r);

        if (p > K) {
            return quickSelect(nums, l, p - 1, K);
        } else if (p < K) {
            return quickSelect(nums, p + 1, r, K);
        } else {
            return nums[p];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
