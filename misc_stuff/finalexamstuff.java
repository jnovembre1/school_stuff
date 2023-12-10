package misc_stuff;

import java.util.Queue;
import java.util.LinkedList;

public class finalexamstuff {
    public static void main(String args [] ) {
        Queue<String> queue = new LinkedList<>();
        queue.add("hi");
        queue.add("yo");
        queue.add("hiii");
        queue.add("jka");
        queue.add("fkal");
        queue.remove();
        queue.remove();
        queue.remove();
        queue.add("yogjs");
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println(queue.size());
    }
    
}
