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
  public BST rightMin(Object find,BST root){
  
      item = find;
      root = (findNode(item,root));
     try{ 
       root = root.getRight();
       while(root!=null){
      if(root.getLeft()!=null){
         // BST min = new BST();
         // min = root.getLeft().getItem();
         root = root.getLeft();
      }
      else
         break;
      }
     // System.out.print(root.getItem());
      }  catch(Exception e){
      System.out.print("null");  
      }

      return root;
  }
  public BST leftMax(Object find,BST root){
  
      item = find;
      root = (findNode(item,root));
      try{      
      root = root.getLeft();

      while(root!=null){
      if(root.getRight()!=null){
         root = root.getRight();
      }
      else{
        break;
      }
      }  
      
    //  System.out.print(root.getItem());
   }catch(Exception e){
   System.out.print("null");  
   }
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
     BST min,tnode,max,LRnode,parent,mode = new BST();
     root  = findNode(item, root);
     tnode = root;
     parent =  root;
     if(root!=null){
      if(root.getLeft()==null&&root.getRight()==null){
         parent = root.getParent();
         Object par = parent.getItem();
         Object home = root.getItem();
            Comparable c = (Comparable) home;
               if(c.compareTo(par)>0){
                  parent.setRight(null);
               }
                else parent.setLeft(null);
         
     }
      else if(root.getParent()!=null){     
             parent = root.getParent();
            if(root.getRight()==null){ 
                LRnode = root.getLeft();
                parent.setLeft(LRnode);
            }
            else if(root.getLeft()==null){
               LRnode = root.getRight();
               parent.setRight(LRnode);
            }
            else if(root.getLeft()!=null&&root.getRight()!=null){
               min = root.rightMin(item,root);
             /*  LRnode = root.getRight();  
                  tnode = min.getParent();
                  Object par = parent.getItem();
                  Object rot = root.getItem();
                     Comparable c = (Comparable) par;
                     if(c.compareTo(rot)>0){
                        //Right
                           parent.setRight(min);
                     }
                     else parent.setLeft(min);
                        //left
                        Object ttnode = tnode.getItem();
                        Object mini = min.getItem();
                           Comparable d = (Comparable) mini;
                              if(d.compareTo(ttnode)>0){
                                 //right
                                 tnode.setRight(null);
                              }
                              else tnode.setLeft(null);
                           
                           root = null;*/
                     root =       
            }        
            
      }
       mode = parent;
        while(mode.getParent()!=null){
            if(mode.getParent() == null) break;
            mode = mode.getParent();
            }
              
             System.out.println("\nLevel Order"); levelOrder(mode); 
      
     return true;
     }
     return false;
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
         System.out.println(new BST().deleteNode(find,root));
                          
     
    }
       
}//end of class