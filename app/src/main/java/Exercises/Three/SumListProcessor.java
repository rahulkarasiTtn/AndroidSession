package Exercises.Three;

import java.util.LinkedList;

public class SumListProcessor extends AbstractListProcessor {
    @Override
    void processList(LinkedList<Integer> list) {
        int sum = 0;
//        for( int i=0; i<list.size(); i++){
//            sum  += (int) list.get(i) ;
//        }
        for (int num: list) {
            sum += num;
        }
        System.out.println("Sum of Numbers are : "+ sum);
    }

}
