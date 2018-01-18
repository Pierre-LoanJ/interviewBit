class MinStack {
    private ListNode min = null;
    private ListNode head = null;
    
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }   
    
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    private boolean isEmpty() {
        return head == null;
    }
    
    public void push(int x) {
        ListNode old = head;
        head = new ListNode(x);
        head.next = old;
        if (this.min != null && this.min.val >= x) {
            ListNode oldMin = this.min;
            this.min = new ListNode(x);
            this.min.next = oldMin;
        }
        else if (this.min == null) {
            this.min = new ListNode(x);
        }
    }
    
    public void pop() {
        if (!this.isEmpty()) {
            int v = head.val;
            head = head.next;
            
            if (v == this.min.val) {
                min = min.next;
            }
        }
    }
    
    public int top() {
        if (!this.isEmpty()) {
            return head.val;
        }
        else return -1;
    }
    
    public int getMin() {
        if (this.min != null) return this.min.val;
        else return -1;
    }
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	minStack.push(2);
    	minStack.push(0);
    	minStack.push(3);
    	minStack.push(0);
    	System.out.println(minStack.getMin());  // --> Returns -3.
    	minStack.pop();
    	System.out.println(minStack.getMin());
    	minStack.pop();
    	System.out.println(minStack.getMin());
    	minStack.pop();
    	System.out.println(minStack.getMin());
    	
    }
}