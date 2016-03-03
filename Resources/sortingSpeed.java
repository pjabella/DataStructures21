package sort;
//package sort;
/*
 * GridBagLayoutDemo.java requires no other files.
 */
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

 
public class sortingSpeed {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    private static Button button,btnc;
    private static Label lbl0,lbl1,lbl2,lbl3,lbl4,lbl5;  
    public static TextField tfield0,tfield1,tfield2,tfield3,tfield4,tfield5,tfield20,tfield21,tfield22,tfield23,tfield24,tfield25,tfield30,tfield31,tfield32,tfield33,tfield34,tfield35;  
    private static TextField fas,mid,slow;  

    
    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
      JSeparator act;
 
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    if (shouldFill) {
    //natural height, maximum width
    c.fill = GridBagConstraints.HORIZONTAL;
    }
   
   lbl0 = new Label("Number of Items:        ");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10,10,10,10);
     //lbl0.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 0;
    pane.add(lbl0, c);
   
    /*tfield = new TextField("  ");
  //  if (shouldWeightX) {
  //   c.weighty= 1;
  //  }
    c.fill = GridBagConstraints.HORIZONTAL;
     tfield.setEditable(false);
    c.weightx = 1;
    c.gridx = 0;
    c.gridy = 0;
    pane.add(tfield, c);
 */
     lbl0 = new Label("     1000");
   c.fill = GridBagConstraints.HORIZONTAL;
  c.ipadx = 50;
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridy = 0;
    pane.add(lbl0, c);
    
    lbl0 = new Label("     3000");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 0;
    pane.add(lbl0, c);
    
    lbl0 = new Label("     5000");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 3;
    c.gridy = 0;
    pane.add(lbl0, c);
    
     lbl0 = new Label("     7000");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 4;
    c.gridy = 0;
    pane.add(lbl0, c);
 
   lbl0 = new Label("     9000");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 5;
    c.gridy = 0;
    pane.add(lbl0, c);

   lbl1 = new Label("Bubble Sort");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 1;
    pane.add(lbl1, c);
    
     tfield0 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield0.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridy = 1;
    pane.add(tfield0, c);
     tfield1 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield1.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 1;
    pane.add(tfield1, c);
    
     tfield2 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield2.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 3;
    c.gridy = 1;
    pane.add(tfield2, c);
    
    tfield3 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield3.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 4;
    c.gridy = 1;
    pane.add(tfield3, c);
    
    tfield4 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield4.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 5;
    c.gridy = 1;
    pane.add(tfield4, c);
 
  lbl2 = new Label("Selection Sort");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 2;
    pane.add(lbl2, c);
    
     tfield20 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield20.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridy = 2;
    pane.add(tfield20, c);
     tfield21 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield21.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 2;
    pane.add(tfield21, c);
    
     tfield22 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield22.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 3;
    c.gridy = 2;
    pane.add(tfield22, c);
    
    tfield23 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield23.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 4;
    c.gridy = 2;
    pane.add(tfield23, c);
    
    tfield24 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield24.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 5;
    c.gridy = 2;
    pane.add(tfield24, c);
    
      lbl3 = new Label("Insertion Sort");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 3;
    pane.add(lbl3, c);
    
     tfield30 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield30.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridy = 3;
    pane.add(tfield30, c);
     tfield31 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield31.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 3;
    pane.add(tfield31, c);
    
     tfield32 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield32.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 3;
    c.gridy = 3;
    pane.add(tfield32, c);
    
    tfield33 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield33.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 4;
    c.gridy = 3;
    pane.add(tfield33, c);
    
    tfield34 = new TextField("0");
   c.fill = GridBagConstraints.HORIZONTAL;
   tfield34.setEditable(false);
    c.weightx = 0.5;
    c.gridx = 5;
    c.gridy = 3;
    pane.add(tfield34, c);

   
  act = new JSeparator(SwingConstants.HORIZONTAL);
     c.fill = GridBagConstraints.HORIZONTAL;;
   c.weightx = 0.0;
    //c.gridwidth = 7;   
    c.gridx = 0;
    c.gridy = 4;
    act.setVisible(true);
  pane.add(act,c);

