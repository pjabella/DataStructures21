public class QueueLink implements MyQueue{
   
   private Node front,rear;
   
   //no need for a constructor
   // construct the Object, by the time a real data entered
   
   //sentinel methods
   public boolean isFull()                { return false; }
   public boolean isEmpty()               { return front == null; }
   //allowable operations
   public boolean enqueue(Object item){
      Node node = new Node(item);
         if(isEmpty())  {
            front = node; rear= node;
         }
         else{
            rear.setNext(node);
            rear = node;
         }
      return true;
   }
   public Object peek(){
      return (!isEmpty())? front.getItem():null;
   }
   public Object dequeue(){
      Object item = peek();
         if(item!=null){
            Node tnode = front;
            front = tnode.getNext();
            tnode = null;
         }
      return item;
   }

   public String toString(){
      StringBuffer sb = new StringBuffer();
      for(Node tnode=front;tnode!=null;tnode = tnode.getNext()){
         sb.append(tnode.getItem());
         if(tnode.getNext()!=null){
            sb.append("->");
         }
      }   
      return sb.toString();
   }

}//end of class