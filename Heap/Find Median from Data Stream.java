/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2
*/

class MedianFinder {
    
    private PriorityQueue<Integer> small = new PriorityQueue<>(1, new Comparator<Integer>() {
        public int compare(Integer p, Integer q) {
            return q - p;
        };
    });
    private PriorityQueue<Integer> large = new PriorityQueue<>(1);
    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add(num);
        // This way, numbers in small are always the smallest half 
        small.add(large.poll());
        if (large.size() < small.size()) {
            large.add(small.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return large.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
