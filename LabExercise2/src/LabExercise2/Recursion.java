// Reyes, Christian Joseph A.
// user2csd-25
// Lab Exercise 1
//
//
package LabExercise2;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Christian Reyes
 */
public class Recursion {
    public static String input="";
    public static String[] inputSplit;
    public static String[] outputSplit;
    public static String[] outputFinal;
    public static int t;
    public static int superTo;
    public static int from;
    public static int to;
    public static boolean palindrome = true;
    
    public static Scanner scan = new Scanner(System.in);
    
    
    
    public static void getOption()
    {
        t = Integer.parseInt(JOptionPane.showInputDialog("Enter an option (range 0 - 4):"));
    }
    
    public static void processOption()
    {
        while(true)
        {
            palindrome = true;
            getOption();
            switch (t)
            {
                case 0: System.exit(0);
                        break;
                case 1: getInput();
                        firstProcess();
                        break;
                case 2: getInput();
                        secondProcess();
                        break;
                case 3: getInput();
                        thirdProcess();
                        break;
                case 4: getInput();
                        fourthProcess();
                        break;
            }
        }
    }
    
    public static void getInput()
    { 
        input= JOptionPane.showInputDialog("Enter the text");
    }
    
    public static void processText(int from, int to, String[] source, String[] output)
    {
       
        copyRecursion(source.length-1, source, output);
        
        superTo=to;
        reverseRecursion(from, to, source, output);
    }
    
    public static void copyRecursion(int a, String[] source, String[] output)
    {
        if(a==0)
        {
            output[a] = (source[a]);
        }
        else
        {
            copyRecursion(a-1, source, output);
            output[a]=source[a];
        }
    }
    
    
    public static void reverseRecursion(int from, int to, String[] source, String[] output)
    {
        if(from==superTo)
        {
            output[to] = (source[from]);
        }
        else
        {
            reverseRecursion(from+1, to-1, source, output);
            output[to]=source[from];
        }
    }
    
    public static void printText (String[] output)
    {
        for (int i = 0; i<output.length; i++)
        {
            System.out.println(output[i]);
        }
    }
    
    public static void inputRange ()
    {
        from= Integer.parseInt(JOptionPane.showInputDialog("From:"));
        to= Integer.parseInt(JOptionPane.showInputDialog("To:"));
    }
    
    public static void checkPalindrome(String[] source, String[] source1)
    {
       /* for (int i = 0; i<source.length; i++)
        {
            if (source[i].equals(source1[i]))
            {
                
            }
            else
            {
                palindrome = false;
            }
        }*/
        palindromeEqualsRecursion(source.length-1, source, source1);
        
        if (palindrome == true)
        {
            System.out.println("is a Palindrome");
        }
        else
        {
            System.out.println("is NOT a Palindrome");
        }
    }
    
    public static void palindromeEqualsRecursion (int i, String[] source, String[] source1)
    {
        if (i == 0)
        {
            if (source[i].equals(source1[i]))   {}
            else
            {
                palindrome = false;
            }
        }
        
        else
        {
            palindromeEqualsRecursion (i-1, source, source1);
            if (source[i].equals(source1[i]))   {}
            else
            {
                palindrome = false;
            }
        }
    }
    
    
    
    
    public static void firstProcess()
    {
        String[] inputSplit =  input.split(" ");
        String[] outputSplit = new String[inputSplit.length];
        
        processText(0,inputSplit.length-1,inputSplit,outputSplit);
        
        printText(inputSplit);
        System.out.println("The reverse is:");
        printText(outputSplit);
    }
    
    public static void secondProcess()
    {
        String[] inputSplit =  input.split(" ");
        String[] outputSplit = new String[inputSplit.length];
        
        inputRange();
        processText(from,to,inputSplit,outputSplit);
        
        printText(inputSplit);
        System.out.println("The reverse is:");
        printText(outputSplit);
    }
    
    public static void thirdProcess()
    {
        String[] inputSplit =  input.split(" ");
        String[] outputSplit = new String[inputSplit.length];
        
        processText(0,inputSplit.length-1,inputSplit,outputSplit);
        
        printText(inputSplit);
        System.out.println("The reverse is:");
        printText(outputSplit);
        checkPalindrome(inputSplit, outputSplit);
    }
    
    public static void fourthProcess()
    {
        String[] inputSplit =  input.split(" ");
        String[] outputSplit = new String[inputSplit.length];
        String[] outputSplitCompared = new String[inputSplit.length];
        inputRange();
        processText(from ,to ,inputSplit, outputSplit);
        
        printText(inputSplit);
        System.out.println("The reverse is:");
        printText(outputSplit);
        processText(0 ,outputSplit.length-1 ,outputSplit, outputSplitCompared);
        checkPalindrome(outputSplit, outputSplitCompared);
    }
    
    
    public static void main(String[] args) 
    {
        processOption();
        
    }
    
}
