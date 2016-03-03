public class SelectionSort implements Sort{

   private Object[] items;
   private Object[] unsorted;
   private double time;
   
   //constructor
   public SelectionSort(Object[] items){ 
      this.items=items;     
      this.unsorted=new Object[items.length]; 
      for(int i=0;i<items.length;unsorted[i]=items[i],i++); 
      //get the time to sort 
      double start = System.currentTimeMillis()*1.0;     
         sort();
      double end = System.currentTimeMillis()*1.0;     
      time = end-start;
   }
   
   private void sort(){
      
      for(int i=0;i<items.length;i++){
         int smallest = i;
         for(int j=smallest;j<items.length-1;j++){
            Comparable c=(Comparable)items[j];
            
            if(c.compareTo(items[j+1])>0){
               smallest=j+1;
            }
            
         }
         //swap
         if(i!=smallest){
            Object temp = items[i];
            items[i]=items[smallest];
            items[smallest]=temp;
         }         
      }
      
   }
   
   public String ascending(){
      StringBuffer sb = new StringBuffer();
         for(int i=0;i<items.length;i++){
            sb.append(items[i]);
            if(i<items.length-1) sb.append(",");
         }
      return sb.toString();
   }
   public String descending(){
       StringBuffer sb = new StringBuffer();
         for(int i=items.length-1;i>-1;i--){
            sb.append(items[i]);
            if(i>0) sb.append(",");
         }
      return sb.toString();

   }
   public String unsorted(){
      StringBuffer sb = new StringBuffer();
         for(int i=0;i<unsorted.length;i++){
            sb.append(unsorted[i]);
            if(i<unsorted.length-1) sb.append(",");
         }
      return sb.toString();
   }
   public int count()   {
      return items.length;
   }
   public double sortTime(){
      return time;
   }

   static public void main(String... args){
   /*
      int size=10000;
      Integer[] items = new Integer[size];
      
      for(int i=0;i<size;i++){
         items[i]=new java.util.Random().nextInt();
      }
   
      SelectionSort sort = new SelectionSort(items);   
      System.out.println("Ascending Order  : "+sort.ascending());
      System.out.println("Descending Order : "+sort.descending());
      System.out.println("Unsorted Order   : "+sort.unsorted());
      System.out.println("Sort Time        : "+sort.sortTime());
      System.out.println("Count            : "+sort.count());*/
   }

}//end of class