public class MySetArray implements MySet{

   private Object[] items;
   private int count;
   
   //constructors
   public MySetArray(int size)               { this.items = new Object[size]; }
   public MySetArray()                       { this(10);}
    //sentinels
   public boolean isEmpty()                  { return count == 0; }
   public boolean isFull()                   { return count == items.length; }
   //auxiliary methods
   public boolean isElement(Object item){
      boolean found = false;
         //sequential search
         for(int i=0;i<count;i++){
            if(item.equals(items[i])){
              return true;
            }
         }      
      return found;
   }
   
   public boolean addElement(Object item){
      boolean ok = !isFull() && !isElement(item);   
         if(ok)   items[count++] = item;
      return ok;
   }
   //local method in MySetArray for retrieving an element from the set using index
   public Object getItemAtPosition(int position){
      return (!isEmpty())? items[position]:null;
   }
   
   //allowable operations
   public MySet union(MySet set){
      int size = cardinality() + set.cardinality();
      MySet result = new MySetArray(size);
      MySetArray s=(MySetArray)set;      
         //populate the result set using the current set
         for(int i=0;i<cardinality();result.addElement(items[i]),i++);
         //populate the result set using the parameter set
         for(int i=0;i<set.cardinality();result.addElement(s.getItemAtPosition(i)),i++);
      return result;
   }
   public MySet intersect(MySet set){ 
      int size=(cardinality()<set.cardinality())?cardinality():set.cardinality();
      MySet result = new MySetArray(size);
         for(int i=0;i<cardinality();i++){
            if(set.isElement(items[i])){
               result.addElement(items[i]);
            }
         }   
      return result;
   }
   public MySet subtract(MySet set){
      int size=(cardinality()<set.cardinality())?cardinality():set.cardinality();
      MySet result = new MySetArray(size);
         for(int i=0;i<cardinality();i++){
            if(!set.isElement(items[i])){
               result.addElement(items[i]);
            }
         }   
      return result;

   }
   public MySet crossProduct(MySet set){
      int size = cardinality()*set.cardinality();
      MySet result = new MySetArray(size);  
      MySetArray s=(MySetArray)set; 
         for(int i=0;i<cardinality();i++){
            for(int j=0;j<set.cardinality();j++){
               MySet temp = new MySetArray(2);
               temp.addElement(getItemAtPosition(i));
               temp.addElement(s.getItemAtPosition(j));
               //must check for tuple
               if(temp.isFull()) result.addElement(temp);
            }
         }
      return result;
   }
   
   public int cardinality()                  { return count;}
   //toString()
   public String toString(){
      StringBuffer sb=new StringBuffer();
         sb.append("{");
         for(int i=0;i<count;i++){
            sb.append(items[i]);
            if(i<count-1) sb.append(",");
         }
         sb.append("}");
      return sb.toString();
   }

   static public void main(String... args){
      MySet setA = new MySetArray();
      MySet setB = new MySetArray();
         setA.addElement(new String("1"));
         setA.addElement(new String("2"));
         setA.addElement(new String("3"));
         setA.addElement(new String("4"));
         //
         setB.addElement(new String("3"));
         setB.addElement(new String("4"));
         setB.addElement(new String("5"));
         setB.addElement(new String("6"));
         
         System.out.println("Set A = "+setA);
         System.out.println("Set B = "+setB);
         System.out.println("AUB = "+setA.union(setB));
         System.out.println("A^B = "+setA.intersect(setB));
         System.out.println("A-B = "+setA.subtract(setB));
         System.out.println("B-A = "+setB.subtract(setA));
         System.out.println("AxB = "+setA.crossProduct(setB));
   }

}//end of class