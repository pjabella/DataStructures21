public class MST{
//Patrick Jason Abella1
   static StringBuffer e=new StringBuffer();
   static StringBuffer v=new StringBuffer();
   static int referal=0;

   public static int getsize(){
      int z=0;
      try{
      java.util.Scanner file = new java.util.Scanner(new java.io.File("msst.in"));
       while(file.hasNext()){
         file.hasNext();
         if(z<1){
         v.append(file.next()).append(",");
         }
         else if(z>1){
         e.append(file.next()).append(",");
         }
         z++;
         }
      }catch(Exception e){e.printStackTrace();} 
      return z-3;
   }
   public static int getE(){
      int c=0,d=0;
      String[] samp = v.toString().split("\\,");
      d = samp.length;
      return d;
   }
  //Patrick Jason Abella2 
//Patrick Jason Abella3
 //Patrick Jason Abella4  
//Patrick Jason Abella5
   public static void main(String...args){
      int vsize = 4;
      int size = getsize();
      int esize = getE();
      String[][] err = new String[size][3];
      String[][] ihap = new String[esize][2];
      String[][] mst = new String[size][vsize];
      String[][] mstf = new String[size][vsize];
      String[] name = new String[esize];
      Object[] vertices = new Object[esize]; 
      try{
         String[] names = v.toString().split("\\,");
         for(int i=0;i<esize;i++){
            if(names[i].compareTo("0")<=-1){System.out.print("Invalid NOde(<0)");referal++;break;}     
            name[i] = names[i];      
         }
         String[]  items= e.toString().split("\\,");
         int x=0;
         boolean isElement=false,isElem=false;
         for(int j=0; j<items.length-1;j=j+3){
             
              if(items[j].equals(items[j+1])){System.out.print("Invalid Input");referal++;}
                else if(items[j+2].compareTo("0")<=-1||items[j+1].compareTo("0")<=-1||items[j+1].compareTo("0")<=-1){System.out.print("Invalid NOde or Cost(<0)");referal++;}
                   for(int z=0;z<esize;z++){
                        if(items[j].equals(name[z])){
                           isElement= true;
                        }
                        else if(items[j+1].equals(name[z])){
                           isElem = true;
                        }
                     }
                   if(isElement==true&&isElem==true){
                   mst[x][0] = x+"";
                   mst[x][1] = items[j];
                   mst[x][2] = items[(j+1)];
                   mst[x][3] = items[(j+2)];//Patrick Jason Abella6
                       /* if(x>1)//Patrick Jason Abella7
                           for(int l=0;l<=x-1;l++){
                              if(mst[x][3].compareTo(mst[l][3])>0){
                                 mst[l][4] = mst[x][0];
                                 }//Patrick Jason Abella8
                           }*/
                   }
                   else{
                     System.out.print("Some nodes are not on the Vertices");referal++;
                   } //Patrick Jason Abella9         
         x++;
         }//Patrick Jason Abella10
      } catch(Exception e){ e.printStackTrace(); }
      if(referal==0){
        for(int i=1;i<size;i++){
         Object temp2 = mst[i][2];
         Object temp3 = mst[i][1];
         Object temp = mst[i][3];
         Comparable c = (Comparable)temp;
         int j;
            for(j=i-1;j>=0&&(c.compareTo(mst[j][3])<0);j--){
            mst[(j+1)][3] = mst[j][3];
            mst[(j+1)][2] = mst[j][2];
            mst[(j+1)][1] = mst[j][1];
            }
            mst[j+1][1] = temp3+"";
            mst[j+1][2] = temp2+"";
            mst[j+1][3] = temp+"";
         }
        for(int t=0;t<esize;t++){
        vertices[t]= name[t];
        ihap[t][0]= name[t];
        ihap[t][1]= "";
        }//Patrick Jason Abella11
        int mm = esize;
        int count =0;
         //int ehap =0;
        for(int aa=0;aa<size;aa++){
         for(int bb=0;bb<esize;bb++){
               if(mst[aa][1].equals(vertices[bb])){
                  vertices[bb] = null;
                     for(int ab=0;ab<esize;ab++){
                        if(mst[aa][2].equals(vertices[ab])){
                           vertices[ab] = null;
                           //ihap[ab][1] = ihap[ab][1]+1;
                         }
                        }
                  mm=mm-1;
                  mstf[count][0] = count+"";
                  mstf[count][1] = mst[aa][1];
                  mstf[count][2] = mst[aa][2];
                  mstf[count][3] = mst[aa][3];
                  //ihap[bb][1] = ihap[bb][1]+1;
                  count++;
                  break;
                  }
                else if(mst[aa][2].equals(vertices[bb])){
                    vertices[bb] = null;
                  for(int ab=0;ab<esize;ab++){
                        if(mst[aa][1].equals(vertices[ab])){
                           vertices[ab] = null;
                           
                          }
                        }//Patrick Jason Abella12
                  mm=mm-1;
                  mstf[count][0] = count+"";
                  mstf[count][1] = mst[aa][1];
                  mstf[count][2] = mst[aa][2];
                  mstf[count][3] = mst[aa][3];
                  //ihap[bb][1] = ihap[bb][1]+1;
                  count++;
                  break;
               }
//Patrick Jason Abella13       
               if(mm<=0){
               break;
               }
 //Patrick Jason Abella 14             
            }
        }
        int mm2 = esize;
         for(int aa=0;aa<size;aa++){
         for(int bb=0;bb<esize;bb++){
               if(mstf[aa][1]==null){
                  break;
               }
               if(mstf[aa][1].equals(name[bb])){
                    for(int ab=0;ab<esize;ab++){
                           if(mstf[aa][2].equals(name[ab])){
                              ihap[ab][1] = ihap[ab][1]+1;
                           }
                     }
                  ihap[bb][1] = ihap[bb][1]+1;
                  break;
                  }
      
                  if(mstf[aa][2].equals(name[bb])){
                      for(int ab=0;ab<esize;ab++){
                           if(mstf[aa][1].equals(name[ab])){
                                ihap[ab][1] = ihap[ab][1]+1;
                           }
                      }
                  ihap[bb][1] = ihap[bb][1]+1;
                  break;
                  }
               }
            }
//Patrick Jason Abella15     
//Patrick Jason Abella16     
                int cc =0;
            for(int aa=0;aa<size;aa++){
                  if(mstf[aa][1]!=mst[aa][1]&&mstf[aa][2]!=mst[aa][2]){
                     err[cc][0] = mst[aa][1];
                     err[cc][1] = mst[aa][2];
                     err[cc][2] = mst[aa][3];
                  cc++;
                  }
            }
            if(count>=esize-2){
            int ct=0;
            System.out.print("hanging->backtrack\n");
                for(int aa=count;aa<esize-1;aa++){
                   
                     mstf[aa][1] =err[ct][0];
                     mstf[aa][2] =err[ct][1];
                     mstf[aa][3] =err[ct][2];
                   ct++;
                }
        }
//Patrick Jason Abella17
//Patrick Jason Abella18                           
        System.out.print("Vertices: ");
        for(int ee=0;ee<esize;ee++){
            System.out.print(name[ee]);
            if(ee<esize-1){System.out.print(",");}
        }
        System.out.println();
      int[]total = new int[mstf.length];
      System.out.printf("Edges:\n"); 
      for(int j=0; j<esize-1;j++){
         System.out.print(" \t");
         for(int i=1; i<4; i++ ){
            if(mstf[j][i]!=null){
            System.out.printf(mstf[j][i]);
            System.out.print(i==1 ? "," : i==2 ? " (" : i==3? ")" : "" );
            total[j] = Integer.parseInt(mstf[j][3]);
          }
            else  System.out.print("");
//Patrick Jason Abella19
         }
//Patrick Jason Abella20        
         System.out.println();
      }
      System.out.println();
      int msttotal=0;
      for(int tt=0;tt<esize-1;tt++){
         if(total[tt]!=0){
            msttotal = msttotal+total[tt];
         }
      }
      System.out.print("Total Cost : " + msttotal+"\n");
      
    /*  for(int j=0; j<esize;j++){
         for(int i=0; i<2; i++ ){
            System.out.printf(ihap[j][i]);
            if(i==0){System.out.print("->");}
//Patrick Jason Abella21
         }
//Patrick Jason Abella22         
         System.out.println();
      }*/
//Patrick Jason Abella23
   }
//Patrick Jason Abella24   
   }      
//Patrick Jason Abella25
 //Patrick Jason Abella26  
}