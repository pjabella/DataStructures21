
public class CircularQueue implements MyQueue{

   private Object[] queue;
   private int front,rear,count;
   
   public CircularQueue(int size)   { this.queue = new Object[size]; }
   public CircularQueue()           { this(10); }
    //sentinel methods
   public boolean isEmpty()         { return count == 0;}
   public boolean isFull()          { return count == queue.length; }
   //allowable operations
   public boolean enqueue(Object item){
      boolean ok = !isFull();
         if(ok){
         }
      return ok;
   }
   public Object peek()             { return (!isEmpty())? queue[front] : null ; }
   public Object dequeue(){
      Object item = peek();
         if(item!=null){
         }
      return item;   
   }
   public String toString(){
      StringBuffer sb=new StringBuffer();
         for(int i=0;i<queue.length;i++){
            if(queue[i]!=null){
               sb.append(queue[i]);
            }else{
               sb.append("_");
            }
            if(i<queue.length-1){
               sb.append(",");
            }
         }   
      return sb.toString();
   }

   static public void main(String... args){
      CircularQueue q = new CircularQueue(6);   
         System.out.println(q);
   }

}//end of class