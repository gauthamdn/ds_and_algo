package stacks;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayStack stack = new ArrayStack(10);
		//stack.peek();
		stack.push(new Employee("Sachin","Tendulkar",40));
		stack.push(new Employee("Rahul","Dravid",38));
		stack.push(new Employee("Saurav","ganguly",30));
		System.out.println(stack.size());
		System.out.println("Peek "+stack.peek());
		stack.printStack();
		stack.pop();
		System.out.println(stack.size());
		stack.printStack();
		
		System.out.println("_".repeat(30));
		LinkedStack stack2 = new LinkedStack();
		stack2.push(new Employee("Sachin","Tendulkar",40));
		stack2.push(new Employee("Rahul","Dravid",38));
		stack2.push(new Employee("Saurav","ganguly",30));
		System.out.println(stack2.size());
		System.out.println("Peek "+stack2.peek());
		stack2.printStack();
		stack2.pop();
		System.out.println(stack2.size());
		stack2.printStack();
		
		
		
		
	}

}
