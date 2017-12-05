// Reyes, Christian Joseph A.
// user2csd-25
// Lab Exercise 6
// Stacks
//
//import java.util.*;
import javax.swing.JOptionPane;
public class StackExpr 
{
    public static String postfixToInfix(String input)
    {
        Stack<String> uStack = new Stack<>();
        String[] inputSplit = input.split(" ");
        for (String c : inputSplit) {
            if(c.compareTo("+")==0 || c.compareTo("-")==0 || c.compareTo("*")==0 || c.compareTo("/")==0 || c.compareTo("^")==0)
            {
                String b = uStack.pop();
                String a = uStack.pop();
                uStack.push("(" + a + c + b + ")");
            }
            else uStack.push(c);
        }
        return uStack.pop();
    }
    
    public static String postfixToPrefix(String input)
    {
        Stack<String> uStack = new Stack<>();
        String[] inputSplit = input.split(" ");
        for (String c : inputSplit) {
            if(c.compareTo("+")==0 || c.compareTo("-")==0 || c.compareTo("*")==0 || c.compareTo("/")==0 || c.compareTo("^")==0)
            {
                String b = uStack.pop();
                String a = uStack.pop();
                uStack.push(c + " " + a + " " + b);
            }
            else uStack.push(c);
        }
        return uStack.pop();
    }
    
    public static String postfixEvaluate(String input)
    {
        Stack<String> uStack = new Stack<>();
        String[] inputSplit = input.split(" ");
        for (String c : inputSplit) {
            if(c.compareTo("+")==0 || c.compareTo("-")==0 || c.compareTo("*")==0 || c.compareTo("/")==0 || c.compareTo("^")==0 || c.compareTo("%")==0)
            {
                String b = uStack.pop();
                String a = uStack.pop();
                String temp= String.valueOf(calculate(Double.parseDouble(a), c,Double.parseDouble(b)));
                uStack.push(temp);
            }
            else uStack.push(c);
        }
        return uStack.pop();
    }
    
    public static String infixToPostfix(String input) 
    {
        Stack<String> uStack = new Stack<>();
        String[] inputSplit = input.split(" ");
        String output="";
        uStack.push("!");
        for (String i : inputSplit) 
        {
            String inputSymbol = i;
            if (isOperator(inputSymbol)) 
            {
                while (checkPrecedence(inputSymbol, uStack.peek())) 
                {
                    output += " "+ uStack.pop();
                }
                uStack.push(inputSymbol);
            } 
            
            else if (inputSymbol.compareTo("(")==0) 
            {
                uStack.push(inputSymbol);  //push if left parenthesis
            } 
            
            else if (inputSymbol.compareTo(")")==0) 
            {
                while (uStack.peek().compareTo("(")!=0) 
                {
                    output += " "+ uStack.pop();
                }
                uStack.pop();
            } 
            
            else 
            {
                output += " "+ inputSymbol;
            }
        }

        //pops all elements of stack left
        while ((uStack.peek()).compareTo("!")!=0) {
            output += " "+ uStack.pop();
            

        }

        return output;
    }
    
    private static boolean isOperator(String c) {
        if (c.compareTo("+")==0 || c.compareTo("-")==0 || c.compareTo("*")==0 || c.compareTo("/")==0 || c.compareTo("^")==0 || c.compareTo("%")==0) {
            return true;
        }
        return false;
    }

    private static boolean checkPrecedence(String c1, String c2) {
        if ((c2.compareTo("+")==0 || c2.compareTo("-")==0) && (c1.compareTo("+")==0 || c1.compareTo("-")==0)) {
            return true;
        } else if ((c2.compareTo("*")==0 || c2.compareTo("/")==0) && (c1.compareTo("+")==0 || c1.compareTo("-")==0 || c1.compareTo("*")==0 || c1.compareTo("/")==0 || c1.compareTo("%")==0)) {
            return true;
        } else if ((c2.compareTo("^")==0) && (c1.compareTo("+")==0 || c1.compareTo("-")==0 || c1.compareTo("*")==0 || c1.compareTo("/")==0 || c1.compareTo("%")==0)) {
            return true;
        } else if ((c2.compareTo("%")==0) && (c1.compareTo("+")==0 || c1.compareTo("-")==0 || c1.compareTo("%")==0)) {
            return true;}
        else {
            return false;
        }
    }
        
    
    public static String infixToPrefix(String input) // DI PA TAPOS, MAY BUG PA.
    {
        int priority = 0;
        String output = "";
        Stack<String> uStack = new Stack();
        String[] inputSplit = input.split(" ");

        for (int i = 0; i < inputSplit.length; i++) 
        {
            String c = inputSplit[i];
            if (c.compareTo("+")==0 || c.compareTo("-")==0 || c.compareTo("*")==0 || c.compareTo("/")==0 || c.compareTo("^")==0)
            {
                if (uStack.size() <= 0) 
                {
                    uStack.push(c);
                } 
                
                else 
                {
                    String cTop = (String) uStack.peek();
                    if (cTop.compareTo("*")==0 || cTop.compareTo("/")==0 || cTop.compareTo("^")==0) 
                    {
                        priority = 1;
                    } 
                    
                    else 
                    {
                        priority = 0;
                    }
                    
                    //---------------------------------------------------------------------------------------------------------------------------------
                    
                    if (priority == 1) 
                    {
                        output = uStack.pop()+output;
                        i--;
                    } 
                    
                    else 
                    {
                        if (c.compareTo("+")==0 || c.compareTo("-")==0) 
                        {
                            output = uStack.pop()+output;
                        }
                        uStack.push(c);
                    }
                }
            } 
            
            else 
            {
                output += c;
            }
            
            if(output.compareTo("") !=0)
            {
                output += " ";
            }
        }
        for (int i = 0; i < uStack.size(); i++) {
            output = uStack.pop() +" "+output;
        }
        output = output.replace("(","");
        output = output.replace(")","");
        output = output.replace("  "," ");
        return output;
    }
    
