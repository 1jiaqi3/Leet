/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        HashSet<ArrayList> set = new HashSet<>();
        Backtracking(list, cur, set, target, candidates, 0);
        return list;
    }
    public void Backtracking(List<List<Integer>> list, List<Integer> cur, 
                            HashSet<ArrayList> set, int target, int[] candidates, int level) {
        
        if (target == 0 && !set.contains(cur)) {
            list.add(new ArrayList(cur));
            set.add(new ArrayList(cur));
        }
        if (target < 0) {
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            cur.add(candidates[i]);
            Backtracking(list, cur, set, target - candidates[i], candidates, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}

