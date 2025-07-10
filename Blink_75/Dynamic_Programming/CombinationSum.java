import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target, 
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            // Found valid combination
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];

            if (num <= target) {
                current.add(num); // Choose the number
                backtrack(candidates, i, target - num, current, result); // Recurse (can reuse same number)
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();

        int[] c1 = {2, 3, 6, 7};
        System.out.println(cs.combinationSum(c1, 7)); // [[2,2,3],[7]]

        int[] c2 = {2, 3, 5};
        System.out.println(cs.combinationSum(c2, 8)); // [[2,2,2,2],[2,3,3],[3,5]]

        int[] c3 = {2};
        System.out.println(cs.combinationSum(c3, 1)); // []
    }
}
