public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;  // Ways to reach step 1
        int second = 2; // Ways to reach step 2
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = first + second; // Ways to reach current step
            first = second;
            second = result;
        }

        return second;
    }

    // Test cases
    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(2)); // Output: 2
        System.out.println(cs.climbStairs(3)); // Output: 3
        System.out.println(cs.climbStairs(5)); // Output: 8
    }
}
