public class Palin{

   static public void main(String... args){
   
      System.out.print("Enter a String : ");
      String s = new java.util.Scanner(System.in).nextLine();
      int i=0,j=s.length()-1;
      for(;i<s.length();i++,j--){         
         if(s.charAt(i) != s.charAt(j)){
            break;   // if not a palindrome, stop the loop
         }         
      }      
      String message =(i==s.length()) ? "Palindrome":"Not Palindrome";
      System.out.println(message);
   }
}//end of class