//Find all possible combinations of k numbers that add up to a number n, 
//given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

//Ensure that numbers within the set are sorted in ascending order.


//Example 1:

//Input: k = 3, n = 7

//Output:

//[[1,2,4]]

//Example 2:

//Input: k = 3, n = 9

//Output:

//[[1,2,6], [1,3,5], [2,3,4]]
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        int[] candidates={1,2,3,4,5,6,7,8,9};
        Arrays.sort(candidates);
        Backtracking(list,cur,n,k,candidates,0);
        return list;
    }
    public void Backtracking(List<List<Integer>> list,List<Integer> cur,int n,int k,int[] candidates,int level){
        if(n==0&&cur.size()==k) list.add(new ArrayList(cur));
        if(n<0||cur.size()>k) return;
        for(int i=level;i<candidates.length;i++){
            cur.add(candidates[i]);
            Backtracking(list,cur,n-candidates[i],k,candidates,i+1);
            cur.remove(cur.size()-1);
        }
    }
}
