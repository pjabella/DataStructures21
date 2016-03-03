/* Stack Applications
   ------------------
   1. palindrome
   2. decimal to binary
   3. parenthesis checker
   4. infix to postfix converter
   
   palindrome - is a word that can read in both ways
      example : level, oro, hannah,lol
*/

import java.util.*;

public class Palindrome{   
   static public void main(String... args){
      // java create stack
      Stack stack = new Stack();
      System.out.print("Enter a String :");
      String s = new Scanner(System.in).nextLine();
      
      //populate the stack
      for(int i = 0;i<s.length(); i++){
         stack.push(s.charAt(i));
      }
      //check each character, match with stack content
      for(int i = 0 ;i<s.length();i++){
         char ch = s.charAt(i);
         if(ch == stack.peek().toString().charAt(0)){
            stack.pop();
         }
      }
      //ternary operator, to create message 
      String message =(stack.empty()) ? "Palindrome" : "Not Palindrome";
      System.out.println(message);
      
   }
}//end of class





