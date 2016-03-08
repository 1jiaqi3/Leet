/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/
public class Solution {
    public int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (citations[mid] == citations.length - mid) {
                return citations[mid];
            } else if (citations[mid] < citations.length - mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return citations.length - (end + 1);
    }
}
