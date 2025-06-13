package Blink_75.BINARY;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Extract the last bit of n
            int bit = n & 1;

            // Shift result left to make room
            result = (result << 1) | bit;

            // Shift n right to process the next bit
            n >>>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(43261596));     // Output: 964176192
        System.out.println(rb.reverseBits(-3));           // Output: -1073741825
    }
}
