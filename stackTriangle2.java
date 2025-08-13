// Вычисление треугольных чисел (стек вместо рекурсии)
import java.io.*;

class StackTriangle2App {
	
	static int theNumber;
	static int theAnswer;
	static StackX theStack;

	public static void main(String[] args) throws IOException {
		
		System.out.print("Enter a number: ");
		theNumber = getInt();
		stackTriangle();
		System.out.println("Triangle=" + theAnswer);
	}

	public static void stackTriangle() {
		
		theStack  = new StackX(10000);
		theAnswer = 0;

		while (theNumber > 0) theStack.push(theNumber--);
		while (!theStack.isEmpty()) theAnswer += theStack.pop();
	}

	public static String getString() throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}

class StackX {
	
	private int maxSize;
	private int[] stackArray;
	private int top;

	public StackX(int s) {
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int p) { stackArray[++top] = p; }

	public int pop() { return stackArray[top--]; }

	public int peek() { return stackArray[top]; }

	public boolean isEmpty() { return (top == -1); }
}
