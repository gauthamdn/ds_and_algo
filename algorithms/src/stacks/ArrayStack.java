package stacks;

import java.util.EmptyStackException;

public class ArrayStack {
	
	private Employee[] stack;
	private int top;
	
	
	public ArrayStack(int capacity) {
		stack = new Employee[capacity];
	}

	
	public void push(Employee employee) {
		
		if(top == stack.length) {
			// this means array is full
			// needs to resize the array
			// create a new array with double the size
			Employee[] newArray = new Employee[2*stack.length];
			
			// copy the old array into the newarray
			
			System.arraycopy(stack, 0, newArray, 0, stack.length);
			stack = newArray;
		
		}
		stack[top++] = employee;
		
		
		
	}
	
	public Employee pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		// use --top because array index starts with 0, so if arraylength is 5, top will be 5 and hence --top
		Employee employee = stack[--top];
		stack[top] = null;
		return employee;
	}
	
	public Employee peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		// here we use top-1 instead of --top because we dont want to change the value of the top variable.
		return stack[top-1];
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		
		return top == 0;
	}
	
	public void printStack() {
		for(int i = top-1;i>=0;i--) {
			System.out.println(stack[i]);
		}
	}
	
	
	
}
