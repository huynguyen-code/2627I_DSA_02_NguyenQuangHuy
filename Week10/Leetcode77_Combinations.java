import java.util.ArrayList;
import java.util.List;
class Leetcode77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 1;
        BackTrack(start, n, k, result, new ArrayList<>());
        return result;
    }
    void BackTrack(int start, int n, int k, List<List<Integer>> solutions, List<Integer> combination) {
        if (combination.size() == k) {
            solutions.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n; i++) {
            combination.add(i);
            BackTrack(i+1, n, k, solutions, combination);
            combination.remove(combination.size()-1);
        }
    }
}