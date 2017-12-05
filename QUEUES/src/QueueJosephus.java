// Reyes, Christian Joseph A.
// 2csa-25
// Lab Exercise 8
// Queues
//
/**
 *
 * @author Christian Reyes
 */

import javax.swing.JOptionPane;
public class QueueJosephus {
    
    public static String process (String input, int limit, int t, int s)
    {
        String inputSplit[] = input.split(" ");
        String output = "";
        Queue uQueue = new Queue();
        
        if(t==3)
        {
            for(int i=0; i<inputSplit.length; i++)
            {
                uQueue.enqueue(inputSplit[i]);
            }
            int tempCount = 0;
            String tempString = "";
            while(tempCount != limit)
            {
                tempCount++;
                tempString = uQueue.dequeue().toString();
                if(tempCount != limit)
                {
                    uQueue.enqueue(tempString);
                }
            }
            output += " "+tempString;
        }
        if(t==2)
        {
            for(int i=0; i<inputSplit.length; i++)
            {
                uQueue.enqueue(inputSplit[i]);
            }
            int tempCount = 0;
            String tempString = "";
            while(tempCount != limit)
            {
                tempCount++;
                tempString = uQueue.dequeue().toString();
                if(tempCount != limit)
                {
                    uQueue.enqueue(tempString);
                }
            }
            output = uQueue.toString();
        }
        if(t==1)
        {
            for(int i=0; i<s; i++)
            {
                uQueue.enqueue(inputSplit[i]);
            }
            while(!uQueue.isEmpty())
            {
                int tempCount = 0;
                String tempString = "";
                while(tempCount != limit)
                {
                    tempCount++;
                    tempString = uQueue.dequeue().toString();
                    if(tempCount != limit)
                    {
                        uQueue.enqueue(tempString);
                    }
                }
                output += " "+tempString;
            }
        }
        
        
        return output;
    }

    public static void main(String[] args) {
        String input = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";//JOptionPane.showInputDialog("INPUT");
        String splitInput[] = input.split(" ");
        int t = Integer.parseInt(JOptionPane.showInputDialog("T")); //mode
        int s = Integer.parseInt(JOptionPane.showInputDialog("S")); //number of children
        int n = Integer.parseInt(JOptionPane.showInputDialog("N")); //syllables
        String tempSplitInput="";
        int counter=1;
        String tempInput="";
        switch (t)
        {
            case 1: System.out.print("Children: "); for(int i=0; i<n; i++){System.out.print(" "+splitInput[i]);}
                    System.out.println("\nElimination Order: "+process(input, s, t, n));
                    break;
            case 2: System.out.print("Children: "); for(int i=0; i<n; i++){System.out.print(" "+splitInput[i]);}
                    System.out.println("");
                    for(int i=0; i<n; i++)
                    {
                        tempSplitInput+= splitInput[i]+" ";
                    }
                    tempInput = process(tempSplitInput,s,t,n);
                    while (true)
                    {   
                        if(tempInput.compareTo("")==0)tempInput="Empty";
                        System.out.println("after round "+counter+": "+tempInput);
                        if(tempInput.compareTo("Empty")==0)break;
                        counter++;
                        tempInput = process(tempInput,s,t,n);
                    }
                    System.out.println("Elimination Order: "+process(input, s, 1, n));
                    break;
            case 3: System.out.print("Children: "); for(int i=0; i<n; i++){System.out.print(" "+splitInput[i]);}
                    System.out.println("");
                    for(int i=0; i<n; i++)
                    {
                        tempSplitInput+= splitInput[i]+" ";
                    }
                    String tempInput1="";
                    tempInput = process(tempSplitInput,s,t,n);
                    tempInput1 = process(tempSplitInput,s,2,n);
                    tempInput=""+tempInput.charAt(1);
                    //System.out.println(tempInput.charAt(1));
                    while (true)
                    {   
                        try
                        {
                            if(tempInput=="")tempInput="Empty";
                            System.out.println("after round "+counter+": "+tempInput);
                            if(tempInput.compareTo("Empty")==0)break;
                            counter++;
                            tempInput = ""+process(tempInput1,s,3,n).charAt(1);
                            tempInput1 = process(tempInput1,s,2,n);
                        }
                        catch(StringIndexOutOfBoundsException e)
                        {break;}
                        
                        
                    }
                    System.out.println("Elimination Order: "+process(input, s, 1, n));
                    break;
            case 4: 
                    break;
            default:throw new RuntimeException("Enter a valid T for mode (1-4)");
        }
             
    }
    
}

/*
STEPS:
1·) INPUT T (MODE) MODE DEFAULT THEN RUNTIME EXCEPTION OCCOURS
2·) INPUT S (NUMBER OF SYLLABLES)
3·) INPUT N (NUMBER OF CHILDREN)
*/