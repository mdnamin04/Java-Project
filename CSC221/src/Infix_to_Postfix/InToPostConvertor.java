package Infix_to_Postfix;

import java.util.Stack;

public class InToPostConvertor {

   public String convert(char[] infix)
   {

       Stack<Character> operators = new Stack<Character>();
       char symbol;

       String postfix = "";

       for (int i = 0; i < infix.length; ++i)
       {
           symbol = infix[i];

           if (Character.isLetter(symbol) || Character.isDigit(symbol))

               postfix = postfix + symbol;

           else if (symbol == '(')

           {

               operators.push(symbol);

           } else if (symbol == ')')

           {
               while (operators.peek() != '(') {
                   postfix = postfix + operators.pop();
               }
               operators.pop();
           } else

           {
               while (!operators.isEmpty() && !(operators.peek() == '(')
                       && prec(symbol) <= prec(operators.peek()))
                   postfix = postfix + operators.pop();
               operators.push(symbol);
           }
       }

       while (!operators.isEmpty())
           postfix = postfix + operators.pop();
       return postfix;
   }

   public int prec(char x) {
       if (x == '+' || x == '-')
           return 1;
       if (x == '*' || x == '/' || x == '%')
           return 2;
       return 0;
   }
}