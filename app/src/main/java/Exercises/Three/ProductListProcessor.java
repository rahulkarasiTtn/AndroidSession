package Exercises.Three;

import java.util.LinkedList;

public class ProductListProcessor extends AbstractListProcessor{
    @Override
    void processList(LinkedList<Integer> list) {
        int product = 1;
        for( int i=0; i<list.size(); i++){
            product  *= (int) list.get(i) ;
        }
        System.out.println("Product of Numbers are : "+ product);
    }
}
