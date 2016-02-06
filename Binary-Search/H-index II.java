/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/
public class Solution {
    public int hIndex(int[] citations) {
        int i = 0;
        int j = citations.length - 1;
        int mid = (i + j) / 2;
        while (i <= j) {
            mid = (i + j) / 2;
            if (citations[mid] == citations.length - mid) {
                return citations[mid];
            } else if (citations[mid] < citations.length - mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return citations.length - (j + 1);
    }
}
