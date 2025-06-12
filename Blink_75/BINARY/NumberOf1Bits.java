package Blink_75.BINARY;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // removes the rightmost set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits sol = new NumberOf1Bits();
        System.out.println(sol.hammingWeight(11));         // Output: 3
        System.out.println(sol.hammingWeight(128));        // Output: 1
        System.out.println(sol.hammingWeight(2147483645)); // Output: 30
    }
}
