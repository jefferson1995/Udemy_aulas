package funcional_calc_lambda.application;

/*
    O que s]ao "expressoes lambda"?

    Em programagao funcional, expressdo lambda corresponde a uma
    fungado anônima de primeira classe.
 */


import comparator.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ExpressaoLambda {

    public static int compareProducts(Product p1, Product p2) {
        return p1.getPrice().compareTo(p2.getPrice());
    }

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Notebook", 1200.0));
        list.add(new Product("Tablet", 450.0));


        list.sort(ExpressaoLambda::compareProducts); //referência da função
        list.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice())); //lambda - funcao anônima de primeira classe

        for (Product p : list) {
            System.out.println(p.toString());
        }

    }


}
