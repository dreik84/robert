// Использование стека для перестановки символов строки
// Запуск программы: java ReverseApp
import java.io.*;

class ReverseApp {
	
	public static void main(String[] args) throws IOException {
		
		String input, output;

		while (true) {
			
			System.out.print("Enter a string: ");
			System.out.flush();
			input = getString();
			
			if (input.equals("")) break;

			Reverser theReverser = new Reverser(input);
			output = theReverser.doRev();
			System.out.println("Reversed: " + output);
		}
	}

	public static String getString() throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}

class Reverser {
	
	private String input;
	private String output;

	public Reverser(String in) { input = in; }

	public String doRev() {
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			theStack.push(ch);
		}

		output = "";
		
		while ( !theStack.isEmpty() ) {
			char ch = theStack.pop();
			output = output + ch;
		}

		return output;
	}	
}

class StackX {

        private int maxSize;
        private char[] stackArray;
        private int top;

        public StackX(int s) {
                maxSize = s;
                stackArray = new char[maxSize];
                top = -1;
        }

        public void push(char j) { stackArray[++top] = j; }

        public char pop() { return stackArray[top--]; }

        public char peek() { return stackArray[top]; }

        public boolean isEmpty() { return (top == -1); }

        public boolean isFull() { return (top == maxSize - 1); }
}
