import java.util.LinkedList;//ArrayList
import java.util.Collections;

class ArrayLists{
    public static void main(String[] args) {
      LinkedList<Integer> list =new LinkedList<>() ;
      //ArrayList<String>list2=new ArrayList<>();
      list.add(0);
      list.add(2);
      list.add(3);

      System.out.println(list);
//get element
      int element=list.get(0);
      System.out.println(element);
      //add e1 in between
      list.add(1,1);
      System.out.println(list);

     //set element
     list.set(0,5);
     System.out.println(list);
     //delete
     list.remove(3);
     System.out.println(list);
     //size
     int Size=list.size();
     System.out.println(Size);
     //loop
     for(int i=0;i<list.size();i++)
     System.out.println(list.get(i));

     //sorting
     Collections.sort(list);
     System.out.println(list);
    }
}