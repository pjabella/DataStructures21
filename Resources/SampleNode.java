public class SampleNode implements MySeth{

   private Node list, first,element;
   private int count;
   
   public boolean isEmpty(){ return count==0;}
   public boolean isFull(){return false;}
   
   public  Object newElement(Object item){
   Node node =new Node(item);
      if(isEmpty()){
         first = node; 
         list = node;
      }   
      else{
         list.setNext(node);
         list = node;
      }
      count++;   
   
   return list;
   }
   
 /*  public Object getItemAtPosition(int position){
      return (!isEmpty())? first.getItem():null;
   }*/
   
   public MySeth Union(MySeth set){
     int comb = cardinality() + set.cardinality();
         MySeth result = new SampleNode();
          SampleNode s=(SampleNode)set;      
            for(Node tnode = first; tnode!= null; result.newElement(tnode.getItem()), tnode=tnode.getNext());
           
           
           /* result.newElement(s.tnode.getItem());
            
              /*result.newElement(listElement());
              result.newElement(s.listElement());*/
              
          
         /*  for(int i=0;i<set.cardinality();i++){
              result.newElement(toString());
          }*/
      return result;
   }   
   public int cardinality(){
   return count;        
    }
    
     public  String toString(){
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

      /*public  String listElement(){
      StringBuffer sb=new StringBuffer();
        
         for(Node tnode = first; tnode!= null; tnode=tnode.getNext()){
            sb.append(tnode.getItem());
            if(tnode.getNext()!=null){
               sb.append(", ");
            }
         }
        
      return sb.toString();
   }*/
   

   public static void main(String...args){
     MySeth samp1 = new SampleNode();
     MySeth samp2 = new SampleNode();
      samp1.newElement(new String("1"));
      samp1.newElement(new String("2"));
      samp1.newElement(new String("3"));
      samp1.newElement(new String("4"));
      samp2.newElement(new String("4"));
      samp2.newElement(new String("5"));
      samp2.newElement(new String("6"));
      
      System.out.println(samp1);
       
      System.out.println(samp2);
      System.out.println(samp1.Union(samp2));
   }

}//end of class