import java.awt.*;
import java.awt.event.*;
import static java.util.Objects.deepEquals;
import javax.swing.*;
import javax.swing.border.TitledBorder;

// form0 (operationChoices)
//form1 (enterNumberMatrices)
//form2_1 (enterSquareDimension)
//form2_2 (enterCustomizedDimensionForProduct)
//form2_3 (enterPowerDimension)
//form3 (enterValues)
//form4 (result)

public class noname implements ActionListener 
{
	private JFrame form0, form1, form2_1, form2_2, form2_3, form3, frontResultLiner;
	private JPanel parentControl, parent0, parent1, parent2_1, parent2_2, parent2_3, parent3, parent4, p0, p1, p2, p3, p4, p5, p6, p7, p8, groupForm2_1_1;
	private TitledBorder selectOption, enterPower, enterMatrices, enterDimensions, enterValues, results;
	private JComboBox selection;
	private String[] options;
	private TitledBorder[] enterDimension;
	private TitledBorder[] enterValueEach;
	private JButton bNext, bCancel;
	private int buttonPressCount = 0;
	private String formCheck;
	private JLabel by;
	private JTextField qtyMatrix, power;
	private JTextField[] xDimension, yDimension;
	private JPanel[] groupForm2_1;
	private JPanel[] groupForm2;
        private JPanel[] groupForm3;
	public int m,x,y, dimensionPassed, checkPassed=1;
        public int alert = 0;
	private JTextField[][][] arraySize;
	private JScrollPane scroller, scroller1, scroller2;
        public int [][][] matrixData, matrixResult;
        public int letItCustom = 0;

	public noname() 
	{
		form0 = new JFrame(" ");
		form1 = new JFrame(" ");
		form2_1 = new JFrame(" ");
		form2_2 = new JFrame(" ");
		form2_3 = new JFrame(" ");
		form3 = new JFrame ("Team BA Supernatural Calculator");
		frontResultLiner= new JFrame ("Results");

		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		parent0 = new JPanel();
		parent1 = new JPanel();
		parent2_1 = new JPanel();
		parent2_2 = new JPanel();
		parent2_3 = new JPanel();
		parent3 = new JPanel();
		parent4 = new JPanel();
		parentControl = new JPanel();

		

		bNext = new JButton("Next");
		bCancel = new JButton("Cancel");

		selectOption = new TitledBorder("Select an Option");
		options = new String[] {"Meet", "Join", "Product", "Power"};
		selection = new JComboBox(options);

		enterMatrices = new TitledBorder("Enter the number of Matrices");
		qtyMatrix = new JTextField(4);

		enterDimensions = new TitledBorder ("Enter the Dimensions");
		
		enterPower = new TitledBorder ("Power");
		power = new JTextField(4);
	}

	public void launchFrame0()
	{
		parentControl.add(bNext);
		parentControl.add(bCancel);

		p0.add(selection, BorderLayout.WEST);
		parent0.add(p0);
		parent0.add(parentControl);
		parent0.setBorder(selectOption);
		
		form0.add(parent0, BorderLayout.CENTER);
		form0.pack();
		form0.setVisible(true);

		bNext.addActionListener(this);
		bCancel.addActionListener(this);

		form0.addWindowListener(new MyCloseButtonHandler());
	}

	public void launchFrame1()
	{
		form0.setVisible(false);
		
		p1.add(qtyMatrix, BorderLayout.CENTER);
		parent1.add(p1);
		parent1.add(parentControl);
		parent1.setBorder(enterMatrices);

		form1.add(parent1, BorderLayout.CENTER);
		form1.pack();
		form1.setVisible(true);

		
		bCancel.addActionListener(this);

		form1.addWindowListener(new MyCloseButtonHandler());
	}

