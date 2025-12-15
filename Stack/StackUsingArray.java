package dsa;

public class StackUsingArray {

	int arr[], top=-1, capacity=0;
	
	public StackUsingArray(int size) {
		capacity = size;
		arr = new int[capacity];
		top = -1;
	}
	
	public static void main(String[] args) {
		StackUsingArray sua = new StackUsingArray(5);
		sua.push(10);
		sua.push(10);
		sua.push(10);
		sua.push(10);
		sua.push(12);
		sua.peek();
	}
	
	// push operation is to add element to the top of the stack
	// Check if the stack is full (overflow)
	public void push(int item) {
		if(isFull()) {
			System.out.println("Stack Overflow!!!");
			return;
		}
		arr[++top] = item;
	}
	
	// delete the top element from the stack
	// is the stack empty (prerequisite)
	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow!!!");
			return;
		}
		top--;
	}
	
	// is to check the element present in the top of the stack
	// is the stack empty (prerequisite)
	public void peek() {
		if(isEmpty()) {
			System.out.println("Stack Underflow!!!");
			return;
		}
		System.out.println("the top element is: "+arr[top]);
	}

	// check if the stack in empty.
	// this is a prerequisite check for pop() and peek() operation 
	boolean isEmpty() {
		return top==-1;
	}
	
	// checks if the stack is full.
	// this is a prerequisite check for push() operation
	boolean isFull() {
		return top == capacity-1;
	}
	
}
