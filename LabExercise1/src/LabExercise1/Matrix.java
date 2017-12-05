// Reyes, Christian Joseph A.
// user2csd-25
// Lab Exercise 1
//
//
package LabExercise1;
import java.util.Scanner;
/**
 *
 * @author Christian Reyes
 */
public class Matrix {

    public static int[][] A= new int[][]
    {
        {1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,1},
        {1,0,-1,-1,-1,-1,-1,-1,0,1},
        {1,0,2,2,0,0,1,1,0,1},
        {1,0,2,2,0,0,1,1,0,1},
        {1,0,3,3,4,5,-2,-2,0,1},
        {1,0,3,3,6,7,-2,-2,0,1},
        {1,0,-1,-1,-1,-1,-1,-1,0,1},
        {1,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1}
    };
    public static int[][] temp;
    public static int[][] a;
    public static int[][] b;
    public static int[][] transposedB;
    public static int[][] P;
    
    public static int t;
    
    public static int m;
    public static int n;
    public static int p;
    public static int r;
    public static int s;
    public static int u;
    public static int v;
    
    public static int savedArrayCount=0;
    
    public static Scanner scan = new Scanner(System.in);
    
    public static void printValues(int firstRow, int lastRow, int firstCol, int lastCol, int[][]givenArray, int[][]saveTo)
    {
        for( int i=firstRow; i<=lastRow; i++)
        {
            for(int j=firstCol; j<=lastCol; j++)
            {
                System.out.printf("%5d" , givenArray[i][j]);
                saveTo[i-firstRow][j-firstCol]=givenArray[i][j];
            }
            System.out.println("");
        }
    }
    
    
    
    public static void getOption()
    {
        System.out.print("Enter an option (range 0 - 3): ");
        t = scan.nextInt();
    }
    
    public static void processOption()
    {
        while(true)
        {
            getOption();
            switch (t)
            {
                case 0: System.exit(0);
                        break;
                case 1: getValues();
                        firstProcess();
                        break;
                case 2: getValues();
                        secondProcess();
                        break;
                case 3: thirdProcess();
                        break;
            }
        }
    }
    
    public static void getValues()
    {
        System.out.println("Enter the values for each variable:");
        System.out.print("m, n, p, r, s, u, v, where 1≤m,n,p≤10 and 0≤r,s,u,v≤9");
        System.out.print("\n m: "); m =scan.nextInt();
        System.out.print("\n n: "); n =scan.nextInt();
        System.out.print("\n p: "); p =scan.nextInt();
        System.out.print("\n r: "); r =scan.nextInt();
        System.out.print("\n s: "); s =scan.nextInt();
        System.out.print("\n u: "); u =scan.nextInt();
        System.out.print("\n v: "); v =scan.nextInt();
        checkValues();
    }
    
    
    public static void checkValues()
    {
        if( !(m>=1 && m<=10) || !(n>=1 && n<=10) || !(p>=1 && p<=10) || !(r>=0 && r<=9) || !(s>=0 && s<=9) || !(u>=0 && u<=9) || !(v>=0 && v<=9) )
        {
            System.out.println("Error! Please double check your range.");
            getValues();
        }
    }
    
    public static void outputMultiply(int[][]x, int[][]y, int[][]z)
    {
        for (int i=0; i<x.length; ++i)
        {
            for (int j=0; j<y[0].length; ++j)
            {
                for (int k=0; k<x[0].length; ++k)
                {
                    z[i][j] += x[i][k] * y[k][j];
                }
            }
        }
    }
    
    public static void outputMultiplyConstant(int[][]x, int wholeNumber, int[][]z)
    {
        for( int i=0; i<=x.length-1; i++)
        {
            for(int j=0; j<=x[0].length-1; j++)
            {
                z[i][j] *= wholeNumber;
            }
        }
    }
    
    public static void outputAdd(int[][]x, int[][]y, int[][]z)
    {
        for( int i=0; i<x.length; i++)
        {
            for(int j=0; j<x[0].length; j++)
            {
                z[i][j] = x[i][j] + y[i][j];
            }
        }
    }
    
    public static void outputTranspose(int[][]x, int[][]z)
    {
        for( int i=0; i<x.length; i++)
        {
            for(int j=0; j<x[0].length; j++)
            {
                z[j][i] = x[i][j];
            }
        }
    }
    
    
    public static void firstProcess()
    {
        System.out.println("A");
        a= new int[m][n];
        printValues(r, r+m-1, s, s+n-1,A,a);
        
        System.out.println("\n B");
        b= new int[n][p];
        printValues(u, u+n-1, v, v+p-1,A,b);
        
        System.out.println("\n P");
        P= new int [a.length][b.length];
        outputMultiply(a, b, P);
        printValues(0, m-1, 0, p-1, P, temp);
        
    }
    
    public static void secondProcess()
    {
        System.out.println("A");
        a= new int[m][n];
        printValues(r, r+m-1, s, s+n-1,A,a);
        
        System.out.println("\n B");
        b= new int[n][p];
        printValues(u, u+n-1, v, v+p-1,A,b);
        
        System.out.println("\n P");
        transposedB = new int [b[0].length][b.length];
        P= new int [a.length][a[0].length];
        outputTranspose(b,transposedB);
        outputAdd(a, b, P);
        printValues(0, P.length-1, 0, P[0].length-1, P, temp);
    }
    
    public static void thirdProcess()
    {
        
    }
    
    
    public static void main(String[] args) 
    {
        temp= new int[A.length][A.length];
        printValues(0, A.length-1, 0, A.length-1,A,temp);
        processOption();
        
    }
    
}