	public void launchFrame2_1() 
	{
		form1.setVisible(false);	

		//parent2_1.setLayout(new GridLayout(2,1));
		groupForm2_1 = new JPanel[m];
		xDimension = new JTextField[m];
		yDimension = new JTextField[m];
		enterDimension = new TitledBorder[m];
		
                if(formCheck.equals("Join") || formCheck.equals("Meet"))
                {   
                    groupForm2_1[0] = new JPanel();
                    xDimension[0] = new JTextField(4);
                    yDimension[0] = new JTextField(4);
                    enterDimension[0] = new TitledBorder("M" + (1) + " - M" + (m));
                    groupForm2_1[0].add(xDimension[0]);
                    groupForm2_1[0].add(new JLabel("by"));
                    groupForm2_1[0].add(yDimension[0]);
                    groupForm2_1[0].setBorder(enterDimension[0]);	
                    parent2_1.add(groupForm2_1[0]);
                }
                else
                {
                    for(int i = 0; i<m; i++)
                    {
                    	groupForm2_1[i] = new JPanel();
                    	xDimension[i] = new JTextField(4);
			yDimension[i] = new JTextField(4);
                        enterDimension[i] = new TitledBorder("M" + (i+1));
			groupForm2_1[i].add(xDimension[i]);
			if (formCheck.equals("Power"))
			{}
			else
			{
			groupForm2_1[i].add(new JLabel("by"));
			groupForm2_1[i].add(yDimension[i]);
			groupForm2_1[i].setBorder(enterDimension[i]);
			}
			
			parent2_1.add(groupForm2_1[i]);
                    }
                }

		if (formCheck.equals("Power"))
		{
			groupForm2_1_1 = new JPanel();
			groupForm2_1_1.add(power);
			groupForm2_1_1.setBorder(enterPower);
			parent2_1.add(groupForm2_1_1);
		}

		
		parent2_1.setLayout(new BoxLayout(parent2_1, BoxLayout.Y_AXIS));
		
		scroller = new JScrollPane(parent2_1);
		scroller.getVerticalScrollBar().setUnitIncrement(16);
		//parent2_1.add(parentControl, BorderLayout.SOUTH);
		//parent2_1.setBorder(enterDimension);
		parent2_1.setBorder(enterDimensions);
		form2_1.add(scroller);
		form2_1.add(parentControl, BorderLayout.SOUTH);
		
		form2_1.pack();
		//form2_1.setSize(185,400);
		form2_1.setResizable(true);
		form2_1.setVisible(true);
		
		bNext.addActionListener(this);
		bCancel.addActionListener(this);
	
		form2_1.addWindowListener(new MyCloseButtonHandler());
		
		
	}

