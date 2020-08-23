package com.luke.algorithm.stack;

import java.util.Stack;

public class ReversePolandNotation {
	public static void main(String[] args) {
		ReversePolandNotation rpn = new ReversePolandNotation();
		rpn.reverse("3 * ( 2 * ( 5 + 1 ) ) + 12 / 6");

	}

	//5 * ( 2 * ( 3 + 4 )) ==>    3 4 + 2 * 5 *          2 * ( 5 * (
	/*
	中缀转后缀表达式总结：
	1） 准备两个栈， 结果栈和运算符栈
	2） 从左向右扫描中缀表达式
	3） 如果是数字直接入结果栈
	4） 如果是运算符
		4.1 如果运算符栈为空，或者运算符是（，  直接进运算符栈
		4.2 如果运算符的优先级大与运算符栈栈顶的运算符， 直接进运算符栈
		4.3 如果运算符的优先级小于运算符栈栈顶的运算符， 将栈顶的运算符压入结果栈， 重复 4.1 步骤比较， 直到将当前运算符入运算符栈
		4.4 如果运算符是（， 将运算符栈出栈，直到运算符栈顶是）， 并将其直接pop掉。
	5） 扫描完毕， 将运算符栈剩余运算符全部pop并压入结果栈。

	 */
	/*
	逆波兰表达式计算过程：
	从左向右扫描表达式，数字入栈， 当遇到运算符时就从栈里pop两个数进行计算， 并将计算结果直接push进栈即可
	 */
	public void reverse(String notation){
		String result = "";
		Stack<String> rpnStack = new Stack<String>();
		Stack<String> oprStack = new Stack<String>();

		String[] array = notation.split(" ");
		int i = 0;
		while(true){
			if(array[i].matches("\\d+")){
				rpnStack.push(array[i]);
			}else{
				if(oprStack.isEmpty() || array[i].equals("(")){
					oprStack.push(array[i]);
				}else if(priority(array[i])>priority(oprStack.peek())){
					oprStack.push(array[i]);
				}else if(array[i].equals(")")){
					while(!oprStack.peek().equals("(")){
						rpnStack.push(oprStack.pop());
					}
					oprStack.pop();//pop "("
				}else{
					while(true){
						String topOpr = oprStack.pop();
						rpnStack.push(topOpr);
						if(oprStack.isEmpty()||priority(array[i])>priority(oprStack.peek())){
							oprStack.push(array[i]);
							break;
						}
					}
				}

			}
			i++;
			if(i==array.length){
				while(true){
					rpnStack.push(oprStack.pop());
					if(oprStack.size()==0){
						break;
					}
				}
				break;
			}
		}

		while(true){
			result = rpnStack.pop() + result;
			if(rpnStack.size()==0){
				break;
			}
		}

		System.out.printf("%s的逆波兰表达式是 %s", notation, result);
	}

	public static int priority(String operator) {
		if (operator.equals("*") || operator.equals("/")) {
			return 1;
		} else if (operator.equals("(")) {
			return -1;
		} else if (operator.equals("+")||operator.equals("-")) {
			return 0;
		}
		return -1;
	}
}
