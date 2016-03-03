public class MySetlink implements MySet{

   private int count= 0 ;
   private Node link,first;
   
   public boolean isEmpty(){return count==0;}
   public boolean isFull(){return false;}
   
   public boolean isElement(Object item){
      Node node= new Node(item);
      boolean found = false;
        for(Node tnode = first ; tnode!= null; tnode=tnode.getNext()){
           if(tnode.getItem() == item){
              return true;
            }
         }     
    return found;
      }
   public boolean addElement(Object item){
      Node node = new Node(item);
              if(isEmpty()){
               first= node;
               link = node;
              }
              else{
               link.setNext(node);
               link = node;
              }
      count++;
      return true;
   }
  
   public MySet union(MySet link){
        int comb = cardinality() + link.cardinality();
         MySet result = new MySetlink();
          MySetlink s=(MySetlink)link;      
            for(Node tnode = first; tnode!= null; result.addElement(tnode.getItem()), tnode=tnode.getNext());
      
      return result;
   }
   public MySet intersect(MySet link){return null;}
   public MySet subtract(MySet link){ return null;}
   public MySet crossProduct(MySet link){return null;}
  
  public int cardinality(){
      return count;
   }
  
  
  public String toString(){
      StringBuffer sb=new StringBuffer();
         sb.append("{");
         for(Node tnode = first; tnode!= null; tnode=tnode.getNext()){
            sb.append(tnode.getItem());
            if(tnode.getNext()!=null){
               sb.append(", ");
            }
         }
         sb.append("}");
      return sb.toString();
   }



   
   
   public static void main(String[]args){
   MySet setA = new MySetlink();
      MySet setB = new MySetlink();
         setA.addElement(new String("1"));
         setA.addElement(new String("2"));
         setA.addElement(new String("3"));
         setA.addElement(new String("4"));
         //
         setB.addElement(new String("3"));
         setB.addElement(new String("4"));
         setB.addElement(new String("5"));
         
         System.out.println("Set A = "+setA);
         System.out.println("Set B = "+setB);
         System.out.println("AUB = "+setA.union(setB));
         System.out.println("A^B = "+setA.intersect(setB));
         System.out.println("A-B = "+setA.subtract(setB));
         System.out.println("B-A = "+setB.subtract(setA));
         System.out.println("AxB = "+setA.crossProduct(setB));

   
   }
   



}//end of class