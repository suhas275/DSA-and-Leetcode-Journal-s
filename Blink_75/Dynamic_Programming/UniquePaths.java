public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        long res = 1;

        for (int i = 1; i <= m - 1; i++) {
            res = res * (n - 1 + i) / i;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int result = uniquePaths(m, n);
        System.out.println("Unique Paths: " + result); // Output: 28
    }
}
