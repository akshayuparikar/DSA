package dsa;

import java.util.Stack;

public class StackPopPush {

	public static void main(String[] args) {
	      
    Stack<Integer> s= new Stack<>();
   
    s.push(10);
    s.push(20);
    s.push(30);
    s.push(40);
    s.push(50);
    s.push(60);
    s.push(70);
    s.push(89);
    s.push(21);
    System.out.println("Display Stack:");
    System.out.println(s);
    
    s.pop();
    s.pop();
    System.out.println("After Pop:"+s);
    s.peek();
    System.out.println("Peek Element of stack:"+s.peek());
    
	}
}
