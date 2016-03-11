/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        DFS(list, 0, numbers);
        return list;
    }
    public void DFS(List<List<Integer>> list, int begin, ArrayList<Integer> numbers) {
        if (begin >= numbers.size() - 1) {
            ArrayList<Integer> newList = new ArrayList<>(numbers);
            list.add(newList);
            return;
        }
        for (int i = begin; i < numbers.size(); i++) {
            swap(numbers, begin, i);
            DFS(list, begin + 1, numbers);
            swap(numbers, begin, i);
        }
    }
    public void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
