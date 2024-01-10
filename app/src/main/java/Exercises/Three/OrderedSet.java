package Exercises.Three;

import java.util.LinkedHashSet;

public class OrderedSet extends LinkedHashSet<String> {
    @Override
    public boolean add(String s) {
        return super.add(s);
    }
}

class OrderedSetDemo {
    public static void main(String[] args) {
        //Question-2
        OrderedSet orderedSet = new OrderedSet();
        orderedSet.add("Rahul");
        orderedSet.add("Sohit");
        orderedSet.add("Ishita");
        orderedSet.add("Ashish");
        orderedSet.add("Rahul");

        System.out.println("Attendees in Android Session:"+ orderedSet);

    }
}
