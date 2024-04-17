package zadanie2;

import java.util.Iterator;
import java.util.LinkedList;

public class zadanie3 {
    public static void main(String[] args) {
        // 1
        LinkedList<String> names = new LinkedList<String>();

        names.add("Anna");
        names.add("Mykhailo");
        names.add("Olia");
        names.add("Bogdan");
        names.add("Witold");
        names.add("Sofia");

        // 2
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println();

        // 3
        names.remove(2);

        // 4
        names.add(1, "New two name");
        names.add(names.size() - 1, "New five name");
        
        // 5
        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
