/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        DFS(list, 0, numbers, set);
        return list;
    }
    public void DFS(List<List<Integer>> list, int begin, ArrayList<Integer> numbers, HashSet<ArrayList<Integer>> set) {
        if(begin >= numbers.size() && !set.contains(numbers)){
            ArrayList<Integer> newList = new ArrayList<>(numbers);
            list.add(newList);
            set.add(newList);
            return;
        }
        for (int i = begin; i < numbers.size(); i++) {
            swap(numbers, begin, i);
            DFS(list, begin + 1, numbers, set);
            swap(numbers, begin, i);
        }
    }
    public void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
