//Given a collection of numbers that might contain duplicates, return all possible unique permutations.

//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        ArrayList<Integer> numbers=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            numbers.add(nums[i]);
        }
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        DFS(list,cur,numbers,set);
        return list;
    }
    public void DFS(List<List<Integer>> list,List<Integer> cur,ArrayList<Integer> numbers,HashSet<ArrayList<Integer>> set){
        if(numbers.size()==0&&!set.contains(cur)){
            list.add(new ArrayList<Integer> (cur));
            set.add(new ArrayList<Integer>(cur));
        }
        for(int i=0;i<numbers.size();i++){
            cur.add(numbers.get(i));
            ArrayList<Integer> tmp;
            if(numbers.size()>1){
                tmp=new ArrayList<Integer>(numbers);
                tmp.remove(i);
            }
            else tmp=new ArrayList<>();
            DFS(list,cur,tmp,set);
            cur.remove(cur.size()-1);
        }
    }
}
