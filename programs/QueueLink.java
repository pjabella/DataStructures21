public class SortLink{
   
   private Node front,rear;
   
   //no need for a constructor
   // construct the Object, by the time a real data entered
   
   //sentinel methods
   public boolean isFull()                { return false; }
   public boolean isEmpty()               { return front == null; }
   //allowable operations
   
   public Object peek(){
      return (!isEmpty())? front.getItem():null;
   }

   public Object addelement(Object item){
      Node node = new Node(item);
 
         if(isEmpty())  {
            front = node; rear= node;
         }
         else{
            if(front.getItem().toString().compareTo(item.toString())>0){
            node.setNext(front);
            front = node;
            }
         else if(rear.getItem().toString().compareTo(item.toString())<0){
              //Node tnode = rear;
              rear.setNext(node);   
              rear = node;
         }
         else if(rear.getItem().toString().compareTo(item.toString())>0 ){
           //Node tnode = front;
            for(Node tnode=front;tnode.getNext()!=null;tnode = tnode.getNext()){
               if(tnode.getItem().toString().compareTo(item.toString())<0&&tnode.getNext().toString().compareTo(item.toString())>0){
                  Node znode = tnode.getNext();
                  //Node fnode = tnode;
                   tnode.setNext(node);
                   node.setNext(znode);
              
                  // prev.next = new Node<AnyType>(toInsert, cur);
               }
               }
               
           }
         }
      return true;
   }
      /*
   public Object dequeue(){
      Object item = peek();
         if(item!=null){
            Node tnode = front;
            front = tnode.getNext();
            tnode = null;
         }
      return item;
   }
*/


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