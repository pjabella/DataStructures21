import java.awt.*;       
import java.awt.event.*; 
 

public class AWTCounter extends Frame implements ActionListener {
   //private Panel = pane;
   private Label lblCount1,lblCount2,lblCount3,lblCount4,lblCount5;    
   private TextField tfCount,tfCount2,tfCount3,tfCount4,tfCount5;
   private Button btnCount; 
   private int count = 0;   
  
  
   public AWTCounter () {
     setLayout(new GridLayout());
                //natural height, maximum width
              
      

     // lblCount1 = new Label("    ");     
    //  add(lblCount1);
      lblCount2 = new Label("Bubble Sort\n");     
       add(lblCount2);
       
      tfCount2 = new TextField("0", 20);
      tfCount2.setEditable(false);
      tfCount2.setSize(100,100);
      add(tfCount2);  
      tfCount3 = new TextField("0", 20);
      tfCount3.setEditable(false);      
      
      add(tfCount3);                  
      lblCount3 = new Label("Selection Sort\n"); 
   
      add(lblCount3);
      lblCount4 = new Label("Insertion Sort\n");     

      add(lblCount4);
       
      tfCount = new TextField("0", 20);
      tfCount.setEditable(false);      

      add(tfCount);                     
 
      btnCount = new Button("Count");
  
      add(btnCount);                   
 
      btnCount.addActionListener(this);
      
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Sort Test");  
      setSize(500,400 );      
 
      
 
      setVisible(true);         
 
     
   }
 
  
   public static void main(String[] args) {
     
      AWTCounter app = new AWTCounter();
   }
 
  
   @Override
   public void actionPerformed(ActionEvent evt) {
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

      
       
       tfCount3.setText(res[0]+ "");
      tfCount.setText(res[1] + "");
   }
}