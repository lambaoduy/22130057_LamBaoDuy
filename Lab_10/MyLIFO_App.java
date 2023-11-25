package Lab_10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	public static <E> void reverve(E[] array) {
		Stack<E> stack = new Stack<E>();
		for (int i = 0; i < array.length; i++) {
			stack.add(array[i]);
		}
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = stack.peek();
		}
	}

	public static boolean isCorrect(String input) {
		if (input.charAt(0) == '}' || input.charAt(0) == ']' || input.charAt(0) == ')' || input.length() % 2 != 0) {
			return false;
		} else {
			int size = input.length() / 2;
			Stack<Character> stack = new Stack();
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
					stack.push(input.charAt(i));
				} else {
					switch (input.charAt(i)) {
					case '}':
						if (stack.contains('{')) {
							stack.pop();
							size--;
						} else {
							break;
						}
					case ')':
						if (stack.contains('(')) {
							stack.pop();
							size--;
						} else {
							break;
						}
					case ']':
						if (stack.contains('[')) {
							stack.pop();
							size--;
						} else {
							break;
						}
					}
				}
			}

			return stack.size() == 0 && size == 0;
		}
	}

	public static int evaluateExpression(String expression) {
		char[] tokens = expression.toCharArray();

		// Stack for operands
		Stack<Integer> values = new Stack<>();

		// Stack for operators
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			// Skip whitespaces
			if (tokens[i] == ' ')
				continue;

			// If the current character is a digit, push it onto the values stack
			if (Character.isDigit(tokens[i])) {
				StringBuilder sb = new StringBuilder();
				while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
					sb.append(tokens[i++]);
				}
				values.push(Integer.parseInt(sb.toString()));
				i--;
			}

			// If the current character is an opening parenthesis, push it onto the
			// operators stack
			else if (tokens[i] == '(') {
				operators.push(tokens[i]);
			}

			// If the current character is a closing parenthesis, solve the expression until
			// the matching opening parenthesis
			else if (tokens[i] == ')') {
				while (!operators.isEmpty() && operators.peek() != '(') {
					values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
				}
				operators.pop(); // Pop the opening parenthesis
			}

			// If the current character is an operator
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				// Solve any operators with higher or equal precedence from the stack
				while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
					values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
				}

				// Push the current operator onto the stack
				operators.push(tokens[i]);
			}
		}

		// Solve the remaining operators in the stack
		while (!operators.isEmpty()) {
			values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
		}

		// The result should be on the top of the values stack
		return values.pop();
	}

	// Helper method to check if op1 has higher or equal precedence than op2
	private static boolean hasPrecedence(char op1, char op2) {
		return (op2 == '+' || op2 == '-') && (op1 == '*' || op1 == '/');
	}

	// Helper method to apply an operator to two operands
	private static int applyOperator(char operator, int operand2, int operand1) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			if (operand2 == 0) {
				throw new ArithmeticException("Cannot divide by zero");
			}
			return operand1 / operand2;
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}

	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			input.add(input.peek());
			input.add(input.poll());
		}
	}

	public static <E> void mirror(Queue<E> input) {
		Stack<E> stack = new Stack<E>();
		int size = input.size();
		for (int i = 0; i < size; i++) {
			input.add(input.peek());
			stack.add(input.poll());
		}
		for (int i = 0; i < size; i++) {
			input.add(stack.pop());
		}

	}

	public static void main(String[] args) {

	}
}
