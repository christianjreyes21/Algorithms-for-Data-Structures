import java.util.Scanner;
import java.util.Stack;

public class InToPost {

 private boolean isOperator(String c)
 {
    if(c == "+" || c == "-" || c == "*" || c =="/" || c == "^")
        return true;
        return false;
 }
 private boolean checkPrecedence(String c1, String c2)
 {
  if((c2 == "+" || c2 == "-") && (c1 == "+" || c1 == "-"))
   return true;
  else if((c2 == "*" || c2 == "/") && (c1 == "+" || c1 == "-" || c1 == "*" || c1 == "/"))
   return true;
  else if((c2 == "^") && (c1 == "+" || c1 == "-" || c1 == "*" || c1 == "/"))
   return true;
  else
   return false;
 }
 

    public String convert(String infix) 
    {
        String output = "";
        Stack<String> uStack = new Stack<>();
        uStack.push("#");

        for (int i = 0; i < infix.length(); i++) 
        {
            String inputSymbol = infix.charAt(i);
            if (isOperator(inputSymbol)) 
            {
                while (checkPrecedence(inputSymbol, uStack.peek())) 
                {
                    output += uStack.pop();
                }
                uStack.push(inputSymbol);
            } 
            
            else if (inputSymbol == "(") 
            {
                uStack.push(inputSymbol);  //push if left parenthesis
            } 
            
            else if (inputSymbol == ")") 
            {
                while (uStack.peek() != "(") 
                {
                    output += uStack.pop();
                }
                uStack.pop();
            } 
            
            else 
            {
                output += inputSymbol;
            }
        }

        //pops all elements of stack left
        while (uStack.peek() != "#") {
            output += uStack.pop();
            //System.out.printf("%-8s%-10s%-15s\n", "",format(s.toString()),output);  

        }

        return output;
    }
 
 /**
  * Formats the input  stack string
  * @param s It is a stack converted to string
  * @return formatted input
  */
 private String format(String s){
  s = s.replaceAll(",","");  //removes all , in stack string
  s = s.replaceAll(" ","");  //removes all spaces in stack string
  s = s.substring(1, s.length()-1);  //removes [] from stack string
  
  return s;
 }
 
 public static void main(String[] args) {
  InToPost obj = new InToPost();
  Scanner sc = new Scanner(System.in);
  System.out.print("Infix : \t");
  String infix = sc.next();
  System.out.print("Postfix : \t"+obj.convert(infix));
 }
}