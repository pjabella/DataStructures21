import java.util.*;
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
  public void rightMin(Object find,BST root){
  
      //item = find;
      root = findNode(item,root);
      
      root = root.getRight();
      if(root==null){
         System.out.print("null");
      }
      else{
      while(root!=null){
      if(root.getLeft()!=null){
         // BST min = new BST();
         // min = root.getLeft().getItem();
         root = root.getLeft();
      }
      else
         break;
      }
      
      System.out.print(root.getItem());
      }
    //  return null;
  }
  public void leftMax(Object find,BST root){
  
     // item = find;
      root = findNode(item,root);
      
      root = root.getLeft();
      if(root==null){
         System.out.print("null");
      }
      else{
      while(root!=null){
      if(root.getRight()!=null){
         // BST min = new BST();
         // min = root.getLeft().getItem();
         root = root.getRight();
      }
      else{
        break;
      }
      }  
      
      System.out.print(root.getItem());
  }
//  return null;
  }
   
   public boolean deleteNode(Object item,BST root){
   
   root = findNode(item,root);
   if(root!=null){
   
      if(root.getParent()==null){
         BST min,max = new BST();
         min = root.getLeft();
        // max = root.get
      }
   
   return true;
   }
   return false;
  
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

 
   
   static public void main(String... args){
      BST root = null;
      try{
         java.util.Scanner file = new java.util.Scanner(new java.io.File("file.in"));
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
      
      String find="4"; 
      //System.out.println("\nIte :"+find);   
      
      BST node = new BST().findNode(find,root); 
      if(node!=null){
          try{
            System.out.println("\nItem   : "+node.getItem());
            System.out.println("Parent : "+node.getParent().getItem());
           // System.out.println("Left   : "+node.getLeft().getItem());
           // System.out.println("Right  : "+node.getRight().getItem());
         }
         catch(Exception e){
            System.out.println("Parent : null");
         }
     }
     System.out.print("\nRight Min : ");new BST().rightMin(find,root);
     System.out.print("\nLeft Max : ");new BST().leftMax(find,root);
      System.out.print("\n" + new BST().deleteNode(find,root));
   }   
}//end of class