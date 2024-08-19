import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Stack<String>s=new Stack<>();
        //add book in stack(putting booking on table after studing)
        s.push("Hindi");
        s.push("Science");
        s.push("English");
        s.push("Social Science");
        s.push("Sankrit");
        s.push("Math");
        System.out.println(s);
        
        //finding recently putting book on table
        System.out.println(s.peek());
        System.out.println();
        //putting book into bag from table
        //using while
        // while (!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        //using for each
        for (String book : s) {
            System.out.println(book);
        }
        
    }
    
}
