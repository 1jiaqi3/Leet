/**
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
**/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> table=new ArrayList<>();
        if(numRows==0) return table;
        ArrayList<Integer> first=new ArrayList<>();
        first.add(1);
        table.add(first);
        for(int i=2;i<=numRows;i++){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(1);
            for(int j=1;j<i-1;j++){
                list.add(table.get(i-2).get(j-1)+table.get(i-2).get(j));
            }
            list.add(1);
            table.add(list);
        }
        return table;
    }
}
