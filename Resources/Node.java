//Node class

public class Node{
   
   private Object item;
   private Node next;
 
   
   //constructor
   public Node(Object item)                  { this.item = item; }
   public Node()                                   {}
   
   //setter
   public void setItem(Object item)          { this.item = item; }
   public void setNext(Node next)            { this.next = next; }
   //public void setPrev(Node prev)            { this.prev = prev; }
   
   //getter  
   public Object getItem()                   { return item; }
   public Node getNext()                     { return next; }
   //public Node getPrev()                     { return prev; }

}//end of class