
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class AlphaSortingBubble
{
     public static void main(String[ ] args)
     {
            String order = JOptionPane.showInputDialog("(A) ascending \n(D) descending");
             String[ ] names = {"hello","world"};
             String[] name1 = new String[5];
             try{fileRead("ioc.txt",names);}
             catch(Exception e){}
             for(int i=0; i<5; i++)
             {
                // name1[i] = names[i];
             }
             
             sortStringBubble (names);
             
             for ( int k = 0;  k < 4;  k++ )
                System.out.println( names [ k ] );
             
      }
     
     public static void fileRead(String fileName, String []output) throws IOException
    {
        File iocFile = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(iocFile));
        String str;
        int count=1;
        while((str = br.readLine()) != null && count < output.length)
        {
            output[count]=str;
            count++;
        }
        br.close();
    }

      public static void sortStringBubble( String  x [ ] )
      {
            int j;
            boolean flag = true;  // will determine when the sort is finished
            String temp;

            while ( flag )
            {
                  flag = false;
                  for ( j = 0;  j < x.length - 1;  j++ )
                  {
                          if ( x [ j ].compareToIgnoreCase( x [ j+1 ] ) > 0 )
                          {                                             // ascending sort
                                      temp = x [ j ];
                                      x [ j ] = x [ j+1];     // swapping
                                      x [ j+1] = temp; 
                                      flag = true;
                           } 
                   } 
            } 
      } 
}