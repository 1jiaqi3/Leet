/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(list, cur, n, k, 1);
        return list;
    }
    public void DFS(List<List<Integer>> list, List<Integer> cur, int n, int k, int level) {
        if (cur.size() == k) {
            list.add(new ArrayList<Integer> (cur));
        }
        for (int i = level; i <= n; i++) {
            cur.add(i);
            DFS(list, cur, n, k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
