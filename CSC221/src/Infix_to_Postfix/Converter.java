package Infix_to_Postfix;

import java.util.Stack;

import javax.swing.JOptionPane;


public class Converter
{
	static String infixToPostfix(String exp)
	{
		String result = new String("");
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i<exp.length(); ++i)
		{
			char c = exp.charAt(i);
			if (Character.isLetterOrDigit(c))
				result += c;
			
			else if (c == '(')
				stack.push(c);
			
			else if (c == ')')
			{
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();
				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression"; // invalid expression   
				else
					stack.pop();
				}
			else
			{
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
					result += stack.pop();
				stack.push(c);
				}
			}
// pop all the operators from the stack
		while (!stack.isEmpty())
			result += stack.pop();
		return result;
		}

// A utility function to return precedence of a given operator
// Higher returned value means higher precedence
	
	static int Prec(char ch)
	{
		switch (ch)
		{
		case '+':
			case '-':
				return 1;
				
		case '*':
			case '/':
				return 2;
				
		case '^':
			case '%':
				return 3;
				}
		return -1;
		
	}

  
	public static void main(String[] args)
	{
		
		while(true)
		{
		String input = JOptionPane.showInputDialog("Enter you Expression (No Space): ");
		JOptionPane.showMessageDialog(null,"Postfix expression is (No Space): "+infixToPostfix(input));
		System.exit(0);;
		}
	}
}