	public void launchFrame3()
	{
		form2_1.setVisible(false);
		arraySize = new JTextField[m][100][100];
                groupForm2 = new JPanel[m];
                enterValueEach = new TitledBorder[m];
                
		if(formCheck.equals("Join") || formCheck.equals("Meet"))
                { 
                    for (int a = 0; a<m; a++)
                    {
                        enterValueEach[a] = new TitledBorder("M" + (a+1));
                        groupForm2[a] = new JPanel();
                        groupForm2[a].setLayout(new GridLayout(Integer.parseInt(xDimension[0].getText()),Integer.parseInt(yDimension[0].getText())));

			for (int i = 0; i<Integer.parseInt(xDimension[0].getText()); i++)
			{
                            for (int j = 0; j<Integer.parseInt(yDimension[0].getText()); j++)
                            {
                                arraySize[a][i][j] = new JTextField(1);
				groupForm2[a].add(arraySize[a][i][j]);
                            }
			}
			
                        groupForm2[a].setSize(groupForm2[a].getPreferredSize());
			groupForm2[a].setBorder(enterValueEach[a]);
			parent2_2.add(groupForm2[a]); 
                    }
                }
                else
                {
	if (formCheck.equals("Power")){
                    for (int a = 0; a<m; a++)
                    {
                        enterValueEach[a] = new TitledBorder("M" + (a+1));
                        groupForm2[a] = new JPanel();
                        groupForm2[a].setLayout(new GridLayout(Integer.parseInt(xDimension[a].getText()),Integer.parseInt(xDimension[a].getText())));

			for (int i = 0; i<Integer.parseInt(xDimension[a].getText()); i++)
			{
                            for (int j = 0; j<Integer.parseInt(xDimension[a].getText()); j++)
                            {
                                arraySize[a][i][j] = new JTextField(1);
				groupForm2[a].add(arraySize[a][i][j]);
                            }
			}
			
                        groupForm2[a].setSize(groupForm2[a].getPreferredSize());
			groupForm2[a].setBorder(enterValueEach[a]);
			parent2_2.add(groupForm2[a]); 
                    }}
	else
	{
	for (int a = 0; a<m; a++)
                    {
                        enterValueEach[a] = new TitledBorder("M" + (a+1));
                        groupForm2[a] = new JPanel();
                        groupForm2[a].setLayout(new GridLayout(Integer.parseInt(xDimension[a].getText()),Integer.parseInt(yDimension[a].getText())));

			for (int i = 0; i<Integer.parseInt(xDimension[a].getText()); i++)
			{
                            for (int j = 0; j<Integer.parseInt(yDimension[a].getText()); j++)
                            {
                                arraySize[a][i][j] = new JTextField(1);
				groupForm2[a].add(arraySize[a][i][j]);
                            }
			}
			
                        groupForm2[a].setSize(groupForm2[a].getPreferredSize());
			groupForm2[a].setBorder(enterValueEach[a]);
			parent2_2.add(groupForm2[a]); 
                    }}
	
                }
		scroller1 = new JScrollPane(parent2_2);
		scroller1.getVerticalScrollBar().setUnitIncrement(16);
                enterValues = new TitledBorder("EnterValues");
                scroller1.setBorder(enterValues);
		//parent2_2.add(parentControl, BorderLayout.SOUTH);
		//parent2_2.setBorder(enterDimension);
		//parent2_2.setBorder(enterDimensions);
		form2_2.add(scroller1);
		form2_2.add(parentControl, BorderLayout.SOUTH);
		
		form2_2.pack();
		//form2_2.setSize(185,400);
		form2_2.setResizable(true);
		form2_2.setVisible(true);
		
		bNext.addActionListener(this);
		bCancel.addActionListener(this);
	
		form2_2.addWindowListener(new MyCloseButtonHandler());
                JOptionPane.showMessageDialog(null, "Enter Values (0 or 1 ONLY)");
	}
        
        public void checkDimension()
        {
                dimensionPassed=1;
                for (int a = 0; a<m-1; a++)
                {
                    
                    if(Integer.parseInt(yDimension[a].getText()) != Integer.parseInt(xDimension[a+1].getText()))
                    {
                        dimensionPassed=0;
                    }
                }
                if(dimensionPassed==0)
                    JOptionPane.showMessageDialog(null, "Dimensions must be mxn or nxn");
        }
        
        public void gatherValues()
        {
            matrixData = new int [m][100][100];
            matrixResult = new int [m][100][100];
            alert =0;
            for (int a = 0; a<m; a++)
		{
                    if(formCheck.equals("Join") || formCheck.equals("Meet"))
                    {
			for (int i = 0; i<Integer.parseInt(xDimension[0].getText()); i++)
			{
				for (int j = 0; j<Integer.parseInt(yDimension[0].getText()); j++)
				{
					matrixData[a][i][j] = Integer.parseInt(arraySize[a][i][j].getText());
                                        int digit = matrixData[a][i][j];
                                        if (digit == 0 || digit == 1)
                                        { 
                                           System.out.println("alert Received!");
                                           
                                        }
                                        else
                                            alert|=1;
                                        System.out.println(matrixData[a][i][j]);
				}
			}
                    }
                    else if (formCheck.equals("Power"))
                    {
	
                        for (int i = 0; i<Integer.parseInt(xDimension[a].getText()); i++)
			{
				for (int j = 0; j<Integer.parseInt(xDimension[a].getText()); j++)
				{
					matrixData[a][i][j] = Integer.parseInt(arraySize[a][i][j].getText());
                                        int digit = matrixData[a][i][j];
                                        if (digit == 0 || digit == 1)
                                        { 
                                           System.out.println("alert Received!");
                                           
                                        }
                                        else
                                            alert|=1;
                                        System.out.println(matrixData[a][i][j]);
				}
			}
                    }
		

	else 
                    {
	
                        for (int i = 0; i<Integer.parseInt(xDimension[a].getText()); i++)
			{
				for (int j = 0; j<Integer.parseInt(yDimension[a].getText()); j++)
				{
					matrixData[a][i][j] = Integer.parseInt(arraySize[a][i][j].getText());
                                        int digit = matrixData[a][i][j];
                                        if (digit == 0 || digit == 1)
                                        { 
                                           System.out.println("alert Received!");
                                           
                                        }
                                        else
                                            alert|=1;
                                        System.out.println(matrixData[a][i][j]);
				}
			}
                    }
		}
        }
        
