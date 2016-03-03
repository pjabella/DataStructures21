//Patrick Jason Abella
//Data Structure 2
//3:30 - 4:30 MWF
import java.util.*;

public class BinarySearch{
      
   static Scanner scan = new Scanner(System.in);
   static private Object[] items;
   static private Object find;
   private int start,end,mid;
   static private int count;
   
   public BinarySearch(Object find,Object[] items){
      ///     
      this.items = items;
      this.find = find;
                 }
   public boolean found(){
      int length = items.length;
      start = 0; end =length;
       count=0;
       do{ 
      
         mid = (start+end)/2;
            if(find.equals(items[mid])){
              return true;
           }
            else if(items[mid].toString().compareTo(find.toString())<0){
              start = mid;
              if(start==end){
               break;
              }   
            }  
            else{
              end = mid;
            }
             count++;
         }while(start!=end);
         //}
          return false;
   }
   public int position(){
   if(found()==true){
   return mid;
   }
   else 
      return -1;
   }
 
  

   static public void main(String... args){
     String[] items = {"grapes", "apple","banana","canada","grass","zebra","anaconda" };
     String find = "zebra";
     int x=0;
      int length = items.length;
      java.util.Arrays.sort(items);
      BinarySearch search =new BinarySearch(find,items);
         for(x=0;x<length;x++){
            System.out.print(items[x]);
               if(x!=length-1){
                 System.out.print(",");
                }
        }
     System.out.println();
     System.out.println("To Find : "+ find);
       if(search.position()==(-1)){
           System.out.print("Item Not Found");
        }
          else{
           System.out.println("Found : "+ search.found());
           System.out.println("Number of Loops: "+ count);
           System.out.print("Position : "+ search.position());
           }
   }

}//end of class