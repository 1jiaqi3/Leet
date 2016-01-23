/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, 
peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. 
You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/
class MyStack {
    Queue<Integer> myQueue1=new LinkedList<>();
    Queue<Integer> myQueue2=new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        myQueue1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(myQueue1.size()>1){
            myQueue2.add(myQueue1.poll());
        }
        myQueue1.poll();
        Queue<Integer> tmp=new LinkedList<>();
        tmp=myQueue1;
        myQueue1=myQueue2;
        myQueue2=tmp;
    }

    // Get the top element.
    public int top() {
        while(myQueue1.size()>1){
            myQueue2.add(myQueue1.poll());
        }
        return myQueue1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return myQueue1.size()==0;
    }
}
