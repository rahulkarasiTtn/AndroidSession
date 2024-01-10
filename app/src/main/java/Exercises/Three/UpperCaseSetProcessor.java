package Exercises.Three;

import java.util.Locale;
import java.util.TreeSet;

public class UpperCaseSetProcessor extends AbstractSetProcessor{
    @Override
    void processSet(TreeSet<String> set) {
        TreeSet<String> upperCaseSet = new TreeSet<String>();
        for(String name: set){
            upperCaseSet.add(name.toUpperCase(Locale.ROOT));
        }
        System.out.println("upperCaseSet : "+upperCaseSet);
    }
}
