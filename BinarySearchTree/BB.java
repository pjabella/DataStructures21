class TNode{
   public TNode left;
   public TNode right;
   public int data;
   public TNode(int i){
      left = null;
      right = null;
      data = i;
   }
   public void insert(int d){
   if (d < data){
         if (left == null)
         left = new TNode(d);
         else
         left.insert(d);
     }
   else
      if (d > data) {
         if (right == null)
         right= new TNode(d);
            else
            right.insert(d);
      }
}

}
public class BB{

   private Object item;
   private BB left;
   private BB right;
   private BB parent;
   private BB steam; 
   public BB()                        {}
   public BB(Object item)             { this.item = item; }

   //setter
   public void setLeft(BB left)       { this.left = left; }
   public void setRight(BB right)     { this.right = right; }  
   public void setParent(BB parent)   { this.parent = parent; }
   public void makeItem(Object item)       { this.item = item; }

   //getter
   public Object getItem()             { return item; }
   public BB getLeft()                { return left; }
   public BB getRight()               { return right; }
   public BB getParent()              { return parent; }

   //
   public BB addNode(Object item,BB root){
      //create a new node
      BB node = new BB(item);
      if(root == null)  root = node;
      else{
         Comparable c = (Comparable)item;
         if(c.compareTo(root.getItem())>0){
            root.setRight(addNode(item,root.getRight()));   
            root.getRight().setParent(root);
         }
         else if(c.compareTo(root.getItem())<0){
            root.setLeft(addNode(item,root.getLeft()));  
            root.getLeft().setParent(root); 
         }
      }      
      //return the updated root
      return root;
   }
   //pre-order
   public void preOrder(BB root){
      if(root!=null){
         System.out.print(root.getItem()+" ");
         preOrder(root.getLeft());
         preOrder(root.getRight());
      }
   }
   //in-order
   public void inOrder(BB root){
      if(root!=null){         
         inOrder(root.getLeft());
         System.out.print(root.getItem()+" ");
         inOrder(root.getRight());
      }
   }
   //post-order
   public void postOrder(BB root){
      if(root!=null){         
        postOrder(root.getLeft());     
         postOrder(root.getRight());
        System.out.print(root.getItem()+" ");
      }
   }   
  public BB rightMin(Object find,BB root){
      root = (findNode(find,root));
     try{ 
       root = root.getRight();
       while(root!=null){
      if(root.getLeft()!=null){root = root.getLeft(); }
      else break;
      }
      }  catch(Exception e){ 
      }
      return root;
  }
  public BB leftMax(Object find,BB root){
        root = (findNode(find,root));
   try{ 
   root = root.getLeft(); 
    while(root!=null){
      if(root.getRight()!=null){root = root.getRight(); }
      else break;
      }   
   }catch(Exception e){}
  return root;
  }  public void levelOrder(BB root){
   StringBuffer result = new StringBuffer();
   CircularQueue cq = new CircularQueue();
   CircularQueue lm = new CircularQueue();   
      System.out.print(root.getItem()+ " ");
      do{   
      if(root.getLeft()!=null){
         cq.enqueue(root.getLeft());
         lm.enqueue(root.getLeft().getItem());
      }
      if(root.getRight()!=null){
         cq.enqueue(root.getRight());
         lm.enqueue(root.getRight().getItem());
      }     
      root = (BB) cq.dequeue();      
         Object res = lm.dequeue();
         if(res!=null)
         result.append(res+" ");     
      }while(root!=null);
        System.out.print(result.toString());              
   } 
   public BB findNode(Object item,BB root){
      if(root!=null){
         if(root.getItem().equals(item)){
          return root;
          }
         else{
            Comparable c = (Comparable)item;
            if(c.compareTo(root.getItem())>0) return findNode(item,root.getRight());
            else if(c.compareTo(root.getItem())<0) return findNode(item,root.getLeft());
         }
      }
      return null;
   }
   public boolean deleteNode(Object item,BB root){
      BB found,min,max = new BB();
      found = findNode(item,root); 
      if(found!=null){
          min = found.rightMin(item,root); max = found.leftMax(item,root);
          if(found.rightMin(item,root)!=null){
            if(found.rightMin(item,root).getParent().getLeft()==found.rightMin(item,root)){ System.out.print("1.1"); found.rightMin(item,root).getParent().setLeft(found.rightMin(item,root).getRight());}
               else{ System.out.print("1.2"); found.rightMin(item,root).getParent().setRight(found.rightMin(item,root).getRight());}        
               found.makeItem(min.getItem());  
            }
            else if(found.leftMax(item,root)!=null){
             if(found.leftMax(item,root).getParent().getLeft()==found.leftMax(item,root)){ System.out.print("2.1"); found.leftMax(item,root).getParent().setLeft(found.leftMax(item,root).getRight());}
               else{ System.out.print("2.2"); found.leftMax(item,root).getParent().setRight(found.leftMax(item,root).getRight());}        
               found.makeItem(max.getItem());  
            }
            else {
             if(found.getParent().getRight()==found){ System.out.print("3.1"); found.getParent().setRight(null); }
                else{ System.out.print("3.2"); found.getParent().setLeft(null);}
            }
         //System.out.println("\nLevel Order"); new BB().levelOrder(root);  
         return true;
      } 
     return false;
   }
   static public void main(String... args){
      BB root = null;
      CircularQueue gg = new CircularQueue();   
      try{
         java.util.Scanner file = new java.util.Scanner(new java.io.File("tree.in"));
         StringBuffer sb=new StringBuffer();
         for(;file.hasNext();sb.append(file.next()).append(","));        
         file.close();
         String[] items = sb.toString().split("\\,");
         for(int i=0;i<items.length-1;i++){

            if(items[i].equals("3")){
               break;
               }
            else if(items[i].equals("2")){
               break;
            }
            else if(items[i].equals("1")){
               break;
            } 
           root = new BB().addNode(items[i].toString(),root);
          }
          for(int i=0;i<items.length-1;i++){
            
            if(items[i].equals("3")){
               gg.enqueue(items[i]);
               }
            else if(items[i].equals("2")){
               gg.enqueue(items[i]);
               gg.enqueue(items[i+1]);
            }
            else if(items[i].equals("1")){
               gg.enqueue(items[i]);
               gg.enqueue(items[i+1]);
            }
       } 
      }
      catch(Exception e){ e.printStackTrace(); }
      int x =0;
      while(gg.peek()!=null){
         Object tems = gg.dequeue();
         if(tems.equals("3")){
            System.out.println("------------------------------"); 
            System.out.println(); 
            System.out.println("Pre-Order"); new BB().preOrder(root);  
            System.out.println("\nIn-Order"); new BB().inOrder(root);  
            System.out.println("\nPost-Order"); new BB().postOrder(root);  
            System.out.println("\nLevel Order"); new BB().levelOrder(root);  
            System.out.println();
         }
         else if(tems.equals("1")){
           Object find= gg.dequeue();
            
            System.out.println("------------------------------");
               BB node = new BB().findNode(find,root); 
               if(node!=null){
                   try{
                     System.out.println("\nItem   : "+node.getItem());
                     System.out.println("Parent : "+node.getParent().getItem());
                     System.out.println("Left   : "+node.getLeft().getItem());
                     System.out.println("Right  : "+node.getRight().getItem());
                  }
                  catch(Exception e){
                     System.out.println("Parent : null");
                        }
                    }
                        else{
                           System.out.print("\n\nItem not found ");
                    }
                        try{
                            System.out.print("\nRight Min : " +  new BB().rightMin(find,root).getItem());
                           }catch(Exception e){ System.out.print("\nRight Min : null");
                           }
                        try{      
                            System.out.println("\nLeft Max : "+ new BB().leftMax(find,root).getItem());
                           }catch(Exception e){ System.out.print("\nLeft Max : null"); 
                           }
                                  
          }
      
         
         else if(tems.equals("2")){
         Object del = gg.dequeue();
                    System.out.println();
                    System.out.println("------------------------------");
         System.out.println("\nto be deleted : "+del);           
         System.out.println("\nDeleted: " + new BB().deleteNode(del,root));     
         }
        x++;   
       }                              
    }   
}//end of class