        public void generateValue()
        {
            
            switch(formCheck)
            {	
		case "Meet":    for (int a = 0; a<m; a++)
                                {
                                    for (int i = 0; i<Integer.parseInt(xDimension[0].getText()); i++)
                                    {
                                        for (int j = 0; j<Integer.parseInt(yDimension[0].getText()); j++)
                                        {
                                            matrixData[0][i][j] &= matrixData[a][i][j];
                                        }
                                    }
                                }   
				break;		
		case "Join": 	for (int a = 0; a<m; a++)
                                {
                                    for (int i = 0; i<Integer.parseInt(xDimension[0].getText()); i++)
                                    {
                                        for (int j = 0; j<Integer.parseInt(yDimension[0].getText()); j++)
                                        {
                                            matrixData[0][i][j] |= matrixData[a][i][j];
                                        }
                                    }
                                } 
                                break;		
		case "Product": for (int a = 0; a<m-1; a++)
                                {
                                    for (int i = 0; i<Integer.parseInt(xDimension[a].getText()); i++)
                                    {
                                        for (int k = 0; k<Integer.parseInt(yDimension[a+1].getText()); k++)
                                        for (int j = 0; j<Integer.parseInt(yDimension[a].getText()); j++)
                                        {
                                            matrixResult[0][i][k] |= matrixData[a][i][j] & matrixData[a+1][j][k]; 
                                        }
                                    }
                                }	
				break;	
                case "Power":   for (int b = 0; b<Integer.parseInt(power.getText()); b++)
                                {
                                    for (int a = 0; a<m; a++)
                                    for (int i = 0; i<Integer.parseInt(xDimension[a].getText()); i++)
                                    {
                                        for (int k = 0; k<Integer.parseInt(xDimension[a].getText()); k++)
                                        for (int j = 0; j<Integer.parseInt(xDimension[a].getText()); j++)
                                        {
                                            matrixResult[0][i][k] |= matrixData[a][i][j] & matrixData[a][j][k]; 
                                        }
                                    }
                                }
                                break;
            }
        }
        
