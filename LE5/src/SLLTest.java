/* last name, first name
 * 2csa-##
 * CS 203
 * Lab Exercise 5
 */

import java.util.Scanner;

public class SLLTest {
    public static void main(String[] args) {
	Scanner sc1 = new Scanner(System.in),
	    sc2 = new Scanner(System.in);
	
	System.out.print("Enter t: ");
	int t = sc1.nextInt();
	
	System.out.print("\nEnter s: ");
	String[] s = sc2.nextLine().split(" ");
	
	switch(t) {
	    case 1:
		System.out.println("Strings in the array: ");
		for (int i = 0; i < s.length; i++) System.out.println(s[i]);
		SLL listInteger = new SLL();
		System.out.println("Linked list contents: ");
		for (int i = 0; i < s.length; i++) {
		    String w = s[i];
		    Integer num = Integer.valueOf(w);
		    listInteger.insertAsc(num);
		    System.out.println(listInteger.toString());
		}
                System.out.println("Duplicates:");
                listInteger.printDups();
                System.out.println("Not Duplicates:");
                listInteger.printNotDups();
                System.out.println("Negatives");
                listInteger.printNegative();
		break;
	    case 2:
                System.out.println("Strings in the array: ");
		for (int i = 0; i < s.length; i++) System.out.println(s[i]);
		SLL listStrings = new SLL();
		System.out.println("Linked list contents: ");
		for (int i = 0; i < s.length; i++) {
		    listStrings.insertAsc(s[i]);
		    System.out.println(listStrings.toString());
		}
		break;
	    case 3:
                System.out.println("Strings in the array: ");
		for (int i = 0; i < s.length; i++) System.out.println(s[i]);
		SLL listStringsS = new SLL();
		System.out.println("Linked list contents: ");
		for (int i = 0; i < s.length; i++) {
		    listStringsS.insertDesc(s[i]);
		    System.out.println(listStringsS.toString());
		}
		break;
	    case 4:
                SLL listElements = new SLL();
                for (int i=0; i<s.length; i++) listElements.insertAsc(s[i]);
                System.out.println("Number of Nodes: " + listElements.numElements());
                listElements.printDups();
		break;
	    default:
		break;
	}
    }
}
