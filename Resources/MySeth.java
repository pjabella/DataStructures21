public interface MySeth{

   //sentinels
   public boolean isEmpty();
   public boolean isFull();
   //auxiliary methods
   public Object newElement(Object item);
   public MySeth Union(MySeth set);
   
   public int cardinality();
   }