//Given a collection of distinct numbers, return all possible permutations.

//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].


public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        ArrayList<Integer> numbers=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            numbers.add(nums[i]);
        }
        DFS(list,cur,numbers);
        return list;
    }
    public void DFS(List<List<Integer>> list,List<Integer> cur,ArrayList<Integer> numbers){
        if(numbers.size()==0) list.add(new ArrayList<Integer> (cur));
        for(int i=0;i<numbers.size();i++){
            cur.add(numbers.get(i));
            ArrayList<Integer> tmp;
            if(numbers.size()>1){
                tmp=new ArrayList<Integer>(numbers);
                tmp.remove(i);
            }
            else tmp=new ArrayList<>();
            DFS(list,cur,tmp);
            cur.remove(cur.size()-1);
        }
    }
}
