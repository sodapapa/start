package dataStructure;

class Stack {

	int top;
	int[] stack;
	int size;

	public Stack(int size) {
		top = -1;
		stack = new int[size];
		this.size = size;
	}

	public int peek() {
		return stack[top];
	}

	public void push(int value) {
		stack[++top] = value;
		System.out.println(stack[top] + " PUSH !");
	}

	public int pop() {
		System.out.println(stack[top] + " POP !");
		return stack[top--];
	}

	public void printStack() {
		System.out.println("-- STACK LIST --");
		for (int i = top; i >= 0; i--)
			System.out.println(stack[i]);
		System.out.println("-- END OF LIST --");
	}
}

public class GompangStack {

	public static void main(String args[]) {

               // 스택 동작 테스트
		Stack st = new Stack(100);

		st.push(5);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(1);

		st.printStack();

		st.pop();

		st.pop();

		st.push(15);

		st.printStack();

		st.peek();

		st.pop();
		st.pop();
		st.pop();
		st.pop();

		st.push(30);

		st.peek();
	}

}