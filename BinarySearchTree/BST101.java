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
   
   public BST()                        {}
   
   public BST(Object item)             { this.item = item; }
   //setter
   public void setLeft(BST left)       { this.left = left; }
   public void setRight(BST right)     { this.right = right; }
   public void setParent(BST parent)   { this.parent = parent; }
   //getter
   public Object getItem()             { 
      return item; }
   public BST getLeft()                { 
      return left; }
   public BST getRight()               { 
      return right; }
   public BST getParent()              { 
      return parent; }
   //
   public BST addNode(Object item,BST root){
      //create a new node
      BST node = new BST(item);
      
      if(root == null)  root = node;
      else{
         Comparable c = (Comparable)item;
         if(c.compareTo(root.getItem())>0){
            root.setRight(addNode(item,root.getRight()));   
         }
         else if(c.compareTo(root.getItem())<0){
            root.setLeft(addNode(item,root.getLeft()));   
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
   public void levelOrder(BST root){
      StringBuffer result = new StringBuffer();
      CircularQueue cq = new CircularQueue(10);
      CircularQueue lm = new CircularQueue(10);
   
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
   static public void main(String... args){
      BST root = null;
      root = new BST().addNode("6",root);
      root = new BST().addNode("1",root);
      root = new BST().addNode("4",root);
      root = new BST().addNode("3",root);
      root = new BST().addNode("5",root);
      root = new BST().addNode("2",root);
      root = new BST().addNode("7",root);
      root = new BST().addNode("9",root);
      root = new BST().addNode("8",root);
         
      System.out.println("Pre-Order"); new BST().preOrder(root);  
      System.out.println("\nIn-Order"); new BST().inOrder(root);  
      System.out.println("\nPost-Order"); new BST().postOrder(root); 
      System.out.println("\nLevel-Order"); new BST().levelOrder(root);  
         
   }   
}//end of class










 /*for(Object c = root;c !=null;System.out.print(root.getItem()),root = root.getRight());
         System.out.print(root.getItem()+" ");
       do{
             
              if(root.getLeft()!=null){
              // System.out.print(root.getLeft().getItem()+ " " );
                 cq.enqueue(root.getLeft().getItem());
              }
               if(root.getRight()!=null){
             //  System.out.print(root.getRight().getItem()+ " ");
                cq.enqueue(root.getRight().getItem());
               }
           
           else break;    
         
           if(root.getLeft()!=null){
            root = root.getLeft();
           // System.out.print(cq.dequeue()+ " ");
           }
           else if(root.getRight()!=null){
           root = root.getRight();
           //System.out.print(cq.dequeue()+ " ");
           }
         }while(root!=null);  
         
*/