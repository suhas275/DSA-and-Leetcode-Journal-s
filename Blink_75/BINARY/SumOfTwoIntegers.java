package Blink_75.BINARY;


public class SumOfTwoIntegers {
    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = a & b;     // calculate carry
            a = a ^ b;             // sum without carry
            b = carry << 1;        // shift carry left
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers solution = new SumOfTwoIntegers();
        System.out.println(solution.getSum(1, 2)); // Output: 3
        System.out.println(solution.getSum(2, 3)); // Output: 5
    }
}