    public static String prefixToInfix(String input)
    {
        Stack<String> uStack = new Stack<>();
        String[] inputSplit = input.split(" ");
        for (String c : inputSplit) {
            if (c.compareTo("+")==0 || c.compareTo("-")==0 || c.compareTo("*")==0 || c.compareTo("/")==0 || c.compareTo("^")==0)
                uStack.push(c);
            else 
            {
                if(((uStack.peek()).compareTo("+")==0 || (uStack.peek()).compareTo("-")==0 || (uStack.peek()).compareTo("*")==0 || (uStack.peek()).compareTo("/")==0 || (uStack.peek()).compareTo("^")==0) == false)
                {
                    String b = uStack.pop();
                    String a = uStack.pop();
                    c = "(" + b + " " + a + " " + c + ")";
                }
                uStack.push(c);
            }
        }
        return uStack.pop();
    }
    
    public static String prefixToPostfix(String input)
    {
        Stack<String> uStack = new Stack<>();
        String[] inputSplit = input.split(" ");
        for (String c : inputSplit) {
            if (c.compareTo("+")==0 || c.compareTo("-")==0 || c.compareTo("*")==0 || c.compareTo("/")==0 || c.compareTo("^")==0)
                uStack.push(c);
            else 
            {
                if(((uStack.peek()).compareTo("+")==0 || (uStack.peek()).compareTo("-")==0 || (uStack.peek()).compareTo("*")==0 || (uStack.peek()).compareTo("/")==0 || (uStack.peek()).compareTo("^")==0) == false)
                {
                    String b = uStack.pop();
                    String a = uStack.pop();
                    c = b + " " + c + " " + a;
                }
                uStack.push(c);
            }
        }
        return uStack.pop();
    }
    
    public static String prefixEvaluate(String input)
    {
        Stack<String> uStack = new Stack<>();
        String[] inputSplit = input.split(" ");
        for (String c : inputSplit) {
            if (c.compareTo("+")==0 || c.compareTo("-")==0 || c.compareTo("*")==0 || c.compareTo("/")==0 || c.compareTo("^")==0)
                uStack.push(c);
            else 
            {
                if(((uStack.peek()).compareTo("+")==0 || (uStack.peek()).compareTo("-")==0 || (uStack.peek()).compareTo("*")==0 || (uStack.peek()).compareTo("/")==0 || (uStack.peek()).compareTo("^")==0) == false)
                {
                    String b = uStack.pop();
                    String a = uStack.pop();
                    String temp = String.valueOf(calculate(Double.parseDouble(b), a,Double.parseDouble(c)));
                    c = temp;
                }
                uStack.push(c);
            }
        }
        return uStack.pop();
    }
    
    public static double calculate(double a, String b, double c)
    {
        double result;
        if (b.compareTo("+")==0) result = a+c;
        else if (b.compareTo("-")==0) result = a-c;
        else if (b.compareTo("*")==0) result = a*c;
        else if (b.compareTo("/")==0) result = a/c;
        else if (b.compareTo("%")==0) result = a%c;
        else if (b.compareTo("^")==0) result = Math.pow(a,c);
        else result = 0;
        return result;
    }
    
    public static void chooseInput()
    {
        String t = JOptionPane.showInputDialog("T");
        String input = JOptionPane.showInputDialog("Input");
        processInput(t,input);
    }
    
    public static void processInput(String t, String input)
    {
        switch (t)
            {
                case "1":  System.out.println("Postfix: "+input+"\n"+"Infix: "+postfixToInfix(input)); 
                           break;
                case "2":  System.out.println("Infix: "+input+"\n"+"Postfix: "+infixToPostfix(input)); 
                           break;
                case "3":  System.out.println("Postfix: "+input+"\n"+"Value: "+postfixEvaluate(infixToPostfix(input)));
                           break;
                case "4":  System.out.println("Infix: "+input+"\n"+"Postfix: "+infixToPostfix(input)); 
                           System.out.println("Value: "+postfixEvaluate(infixToPostfix(input)));
                           break;
                case "5":  System.out.println("Prefix: "+input+"\n"+"PostFix: "+prefixToPostfix(input));
                           break;
                case "6":  System.out.println("Prefix: "+input+"\n"+"Infix: "+prefixToInfix(input)); 
                           break;
                case "7":  System.out.println("Prefix: "+input+"\n"+"Value: "+prefixEvaluate(input)); 
                           break;
                case "8":  System.out.println("Infix: "+input+"\n"+"Prefix: "+infixToPrefix(input)); 
                           break;
                default: break;
            }
    }
    
    public static void main (String[] Args)
    {
        chooseInput();
    }
}


