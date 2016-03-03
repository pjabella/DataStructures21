public class autosort{

   public Object[] items;
   public int count=0; 
   
   public autosort(int size)   { this.items = new Object[size]; }
   public autosort()           { this(10); }

   public boolean isEmpty()         { return count == 0;}
   public boolean isFull()          { return count == items.length; }
      
   public void addItem(Object item){
    boolean ok = !isEmpty();
    boolean alright = !isFull();
            items[count++] = item;
            if(ok&&alright){
               for(int x = count; x>1;x--){
                  Comparable c= (Comparable)items[x-1];
                     if(c.compareTo(items[x-2])<0){
                        Object temp = items[x-2];
                        items[x-2] = items[x-1];
                        items[x-1] = temp;
                     }
               }
            }

   }
   
   public String toString(){
      StringBuffer sb=new StringBuffer();
         for(int i=0;i<items.length;i++){
            if(items[i]!=null){
               sb.append(items[i]);
            }else{
               sb.append("_");
            }
            if(i<items.length-1){
               sb.append(", ");
            }
         }   
      return sb.toString();
   }

   public static void main(String...args){
      
      autosort as = new autosort(6);
      
      as.addItem(new String("S"));
      System.out.println(as);
      as.addItem(new String("L"));
      System.out.println(as);
      as.addItem(new String("Q"));
      System.out.println(as);
      as.addItem(new String("D"));
      System.out.println(as);
      as.addItem(new String("Y"));
      System.out.println(as);
      as.addItem(new String("A"));
      System.out.println(as);
   
   }

}//end of class