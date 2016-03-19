/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.
*/
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int maxArea = 0;
        int i = 1;
        while(i < heights.length) {
            if (heights[i - 1] > heights[i]) {
                while (!stk.empty() && heights[stk.peek()] > heights[i]) {
                    int cur = heights[stk.pop()];
                    if (stk.empty()) {
                        maxArea = Math.max(maxArea, i * cur);
                    } else {
                        maxArea = Math.max(maxArea, (i - stk.peek() - 1) * cur);
                    }
                }
            }
            stk.push(i);
            i++;
        }
        while (!stk.empty()) {
            int cur = heights[stk.pop()];
            if (stk.empty()) {
                maxArea = Math.max(maxArea, i * cur);
            } else {
                maxArea = Math.max(maxArea, (i - stk.peek() - 1) * cur);
            }
        }
        return maxArea;
    }
}
