package com.luke.algorithm.stack;

public class CalculatorDemo {
	public static void main(String[] args) {
		String inputStr = "7+5*2-8/4+6+1-3=";
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 oprStack = new ArrayStack2(10);

		for(int i=0; i<inputStr.length()-1;i++){
			char x = inputStr.charAt(i);
			if(x=='+'||x=='-'||x=='*'||x=='/'){
				if(oprStack.isEmpty()){
					oprStack.push((int)x);
					continue;
				}

				if(oprStack.priority((int)x)>oprStack.priority(oprStack.peek())){
					oprStack.push((int)x);
				}else{
					while(true){
						char opr = (char)oprStack.pop();
						int num1 = numStack.pop();
						int num2 = numStack.pop();
						numStack.push(getResult(opr, num1, num2));
						if(oprStack.isEmpty()){
							break;
						}
						if(oprStack.priority((int)x)>oprStack.priority(oprStack.peek())){
							break;
						}
					}
					oprStack.push((int)x);
				}
			}else if(x=='='){
				char opr = (char)oprStack.pop();
				int num1 = numStack.pop();
				int num2 = numStack.pop();
				numStack.push(getResult(opr, num1, num2));

			}else{
				numStack.push((int)x-48);
			}
		}

		while (!oprStack.isEmpty()){
			char opr = (char)oprStack.pop();
			int num1 = numStack.pop();
			int num2 = numStack.pop();
			numStack.push(getResult(opr, num1, num2));
		}
		System.out.printf("%s %d", inputStr, numStack.pop());
	}

	private static int getResult(char opr, int num1, int num2) {
		switch (opr){
			case '+': return num1+num2;
			case '-': return num2-num1;
			case '*': return num1*num2;
			case '/': return num2/num1;
			default:return 0;
		}
	}

}

class ArrayStack2 {
	int top = -1;
	int max;
	int[] array;

	ArrayStack2(int max) {
		this.max = max;
		array = new int[max];
	}

	public boolean isEmpty() {
		if (top == -1) {
//			System.out.println("empty");
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (top == max - 1) {
			System.out.println("full");
			return true;
		}
		return false;
	}

	public void push(int i) {
		if (isFull()) {
			System.out.println("full, can't push");
			return;
		}
		top++;
		array[top] = i;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("empty, can't pop");
		}
		int result = array[top];
		top--;
		return result;
	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("empty, can't pop");
		}


		return array[top];
	}

	public int priority(int i) {
		if ((char) i == ('*') || ((char) i == ('/'))) {
			return 1;
		} else if ((char) i == ('=')) {
			return -1;
		} else if (i == ('+') || i == ('-')) {
			return 0;
		}
		return -1;
	}
}