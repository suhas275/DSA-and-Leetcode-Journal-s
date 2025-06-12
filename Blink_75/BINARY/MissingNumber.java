package Blink_75.BINARY;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        System.out.println(mn.missingNumber(new int[]{3, 0, 1}));       // Output: 2
        System.out.println(mn.missingNumber(new int[]{0, 1}));          // Output: 2
        System.out.println(mn.missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // Output: 8
    }
}

