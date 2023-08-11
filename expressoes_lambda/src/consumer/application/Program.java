package consumer.application;

/*
    Consumer (exemplo com forEach)

    Versoes:

* Implementacao da interface
* Reference,method com método estatico
* Reference method com método nao estatico
* Expressdo lambda declarada
* Expressdo lambda inline

Consumer

https://docs.oracle.com/javase/10/docs/api/java/util/function/Consumer.html

public interface Consumer<T> {

void accept(T %)5
}

 */

import comparator.entities.Product;
import consumer.util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.0));
        list.add(new Product("HD Case", 80.90));

        //list.forEach(new PriceUpdate()); //Implementacao da interface

        //list.forEach(Product::staticPriceUpdate); //Reference,method com método estatico

        //list.forEach(Product::nonStaticPriceUpdate);//Reference method com método nao estatico


        //Expressdo lambda declarada
        /*

        Consumer<Product> cons = p -> {
            p.setPrice(p.getPrice() * 1.1);
        };

        list.forEach(cons);

         */

        //Expressdo lambda inline
        list.forEach(p -> p.setPrice(p.getPrice()));


        list.forEach(System.out::println);
    }

}

