        public void showValue()
	{
		form2_2.setVisible(false);
		arraySize = new JTextField[m][100][100];
                groupForm3 = new JPanel[m];
                enterValueEach = new TitledBorder[m];
                
		if(formCheck.equals("Join") || formCheck.equals("Meet"))
                { 
                    for (int a = 0; a<1; a++)
                    {
                        enterValueEach[a] = new TitledBorder("M");
                        groupForm3[a] = new JPanel();
                        groupForm3[a].setLayout(new GridLayout(Integer.parseInt(xDimension[0].getText()),Integer.parseInt(yDimension[0].getText())));

			for (int i = 0; i<Integer.parseInt(xDimension[0].getText()); i++)
			{
                            for (int j = 0; j<Integer.parseInt(yDimension[0].getText()); j++)
                            {
                                arraySize[a][i][j] = new JTextField(""+matrixData[a][i][j]);
				groupForm3[a].add(arraySize[a][i][j]);
                            }
			}
			
                        groupForm3[a].setSize(groupForm3[a].getPreferredSize());
			groupForm3[a].setBorder(enterValueEach[a]);
			parent2_3.add(groupForm3[a]); 
                    }
                }
                else
                {
                    for (int a = 0; a<1; a++)
                    {
                        enterValueEach[a] = new TitledBorder("M");
                        groupForm3[a] = new JPanel();
                        
			if(formCheck.equals("Product"))
                        {
                            groupForm3[a].setLayout(new GridLayout(Integer.parseInt(xDimension[0].getText()),Integer.parseInt(yDimension[0].getText())));
                            for (int i = 0; i<Integer.parseInt(xDimension[a].getText()); i++)
                            {
                                for (int j = 0; j<Integer.parseInt(yDimension[a+1].getText()); j++)
                                {
                                    arraySize[a][i][j] = new JTextField(""+matrixResult[a][i][j]);
                                    groupForm3[a].add(arraySize[a][i][j]);
                                }
                            }
                        }
                        else
                        {
                            groupForm3[a].setLayout(new GridLayout(Integer.parseInt(xDimension[0].getText()),Integer.parseInt(xDimension[0].getText())));
                            for (int i = 0; i<Integer.parseInt(xDimension[0].getText()); i++)
                            {
                                for (int j = 0; j<Integer.parseInt(xDimension[0].getText()); j++)
                                {
                                    arraySize[a][i][j] = new JTextField(""+matrixResult[a][i][j]);
                                    groupForm3[a].add(arraySize[a][i][j]);
                                }
                            }
                        }
			
                        groupForm3[a].setSize(groupForm2[a].getPreferredSize());
			groupForm3[a].setBorder(enterValueEach[a]);
			parent2_3.add(groupForm3[a]); 
                    }
                }
		scroller2 = new JScrollPane(parent2_3);
		scroller2.getVerticalScrollBar().setUnitIncrement(16);
                results = new TitledBorder("RESULT");
                scroller2.setBorder(results);
		//parent2_2.add(parentControl, BorderLayout.SOUTH);
		//parent2_2.setBorder(enterDimension);
		//parent2_2.setBorder(enterDimensions);
		form2_3.add(scroller2);
		//form2_3.add(parentControl, BorderLayout.SOUTH);
		
		form2_3.pack();
		//form2_2.setSize(185,400);
		form2_3.setResizable(true);
		form2_3.setVisible(true);
		
		bNext.addActionListener(this);
		bCancel.addActionListener(this);
	
		form2_3.addWindowListener(new MyCloseButtonHandler());
                
	}
        
        public void checkChar()
        {
            if(alert==1)
            {
                JOptionPane.showMessageDialog(null, "Enter Values (0 or 1 ONLY)");
                alert = 0;
                checkPassed = 0;
            }
            else
                checkPassed = 1;
        }
	
	public void actionPerformed(ActionEvent ae) 
	{
		Object source = ae.getSource();
		
 //       	try
 //       	{
			if (source == bNext) 
			{
				switch (buttonPressCount)
				{
					case 0: formCheck = selection.getSelectedItem().toString();
					        if (formCheck.equals("Power"))
                                                {
                                                    m = 1;
                                                    buttonPressCount++;
                                                    launchFrame2_1();
                                                }
                                                   
					        else
						launchFrame1();
                                                buttonPressCount++;
						break;
					case 1: m = Integer.parseInt (qtyMatrix.getText());
					              switch(formCheck)
					               {	
						case "Meet": launchFrame2_1();
						                       break;		
						case "Join": launchFrame2_1();	
						                       break;		
						case "Product": launchFrame2_1();	
						                       break;		
						
					                }
                                                buttonPressCount++;
						break;
					case 2: if (formCheck.equals("Product"))
                                                {
                                                    checkDimension();
                                                    if(dimensionPassed==0)
                                                    break;
                                                }
						launchFrame3();
                                                buttonPressCount++;
						break;
                                            
                                        case 3: 
                                                gatherValues();
                                                
                                                    checkChar();
                                                    if(checkPassed==0)
                                                    break;
                                                generateValue();
                                                showValue();
                                                buttonPressCount++;
                                                break;
                                        case 4: 
                                                generateValue();
                                                buttonPressCount++;
                                                break;
                                               
				}
System.out.println("buttonpress:" +buttonPressCount);
				
				
			}
			
			
			else if (source == bCancel) 
			{
				System.exit(0);
			}
//		}
		
//		catch(Exception e){
//		System.out.println(e);}
		
	}
	
	private class MyCloseButtonHandler extends WindowAdapter 
	{
		public void windowClosing(WindowEvent we) 
		{
			System.exit(0);
		}
	}
	
	
	public static void main(String args[]) 
	{	
		noname x = new noname();
		x.launchFrame0();
	}
}




















