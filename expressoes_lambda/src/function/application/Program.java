package function.application;

/*
    Function

https://docs.oracle.com/javase/10/docs/api/java/util/function/Function.html

public interface Function<T, R> {

R apply(T t);

Versoes:

* Implementagao da interface
* Reference method com método estatico
* Reference method com método nao estatico
* Expressdo lambda declarada
* Expressdo lambda inline

Nota sobre a função map

* A funcão "map" (não confunda com a estrutura de dados Map) é uma
funcão que aplica uma funcão a todos elementos de uma stream.

* Conversões:

* List para stream: . stream()

* Stream para List: .collect(Collectors.toList())


 */

import comparator.entities.Product;
import function.util.UpperCaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.0));
        list.add(new Product("HD Case", 80.90));


        /*

        //Implementagao da interface
        List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());

         */

        /*

        //Reference method com método estatico
        List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());

         */


        /*

        //Reference method com método nao estatico
        List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());

         */


        /*

        //Expressdo lambda declarada

          Function<Product, String> func = p -> p.getName().toUpperCase();
        List<String> names = list.stream().map(func).collect(Collectors.toList());

         */

        //Expressdo lambda inline

        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());


        names.forEach(System.out::println);

    }
}





















