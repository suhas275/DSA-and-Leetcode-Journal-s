package Blink_75.Matrix;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base case: entire word found
        if (index == word.length()) {
            return true;
        }

        // Boundary and mismatch check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited (temporarily)
        char temp = board[i][j];
        board[i][j] = '#'; // mark as visited

        // Explore all 4 directions
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        // Restore original cell (backtrack)
        board[i][j] = temp;

        return found;
    }

    // --- Helper for testing ---
    public static void main(String[] args) {
        char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board1, "ABCCED")); // true
        System.out.println(exist(board1, "SEE"));    // true
        System.out.println(exist(board1, "ABCB"));   // false
    }
}
