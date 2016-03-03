//Queue inteface

public interface MyQueue{

   //sentinel methods
   public boolean isFull();
   public boolean isEmpty();
   //allowable operations
   public boolean enqueue(Object item);
   public Object peek();
   public Object dequeue();

}//end of interface