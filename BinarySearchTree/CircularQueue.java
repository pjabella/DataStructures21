import java.util.*;

public class CircularQueue {

   static Scanner scan = new Scanner(System.in);
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
           queue[rear++] = item;
           count++;
         }
         rear = (rear)%queue.length;
      return ok;
   }
   public Object peek()             { return (!isEmpty())? queue[front] : null ; }
   public Object dequeue(){
      Object item = peek();
         if(item!=null){
               queue[front++] = null;   
               count--;
            }           
            front = (front)%queue.length;
      return item;   
   }
   public String toString(){
      StringBuffer sb=new StringBuffer();
         for(int i=0;i<queue.length;i++){
            if(queue[i]!=null){
               sb.append(queue[i]);
            }
            if(i<queue.length-1){
               sb.append(" ");
            }
         }   
      return sb.toString();
   }

  //  static public void main(String... args){
//      
//       CircularQueue q = new CircularQueue(6);   
//          System.out.println(q);
//          
//       System.out.println(q.enqueue(new String("A")));
//       System.out.println(q.enqueue(new String("B")));
//       System.out.println(q.enqueue(new String("C")));
//       System.out.println(q.enqueue(new String("D")));
//       System.out.println(q.enqueue(new String("E")));
//       System.out.println(q.enqueue(new String("F")));
//       System.out.println(q);
//       System.out.println("Queue Peek : " + q.peek());
//       System.out.println(q);
//       System.out.println("Queue Dequeue: " + q.dequeue());
//       System.out.println(q);
//       System.out.println("Queue Dequeue: " +q.dequeue());
//       System.out.println(q);
//       
//       }

}//end of class