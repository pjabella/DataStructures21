//QueueArray - array bases ordinary queue
// head does not move, it is always placed at idex 0 of the container

public class MyQueueArray implements MyQueue{

   private Object[] queue;
   private int head,tail;
   
   //constructors
   public MyQueueArray(int size)          { this.queue = new Object[size];}
   public MyQueueArray(Object[] queue)    { this.queue = queue; this.tail = queue.length-1;}
   //default constructor - uses a default size queue container, in this case 10
   public MyQueueArray()                  { this(10); }
   
    //sentinel methods
   public boolean isFull()                { return this.tail == queue.length; }
   public boolean isEmpty()               { return this.tail == 0; }
   //allowable operations
   public boolean enqueue(Object item){
      boolean ok = !isFull();
         if(ok){
            queue[tail++] = item;
         }
      return ok;   
   }
   public Object peek()                   { return (!isEmpty())? queue[head]:null ; }
   public Object dequeue(){
      Object item = peek();
         if(item!=null){
            for(int i=head;i<tail-1;i++){
               queue[i] = queue[i+1];
            }
            tail--;
         }
      return item;
   }
   
   public String toString(){
      StringBuffer sb=new StringBuffer();
         for(int i=head;i<tail;i++){
            sb.append(queue[i]);   
            if(i<tail-1){
               sb.append(",");
            }
         }
      return sb.toString();
   }
   

}//end of class