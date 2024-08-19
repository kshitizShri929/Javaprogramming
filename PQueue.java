import java.util.PriorityQueue;
import java.util.Queue;
public class PQueue {
    public static void main(String[] args) {
        
    
    Queue<String>pq=new PriorityQueue<>(); 
        //using add() method
        pq.add("fino");
        pq.add("bob");
        pq.add("sbi");

    System.out.println(pq);
     //using offer() method
     pq.offer("pnb");
     pq.offer("hdfc");
     pq.offer("idfc");
     System.out.println(pq);


     //delete using remove ()and poll()
     System.out.println(pq.remove(2));
     System.out.println("and deleted using poll ");
     System.out.println(pq.poll());

    }
}
