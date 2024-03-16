class solution:
    def findKthLargest(self, nums: List[int], K: int) -> int:
        # Ensure K is within valid range (1 to len(nums))
        if K < 1 or K > len(nums):
            raise ValueError("Invalid K: K must be between 1 and the length of the list")

        # Adjust K to be the index of the Kth largest element (0-based indexing)
        K = len(nums) - K

        def quickSelect(l, r):
            pivot, p = nums[r], l
            for i in range(l, r):
                if nums[i] <= pivot:
                    nums[p], nums[i] = nums[i], nums[p]
                    p += 1
            nums[p], nums[r] = nums[r], nums[p]

            if p > K:
                return quickSelect(l, p - 1)
            elif p < K:
                return quickSelect(p + 1, r)
            else:
                return nums[p]

        return quickSelect(0, len(nums) - 1)
