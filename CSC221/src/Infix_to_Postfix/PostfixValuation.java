package Infix_to_Postfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//import java.util.EmptyStackException;

import javax.swing.JOptionPane;

public class PostfixValuation {

   public int evaluate(char[] postfix) {

       int n, r = 0;
       n = postfix.length;

       Stack<Integer> a = new Stack<Integer>();
       for (int i = 0; i < n; i++) {
    	   
           char ch = postfix[i];
           if (ch >= '0' && ch <= '9')
               a.push(ch - '0');
           else if (ch == ' ')
               continue;
           else {
               int x = a.pop();
               int y = a.pop();
               switch (ch) {
               
               case '+':
                   r = x + y;
                   break;

               case '-':
                   r = y - x;
                   break;

               case '*':
                   r = x * y;
                   break;

               case '/':
                   r = y / x;
                   break;

               case '^':
                   r = (int)Math.pow(y, x);
                   break;

               case '%':
                   r = y % x;
                   break;

               default:
                   r = 0;
               }
               a.push(r);
           }
       }

       r = a.pop();
       return (r);

   }

 // main method

   public static void main(String[] args)throws IOException

   {

       PostfixValuation postfixEval = new PostfixValuation();

       InToPostConvertor infixToPostfix = new InToPostConvertor();

       //String input;

       while(true)
       {
           
	       String input = JOptionPane.showInputDialog("Enter the Infix expresion(No Space and Alphabet):");
	       while (input.matches("[a-zA-Z]+"))
	       {
	    	   input = JOptionPane.showInputDialog("Invalid input!!! Please retype Expression(No Space and Alphabet).");
	       }
           char[] infix = input.trim().toCharArray();

           String postfix = infixToPostfix.convert(infix);
           JOptionPane.showMessageDialog(null, "Postfix Expression: "+postfix +
        	       "\nEvaluated value of postfix: "+postfixEval.evaluate(postfix.toCharArray()));
           System.exit(0);
       }
   }
   public static String getString()throws IOException
   {
       InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader br = new BufferedReader(isr);
       String s = br.readLine();
       return s;
   }
}