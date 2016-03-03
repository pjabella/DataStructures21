//Testclass for the Queue

public class TestClass{

   static public void main(String... args){
      QueueLink q = new QueueLink();
        
         q.addelement(new String("X"));
          System.out.println(q);
          q.addelement(new String("Z"));
          System.out.println(q);
           q.addelement(new String("F"));
          System.out.println(q);
           q.addelement(new String("A"));
            System.out.println(q);
            q.addelement(new String("J"));
         //System.out.print(q.enqueue(new String("4")));
         System.out.println(q);
         System.out.println();
   }

}//end of class