/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigo;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Reyes
 */
public class BigO 
{
    static int maxTime;
    static long startTime;
    static long endTime;
    static int count=0;
    static int n=0;
    
    static String method1(int n, int m) 
    {	   
	if (m == 0) 
            return "";
	else 
        {
	    String s = "";
	    for (int i = 1; i <= n; i++) 
            {
		s += "(" + m + "," + i + ") ";
                if (i == n && !(m == n)) s += "\n";
	    }	
	    return method1(n,--m) + s;  
	}
    }
    
    static double method2(int n) 
    {
	if (n == 0) 
        {
            return 1;
        }
	else if (n % 2 == 1) 
        {
	    return 1.001 * method2((n-1)/2) * method2((n-1)/2);
	} 
        else 
        {
	    return method2(n/2) * method2(n/2);
	}
    }
    
    
    
    public static void main(String[] args) 
    {
         maxTime = Integer.parseInt(JOptionPane.showInputDialog("maxTime: "));
         n = 1;
         startTime = System.nanoTime();
         
         do
         {
            method1(n,n);
            count++; n++;
         }
         while(System.nanoTime()- startTime <= ((double)maxTime));
         System.out.println(method1(n,n));
         System.out.println("The largest value of n for method1 in "+(double)maxTime/1000000000+" seconds is "+count);
         
         
         startTime = System.nanoTime();
         count=0; n=1;
         do
         {
            method2(n);
            count++; n++;
         }
         while(System.nanoTime()- startTime <= ((double)maxTime));
         System.out.println(method2(n));
         System.out.println("The largest value of n for method2 in "+(double)maxTime/1000000000+" seconds is "+count);
    }
    
}
