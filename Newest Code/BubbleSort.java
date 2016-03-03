public class BubbleSort implements Sort{

   private Object[] items;
   private Object[] unsorted;
   private double time;
   
   //constructors
   public BubbleSort(Object[] items){
      this.items=items;
      //this.unsorted=items;
      this.unsorted = new Object[items.length];
      for(int i=0;i<items.length;this.unsorted[i]=items[i],i++);
      //call the sort function
      double start = System.currentTimeMillis()*(1.0);
         sort();
      double end = System.currentTimeMillis()*(1.0);
      time=end-start;   
   }
   private void sort(){
      //loop for the passes
      for(int i = 1;i<items.length;i++){
         //loop for the bubbles
         for(int j=0;j<items.length-i;j++){
            //check 
            Comparable c=(Comparable)items[j];
            if(c.compareTo(items[j+1])>0){
            //swap
               Object temp=items[j];
               items[j]=items[j+1];
               items[j+1]=temp;
            }
         }
      }
   }   
   
   public String ascending(){
      StringBuffer sb=new StringBuffer();
         for(int i=0;i<items.length;i++){
            sb.append(items[i]);
            if(i<items.length-1) sb.append(",");
         }
      return sb.toString();
   }
   public String descending(){
       StringBuffer sb=new StringBuffer();
         for(int i=items.length-1;i>-1;i--){
            sb.append(items[i]);
            if(i>0) sb.append(",");
         }
      return sb.toString();

   }
   public String unsorted(){
       StringBuffer sb=new StringBuffer();
         for(int i=0;i<unsorted.length;i++){
            sb.append(unsorted[i]);
            if(i<unsorted.length-1) sb.append(",");
         }
      return sb.toString();

   }
   public int count()            { return items.length; }
   public double sortTime()      { return time;}


   static public void main(String... args){
     /* int size = 1000;
      Integer[] items = new Integer[1000];
      
      for(int i=0;i<size;items[i]=new java.util.Random().nextInt(),i++);
   
      Sort sort = new BubbleSort(items);   
      System.out.println("Ascending : "+sort.ascending());
      System.out.println("Descending: "+sort.descending());
      System.out.println("Un-Sorted : "+sort.unsorted());
      System.out.println("Count     : "+sort.count());
      System.out.println("Sort Time : "+sort.sortTime());*/
   }

}//end of class