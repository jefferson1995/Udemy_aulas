package predicate.application;

import comparator.entities.Product;
import predicate.util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
    É uma interface generica do tipo T e contém apenas um método abstrato test

    doc:
    Predicate

      https://docs.oracle.com/javase/10/docs/api/java/util/function/Predicate.html

      Versoes:
* Implementação da interface
* Reference method com método estatico
* Reference method com método nao estatico
* Expressdo lambda declarada
* Expressao lambda inline

 */
public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Notebook", 1200.0));
        list.add(new Product("Tablet", 450.0));
        list.add(new Product("HD Case", 80.90));

        //list.removeIf(x -> x.getPrice() >= 100); //expressao lambda.

        //list.removeIf(new ProductPredicate()); //atende o predicate que está na classe auxiliar

        //list.removeIf(Product::staticProductPredicate); //Reference method com método estatico

        //list.removeIf(Product::nonStaticProductPredicate); //Reference method com método nao estatico

        /*
            //Expressdo lambda declarada

        Predicate<Product> pred = p -> p.getPrice() >= 100;
        list.removeIf(pred);
         */

        list.removeIf(p -> p.getPrice() >= 100); //Expressao lambda inline

        for (Product p : list){
            System.out.println(p);
        }
    }
}
