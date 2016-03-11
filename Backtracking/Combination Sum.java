/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        Backtracking(list, cur, target, candidates, 0);
        return list;
    }
    public void Backtracking(List<List<Integer>> list, List<Integer> cur, int target, int[] candidates, int level){
        if (target == 0) {
            list.add(new ArrayList(cur));
        }
        if(target < 0) {
            return;
        }
        for(int i = level; i < candidates.length; i++){
            cur.add(candidates[i]);
            Backtracking(list, cur, target - candidates[i], candidates, i);
            cur.remove(cur.size()-1);
        }
    }
}
