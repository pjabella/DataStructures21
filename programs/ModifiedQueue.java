//Modified Ordinary Queue

public class ModifiedQueue implements MyQueue{

   private Object[] queue;
   private int head,tail;
   
   //constructors
   public ModifiedQueue(int size)          { this.queue = new Object[size];}
   public ModifiedQueue(Object[] queue)    { this.queue = queue; this.tail = queue.length-1;}
   //default constructor - uses a default size queue container, in this case 10
   public ModifiedQueue()                  { this(10); }
   
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
   //modified Queue style of dequeuing
      Object item = peek();
         if(item != null){
            //queue[head] = null;
            //head++;
            queue[head++] = null;
         }
      return item;
   }
   
   public String toString(){
      //modified queue, display all the elements of the data container
      // including the vacant spaces
      StringBuffer sb=new StringBuffer();
         for(int i=0;i<queue.length;i++){
            // if(queue[i] == null) sb.append("_");
//             else sb.append(queue[i]);            
            String item =(queue[i] != null)? queue[i].toString() :"_" ;
            sb.append(item);
            
            if(i<tail-1){
               sb.append(",");
            }
         }
      return sb.toString();
   }
  

}//end of class
