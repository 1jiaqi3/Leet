/**
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
**/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row=new ArrayList<>();
        int rowNum=0;
        while(rowNum<=rowIndex){
            row.add(1);
            for(int i=row.size()-2;i>=1;i--){
                row.set(i,row.get(i)+row.get(i-1));
            }
            rowNum++;
        }
        return row;
    }
}
