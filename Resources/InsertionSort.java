public class InsertionSort implements Sort{

   private Object[] items;
   private Object[] unsorted;
   private double time;
   
   public InsertionSort(Object[] items){
      this.items=items;
      this.unsorted = new Object[items.length];
      for(int i=0;i<items.length;unsorted[i]=items[i],i++);
      
      double start = System.currentTimeMillis();
      sort();
      double end = System.currentTimeMillis();
      time = end - start;
   }
   
   private void sort(){
      
      for(int i=1,j=0;i<items.length;i++){
         Comparable c = (Comparable)items[i];
         for(j=i-1;j>=0 && c.compareTo(items[j])<0;items[j+1]=items[j],j--);
         items[j+1]=c;            
      }
   
   }
   
   
   public String ascending(){
      StringBuffer sb=new StringBuffer();
         for(int i=0;i<items.length;i++){
            sb.append(items[i]);
            if(i<items.length-1)
               sb.append(", ");
         }
      return sb.toString();
   }
   
   public String descending(){
      StringBuffer sb=new StringBuffer();
         for(int i=items.length-1;i>-1;i--){
            sb.append(items[i]);
            if(i>0)
               sb.append(", ");
         }
      return sb.toString();
   
   }
   public String unsorted(){
      StringBuffer sb=new StringBuffer();
         for(int i=0;i<unsorted.length;i++){
            sb.append(unsorted[i]);
            if(i<unsorted.length-1)
               sb.append(", ");
         }
      return sb.toString();
   }
   public int count()            { return (items!=null)? items.length : 0;}
   public double sortTime()      { return time; }

   static public void main(String... args){
     /*for(int size=1000;size<=10000;size+=2000){
         Integer[] items = new Integer[size];
         for(int i = 0;i<size;items[i]=new java.util.Random().nextInt(),i++);
         Sort sort = new InsertionSort(items);
         //System.out.println("Ascending Order  : "+ sort.ascending());
         //System.out.println("Descending Order : "+ sort.descending());
         //System.out.println("Un-Sorted  Order : "+ sort.unsorted());
         System.out.println("Count            : "+ sort.count());
         System.out.println("Sort Time        : "+ sort.sortTime()+" millisecond(s)");
      }*/     
   }
   
}//end of class