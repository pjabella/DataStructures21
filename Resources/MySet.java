public interface MySet{

   //sentinels
   public boolean isEmpty();
   public boolean isFull();
   //auxiliary methods
   public boolean isElement(Object item);
   public boolean addElement(Object item);
   //allowable operations
   public MySet union(MySet set);
   public MySet intersect(MySet set);
   public MySet subtract(MySet set);
   public MySet crossProduct(MySet set);
   public int cardinality();

}//end of interface