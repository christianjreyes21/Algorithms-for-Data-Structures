
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Christian Reyes
 */
public class FileSort 
{
    public static int max;
    public static String []data;
    public static int count=1;
    
    public static void fileRead(String fileName, String []output) throws IOException
    {
        File iocFile = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(iocFile));
        String str;
        while((str = br.readLine()) != null && count < output.length)
        {
            output[count]=str;
            count++;
        }
        br.close();
    }
    
    public static void printData(String[] data)
    {
        for(int i=1; i<data.length && data[i]!=null; i++)
        {
            System.out.println(i + " " + data[i]);
        }
    }
    public static void chooseInput()
    {
        String order = JOptionPane.showInputDialog("(A) ascending \n(D) descending");
        int sortingAlgorithm = Integer.parseInt(JOptionPane.showInputDialog("(1) bubble sort \n(2) merge sort"));
        
        switch (sortingAlgorithm)
            {
                case 1:   if (order.equals("A"))
                            {
                                bubbleSort(data,1,count-1);
                            }
                           else if (order.equals("D")) 
                           {
                               bubbleSort(data,count-1,1);
                           }
                           break;
                case 2:   if (order.equals("A"))
                            {
                                mergeSort(data,1,count-1,1);
                            }
                           else if (order.equals("D")) 
                           {
                               mergeSort(data,1,count-1,0);
                           }
                           break;
                case 3:   if (order.equals("A"))
                            {
                                exchangeSort(data,1,count-1);
                            }
                           else if (order.equals("D")) 
                           {
                               exchangeSort(data,count-1,1);
                           }
                           break;
            }
    }
    
    public static void bubbleSort(String[] data, int start, int end)
    {
        boolean flag=true;
        String temp;
        
        while(flag)
        {
            flag = false;
            if (start<end)
            for(int j=start; j<end; j++)
            {
                
                if (data[j].compareToIgnoreCase(data[j+1])>0)
                {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1]=temp;
                    flag = true;
                }
            }
            else
            for(int j=end; j<start; j++)
            {
                
                if (data[j].compareToIgnoreCase(data[j+1])<0)
                {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1]=temp;
                    flag = true;
                }
            }
        }
    }
    
    public static void exchangeSort(String[] data, int start, int end)
    {
        String temp;
        if(start<end)
        for (int i=start; i< end; i++)
        {
            for (int j=i+1; j<end+1; j++)
            {
                if (data[i].compareToIgnoreCase(data[j]) > 0)
                {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        else
        for (int i=end; i< start; i++)
        {
            for (int j=i+1; j<start+1; j++)
            {
                if (data[i].compareToIgnoreCase(data[j]) < 0)
                {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    } 
    
    public static void mergeSort(String[] array, int start, int end, int state) 
    {
	if (start < end) 
        {
	    int center = (start + end) / 2;
	    mergeSort(array,start,center, state);
	    mergeSort(array,center+1,end, state);
	    merge(array,start,center+1,end, state);
	}
    }


	public static void merge(String[] array, int start, int rightStart, int rightEnd,int state) {
        int leftEnd = rightStart - 1;
        int k = start;
        int num = rightEnd - start + 1;
	String tmp[] = new String[array.length];

        while(start <= leftEnd && rightStart <= rightEnd)
            if(state==1)
                if(array[start].compareTo(array[rightStart]) <= 0)
                    tmp[k++] = array[start++];
                else
                    tmp[k++] = array[rightStart++];
            else
                if(array[start].compareTo(array[rightStart]) >= 0)
                    tmp[k++] = array[start++];
                else
                    tmp[k++] = array[rightStart++];

        while(start <= leftEnd)
            tmp[k++] = array[start++];

        while(rightStart <= rightEnd)
            tmp[k++] = array[rightStart++];

        for(int i = 0; i < num; i++, rightEnd--)
            array[rightEnd] = tmp[rightEnd];
    }
    
    public static void main(String[] args) 
    {
        max = Integer.parseInt(JOptionPane.showInputDialog("Max number of items: "));
        data = new String[max+1];
        
        try 
        {
            fileRead("C:\\Users\\Christian Reyes\\Documents\\NetBeansProjects\\FileSort\\src\\ioc.txt",data);
            printData(data);
            chooseInput();
            printData(data);
        }
        catch(Exception e){e.printStackTrace();}
        
    }
    
}
