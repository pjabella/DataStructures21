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
public class BST{

   private Object item;
   private BST left;
   private BST right;
   private BST parent;
   private BST steam; 
   public BST()                        {}
   public BST(Object item)             { this.item = item; }

   //setter
   public void setLeft(BST left)       { this.left = left; }
   public void setRight(BST right)     { this.right = right; }
   public void setParent(BST parent)   { this.parent = parent; }
   public void makeItem(Object item)       { this.item = item; }

   //getter
   public Object getItem()             { return item; }
   public BST getLeft()                { return left; }
   public BST getRight()               { return right; }
   public BST getParent()              { return parent; }

   //
   public BST addNode(Object item,BST root){
      //create a new node
      BST node = new BST(item);
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
   public void preOrder(BST root){
      if(root!=null){
         System.out.print(root.getItem()+" ");
         preOrder(root.getLeft());
         preOrder(root.getRight());
      }
   }
   //in-order
   public void inOrder(BST root){
      if(root!=null){         
         inOrder(root.getLeft());
         System.out.print(root.getItem()+" ");
         inOrder(root.getRight());
      }
   }
   //post-order
   public void postOrder(BST root){
      if(root!=null){         
        postOrder(root.getLeft());     
         postOrder(root.getRight());
        System.out.print(root.getItem()+" ");
      }
   }   
  public BST rightMin(Object find,BST root){
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
  public BST leftMax(Object find,BST root){
      root = (findNode(find,root));
   try{ 
   root = root.getLeft(); 
    while(root!=null){
      if(root.getRight()!=null){root = root.getRight(); }
      else break;
      }   
   }catch(Exception e){}
  return root;
  }
  public void levelOrder(BST root){
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
      root = (BST) cq.dequeue();      
         Object res = lm.dequeue();
         if(res!=null)
         result.append(res+" ");     
      }while(root!=null);
        System.out.print(result.toString());              
   } 
   public BST findNode(Object item,BST root){
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
   public boolean deleteNode(Object item,BST root){
      BST found,min = new BST();
      found = findNode(item,root); 
       if(found!=null){
          min = found.rightMin(item,root);
             if(found.getRight()==null&&found.getLeft()==null){
               if(found.getParent().getRight()==found){ System.out.print("1.1"); found.getParent().setRight(null); }
                else{ System.out.print("1.2"); found.getParent().setLeft(null);}
         }
             else if(found.getRight()==null||found.getLeft()==null){
                if(found.getLeft()==null){
                  if(found.getParent().getRight()==found){ System.out.print("2.1"); found.getParent().setRight(found.getRight()); }
                  else{ System.out.print("2.2");found.getParent().setLeft(found.getRight()); }
                }else{ 
                 if(found.getParent().getRight()==found){ System.out.print("2.3"); found.getParent().setRight(found.getLeft());}
                  else{ System.out.print("2.4");found.getParent().setLeft(found.getLeft()); }
                }                                              
         }
            else if(found.getRight()!=null&&found.getLeft()!=null){
                  if(found.rightMin(item,root).getParent().getLeft()==found.rightMin(item,root)){ System.out.print("3.1"); found.rightMin(item,root).getParent().setLeft(found.rightMin(item,root).getRight());}
                  else{ System.out.print("3.2"); found.rightMin(item,root).getParent().setRight(found.rightMin(item,root).getRight());}        
                 found.makeItem(min.getItem());
            }
         System.out.println("\nLevel Order : ");  new BST().levelOrder(root);  
         System.out.print("\nDeleted: ");
         return true;
      }
     System.out.print("\nDeleted: "); 
     return false;
   }
   static public void main(String... args){
      BST root = null;
      try{
         java.util.Scanner file = new java.util.Scanner(new java.io.File("tree.in"));
         StringBuffer sb=new StringBuffer();
         for(;file.hasNext();sb.append(file.next()).append(","));        
         file.close();
         String[] items = sb.toString().split("\\,");
         for(int i=0;i<items.length-1;i++){
            root = new BST().addNode(items[i].toString(),root);
          }
      }
      catch(Exception e){ e.printStackTrace(); }
      System.out.println("Pre-Order"); new BST().preOrder(root);  
      System.out.println("\nIn-Order"); new BST().inOrder(root);  
      System.out.println("\nPost-Order"); new BST().postOrder(root);  
      System.out.println("\nLevel Order"); new BST().levelOrder(root);  
      String find="g"; 
        
      BST node = new BST().findNode(find,root); 
      if(node!=null){
          try{
            System.out.println("\nItem   : "+node.getItem());
            System.out.print("Parent : "+node.getParent().getItem());
           // System.out.println("Left   : "+node.getLeft().getItem());
           // System.out.println("Right  : "+node.getRight().getItem());
         }
         catch(Exception e){
            System.out.print("Parent : null");
         }
     }
         else{
            System.out.print("\n\nItem not found ");
     }
      try{
             System.out.print("\nRight Min : " +  new BST().rightMin(find,root).getItem());
           }catch(Exception e){System.out.print("\nRight Min : null");}
      try{      
             System.out.print("\nLeft Max : "+ new BST().leftMax(find,root).getItem());
      }catch(Exception e){
             System.out.print("\nLeft Max : null");
    }
             System.out.println();
    //  try{
         System.out.println(new BST().deleteNode(find,root));
     // }catch(Exception e){}                                                 
    }   
}//end of class