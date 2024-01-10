package Exercises.Three;

import java.util.Locale;
import java.util.TreeSet;

public class LowerCaseSetProcessor extends AbstractSetProcessor{
    @Override
    void processSet(TreeSet<String> set) {
        TreeSet<String> lowerCaseSet = new TreeSet<String>();
        for(String name: set){
            lowerCaseSet.add(name.toLowerCase(Locale.ROOT));
        }
        System.out.println("lowerCaseSet : "+lowerCaseSet);
    }
}
