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
     BST min,tnode,max,Rnode,Lnode,parent,mode = new BST();
     BST found, rfound,lfound = new BST();
     found  = root.findNode(item, root);
     parent = found.getParent();
     Rnode = found.getRight();  //LR
     Lnode = found.getLeft();
     if(found!=null){
      if(found.getLeft()==null&&found.getRight()==null){
         System.out.print("case1");
         Object par = parent.getItem();
         Object home = found.getItem();
            Comparable c = (Comparable) home;
               if(c.compareTo(par)>0){
                  parent.setRight(null);
               }
                else parent.setLeft(null);
                
     }
      else if(found.getParent()!=null){     
            if(found.getRight()==null&&parent.getLeft()==found){ 
                System.out.print("case2.1");
                parent.setLeft(Lnode);
            }
            else if(found.getLeft()==null&&parent.getRight()==found){
              System.out.print("case 2.2");
               parent.setRight(Rnode); 
            }
            else if(found.getRight()==null&&parent.getRight()==found){
                max = found.leftMax(item,root);
                System.out.print("case 2.3");
               //parent.setRight(Lnode);
                if(Lnode==max){
               System.out.print("case 2.3 else");
               parent.setRight(max);
                  }
                else if(Rnode.getLeft()!=null&&Rnode.getRight()!=null){
                 System.out.print("case 2.3 if");
                                parent.setRight(max);
                max.setLeft(Lnode);
                tnode = max.getParent();
                       Object ttnode = tnode.getItem();
                        Object mini = max.getItem();
                           Comparable d = (Comparable) mini;
                              if(d.compareTo(ttnode)>0){
                                 //right
                                 tnode.setRight(null);
                              }
                              else tnode.setLeft(null);
               }
                                            
            }
            else if(found.getLeft()==null&&parent.getLeft()==found){
                min = found.rightMin(item,root);
                if(Rnode.getRight()!=null&&Rnode.getLeft()!=null){
                System.out.print("case 2.5");
                parent.setLeft(min);
                //if(min.getRight()!=null){
                min.setRight(Rnode);                
                //}
              //  if(Rnode.getLeft()!=null)
                tnode = min.getParent();
                        Object ttnode = tnode.getItem();
                        Object mini = min.getItem();
                           Comparable d = (Comparable) mini;
                              if(d.compareTo(ttnode)>0){
                                 //right
                                 tnode.setRight(null);
                              }
                              else tnode.setLeft(null);
                   }
               else if(Rnode==min){
               parent.setLeft(min);
               }
                  
            }
              
            else if(parent.getLeft()==null||parent.getRight()==null){
               if(found.getLeft()!=null&&found.getRight()!=null){
              System.out.print("case 2.6");
               min = found.rightMin(item,root);
                  tnode = min.getParent();
                  parent.setRight(min);
                  min.setLeft(Lnode);
                  if(Rnode!=min){
                  min.setRight(Rnode);
                  }
                  else{min.setRight(null);}
                 /* Object par = parent.getItem();
                  Object rot = found.getItem();
                     Comparable c = (Comparable) par;
                     if(c.compareTo(rot)>0){ //Right
                         //parent.setLeft(min);parent.setRight(Lnode);
                                                  //min.setParent(parent); Lnode.setParent(min); Rnode.setParent(min); 
                     }
                     else{ //parent.setRight(min); parent.setLeft(Lnode); 
                        
                     }*/
                        //left
                        Object ttnode = tnode.getItem();
                        Object mini = min.getItem();
                           Comparable d = (Comparable) mini;
                              if(d.compareTo(ttnode)>0){
                                 //right
                                 tnode.setRight(null);
                              }
                              else tnode.setLeft(null);
                            
              }                 
                
        
      
      
      }
      else if(parent.getLeft()!=null&&parent.getRight()!=null){
            //   found  = root.findNode(item, root);
//               parent = found.getParent();
//               Rnode = found.getRight();  //LR
//               Lnode = found.getLeft();
            int id = 0;
            System.out.print("case 2.7");
            if(found.getRight()!=null){
            min = found.rightMin(item,root);
            tnode = min.getParent();
            //max = min.getRight();
                  Object par = parent.getItem();
                  Object rot = found.getItem();
                     Comparable c = (Comparable) par;
                     if(c.compareTo(rot)>0){ //Right
                         parent.setLeft(min);
                          }
                     else{ parent.setRight(min);}
                     min.setLeft(Lnode);
                    //  if(min.getRight()!=null){
//                         Object mini = mini.getItem();
//                         Object ttnode = tnode.getItem();
//                      }
                     Object ttnode = tnode.getItem();
                        Object mini = min.getItem();
                           Comparable d = (Comparable) mini;
                              if(d.compareTo(ttnode)>0){
                                 System.out.print("if case 2.7.2");
                                 // if(min.getRight()!=null){tnode.setLeft(min.getRight());}
//                                  else
                                 tnode.setRight(null);
                                 
                                 //tnode.setRight(min.getRight());
                              }
                              //else
                                else{  tnode.setLeft(null); System.out.print("case 2.7.3"+ tnode.getItem()); tnode.setLeft(min.getRight()); }
                               
                                if(min.getRight()==null){  min.setRight(Rnode); }
                      //proble with p (line 328 )if with (n, o) if(min.getRight()==null)
      //problem with m(line 328) if with(p,z)  if(min.getRight()!=null)        
      }
     else if(found.getRight()==null){
      max = found.leftMax(item,root);
            tnode = max.getParent();
            //max = min.getRight();
                  Object par = parent.getItem();
                  Object rot = found.getItem();
                     Comparable c = (Comparable) par;
                     if(c.compareTo(rot)>0){ //Right
                         parent.setLeft(max);
                          }
                     else{ parent.setRight(max);}
                   /*set*/  max.setLeft(Lnode);
                    //  if(min.getRight()!=null){
//                         Object mini = mini.getItem();
//                         Object ttnode = tnode.getItem();
//                      }
                     Object ttnode = tnode.getItem();
                        Object mini = max.getItem();
                           Comparable d = (Comparable) mini;
                              if(d.compareTo(ttnode)>0){
                                 System.out.print("if case 2.7.2/2");
                                 // if(min.getRight()!=null){tnode.setLeft(min.getRight());}
//                                  else
                                 tnode.setRight(null);
                                 //tnode.setRight(min.getRight());
                              }
                              //else
                                else{  tnode.setLeft(null); System.out.print("case 2.7.3/3"+ tnode.getItem()); tnode.setLeft(max.getRight()); }
                               
                                if(max.getRight()!=null){ max.setRight(Rnode); }
      }
                                      
      }
      }
      else if(found.getParent()==null){
         System.out.print("Case 3");
         min = found.rightMin(item,root);
         tnode = min.getParent();
         min.setLeft(root.getLeft());
         min.setRight(root.getRight());
                        Object ttnode = tnode.getItem();
                        Object mini = min.getItem();
                           Comparable d = (Comparable) mini;
                              if(d.compareTo(ttnode)>0){
                                 //right
                                 tnode.setRight(null);
                              }
                              else{ tnode.setLeft(null);}
         root=min;
       }                            
      
       mode = root;
        while(mode.getParent()!=null){
            if(mode.getParent() == null) break;
            mode = mode.getParent();
            }
             System.out.println("\nLevel Order"); levelOrder(root); 

     return true;
     }
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

      String find="m"; 
      //proble with p (line 328 )if with (n, o)
      //problem with m(line 328) if with(p,z)
      // problem with m (line 196) if without(p,z)
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
      try{
         System.out.println(new BST().deleteNode(find,root));
      }catch(Exception e){
         
      }
                          

     

    }

       
//line 328 case 2.7.2
}//end of class