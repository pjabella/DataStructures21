public class BinTree {

   private Object item;
   private BinTree left,right,parent;
   
   public BinTree()                          {}
   public BinTree(Object item)               { this.item = item; }
   ////
   public void setLeft(BinTree left)         { this.left = left; }
   public void setRight(BinTree right)       { this.right = right; }
   public void setParent(BinTree parent)     { this.parent = parent; }
   //// 
   public BinTree getLeft()                  { 
      return left; }
   public BinTree getRight()                 { 
      return right; }
   public BinTree getParent()                { 
      return parent; }
   public Object getItem()                   { 
      return item; }
   ////
   public BinTree addNode(Object item,BinTree root){
      
      BinTree node = new BinTree(item);
      if(root==null) root=node;
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
   public void levelOrder(BinTree root){
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
     
      root = (BinTree) cq.dequeue();
      
         Object res = lm.dequeue();
         if(res!=null)
         result.append(res+" ");
      
      }while(root!=null);
        System.out.print(result.toString());
              
   } 

   
   public BinTree findNode(Object item,BinTree root){
      if(root!=null){
         if(root.getItem().equals(item)) 
            return root;
         else{
            Comparable c = (Comparable)item;
            if(c.compareTo(root.getItem())>0) 
               return findNode(item,root.getRight());
            else if(c.compareTo(root.getItem())<0) 
               return findNode(item,root.getLeft());
         }
      }
      return null;
   }
   // 
//    public BinTree rightMin(Object item,BinTree root){}
//    public BinTree leftMax(Object item,BinTree root){}
//    public boolean deleteNode(Object item,BinTree root){}
//    
   public void inOrder(BinTree root){
      if(root!=null){
         inOrder(root.getLeft());
         System.out.print(root.getItem());
         try{
            System.out.print("->"+root.getParent().getItem()+"\n");
         }
         catch(Exception e){
            System.out.print("->null\n");
         }
         
         inOrder(root.getRight());
      }
   }
   
   static public void main(String... args){
      BinTree root = null;
      root = new BinTree().addNode("6",root);   
      root = new BinTree().addNode("4",root);   
      root = new BinTree().addNode("1",root);   
      root = new BinTree().addNode("3",root);   
      root = new BinTree().addNode("5",root);   
      root = new BinTree().addNode("2",root);   
      root = new BinTree().addNode("7",root);   
      
      new BinTree().inOrder(root);
      String find="1";
      System.out.println("Search for :"+find);   
      
      BinTree node = new BinTree().findNode(find,root);  
      if(node!=null){
         try{
            System.out.println("Item   : "+node.getItem());
            System.out.println("Parent : "+node.getParent().getItem());
            System.out.println("Left   : "+node.getLeft().getItem());
            System.out.println("Right  : "+node.getRight().getItem());
         }
         catch(Exception e){
            System.out.println("-->null");
         }
         System.out.println("\nLevel Order"); new BinTree().levelOrder(root);
      }
      
   }
}//end of class