public class DecBin2{
   
   static public void main(String... args){
      int bits = 16;
      System.out.print("Enter a decimal value :");
      try{
         int dec = new java.util.Scanner(System.in).nextInt();
         for(int i=0,shift=bits-1;i<bits; i++,shift--){            
            int bit = dec >> shift; 
            bit &= 0x01;
            System.out.printf("%d ",bit);
         }         
      }
      catch(Exception e){}
      
   }

}//end of class