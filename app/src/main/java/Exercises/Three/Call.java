package Exercises.Three;

import java.util.LinkedList;
import java.util.TreeSet;

public class Call {
    public static void main(String[] args) {
        //Question-1
        LinkedList<Integer> listOfNumbers =new LinkedList<Integer>();
        listOfNumbers.add(10);
        listOfNumbers.add(20);
        listOfNumbers.add(30);
        listOfNumbers.add(40);
        listOfNumbers.add(10);
        //System.out.println(listOfNumbers);
        SumListProcessor sumListProcessor = new SumListProcessor();
        ProductListProcessor productListProcessor = new ProductListProcessor();
        sumListProcessor.processList(listOfNumbers);

        //Question-5
        TreeSet<String> nameSet = new TreeSet<String>();
        nameSet.add("Rahul");
        nameSet.add("Jasmin");
        nameSet.add("Ishita");
        nameSet.add("Sohit");
        nameSet.add("Pankaj");

        UpperCaseSetProcessor upperCaseSetProcessor = new UpperCaseSetProcessor();
        LowerCaseSetProcessor lowerCaseSetProcessor = new LowerCaseSetProcessor();
        upperCaseSetProcessor.processSet(nameSet);
        lowerCaseSetProcessor.processSet(nameSet);
    }
}
