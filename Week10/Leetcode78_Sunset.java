import java.util.ArrayList;
import java.util.List;
class Leetcode78_Sunset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        subsetBackTrack(0, nums, solutions, new ArrayList<>());
        return solutions;
    }
    void subsetBackTrack(int i, int[]arr, List<List<Integer>> solutions, List<Integer> subset) {
        if (i == arr.length) {
            solutions.add(new ArrayList<>(subset));
            return;
        }
        subset.add(arr[i]);
        subsetBackTrack(i+1, arr, solutions, subset);

        subset.remove(subset.size() - 1);
        subsetBackTrack(i+1, arr, solutions, subset);
    }
}