//  pane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
   
    lbl0 = new Label("Speed");
   c.fill = GridBagConstraints.HORIZONTAL;
   c.weightx=0.5;
   c.gridx = 0;
   c.gridy = 5;
   pane.add(lbl0,c);

   lbl4 = new Label("Fastest");
   c.fill = GridBagConstraints.HORIZONTAL;
   c.weightx=1.0;
   c.gridx = 0;
   c.gridy = 6;
   pane.add(lbl4,c);
   
   fas = new TextField("N./A");
   c.fill = GridBagConstraints.HORIZONTAL;
   fas.setEditable(false);
    c.weightx = 1.0;
    c.gridx = 1;
    c.gridy = 6;
    pane.add(fas, c);
    
    lbl4 = new Label("Average");
   c.fill = GridBagConstraints.HORIZONTAL;
   c.weightx=1.0;
   c.gridx = 0;
   c.gridy = 7;
   pane.add(lbl4,c);
   
   mid = new TextField("N/A");
   c.fill = GridBagConstraints.HORIZONTAL;
   mid.setEditable(false);
    c.weightx = 1.0;
    c.gridx = 1;
    c.gridy = 7;
    pane.add(mid, c);

   
     
      button = new Button("Run");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 4;
    c.gridy = 9;
    pane.add(button, c);
    
    btnc = new Button("Clear");
   c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 5;
    c.gridy = 9;
    pane.add(btnc, c);
    
    btnc.addActionListener(new ActionListener(){      
    @Override
    public void actionPerformed(ActionEvent e){
      
      tfield0.setText("0");
      tfield1.setText("0 ");
      tfield2.setText("0");
      tfield3.setText("0");
      tfield4.setText("0");
      tfield20.setText("0");
      tfield21.setText("0");
      tfield22.setText("0");
      tfield23.setText("0");
      tfield24.setText("0");
      tfield30.setText("0");
      tfield31.setText("0");
      tfield32.setText("0");
      tfield33.setText("0");
      tfield34.setText("0");
      fas.setText("N/A");
      mid.setText("N/A");
     // slow.setText("N/A");  
        }
      });

    
    button.addActionListener(new ActionListener(){      
    @Override
    public void actionPerformed(ActionEvent e){
   double res[] = new double[5];
         
         double y=0;
      int z=0,x=0;
     /* for( x=1000; x<10000;y=Math.random(),x=x+2000){
         res[z] = y;
         z++;
      }*/
      for(int size=1000;size<=10000;size+=2000){
         Integer[] items = new Integer[size];
         for(int i = 0;i<size;items[i]=new java.util.Random().nextInt(),i++);
         Sort sort = new InsertionSort(items);
         res[z] = sort.sortTime();
         z++;
      }     

      
       tfield0.setText(res[0] + "");
      tfield1.setText(res[1] + "");
      tfield2.setText(res[2] + "");
      tfield3.setText(res[3] + "");
        }
      });

/*
    button = new JButton("Button 2");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 5;
    c.gridy = 1;
    pane.add(button, c);
 
    button = new JButton("Button 3");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 1;
    pane.add(button, c);
 
    button = new JButton("Long-Named Button 4");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 40;      //make this component tall
    c.weightx = 0.0;
    c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 2;
    pane.add(button, c);
 
    button = new JButton("5");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 0;       //reset to default
    c.weighty = 1.0;   //request any extra vertical space
    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
    c.insets = new Insets(10,0,0,0);  //top padding
    c.gridx = 1;       //aligned with button 2
    c.gridwidth = 2;   //2 columns wide
    c.gridy = 3;       //third row
    pane.add(button, c);
   */
    
    }

 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Sorting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
         addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGUI();
            }
        });
        
        
        
    }
    
 }