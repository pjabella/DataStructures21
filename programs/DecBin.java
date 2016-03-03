//decimal to binary

public class DecBin{

   static public void main(String... args){
      System.out.print("Enter a Decimal number :");
      
      try{
         int n = new java.util.Scanner(System.in).nextInt();
         java.util.Stack stack = new java.util.Stack();
         
         for(;n>0;stack.push(n%2),n/=2);        
         for(;!stack.empty();System.out.print(stack.pop()));                  
      }
      catch(Exception e){
         System.out.println("Invalid Input");
      }
      
      
   }

}//end of class
