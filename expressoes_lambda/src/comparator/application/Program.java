package comparator.application;

import comparator.entities.Product;

import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    Comparator<T> é uma interface funcional
    Funcional tem apenas um método abstrato - hoje tem outros métodos

    Resumo da aula

* Comparator objeto de classe separada
* Comparator objeto de classe anônima
* Comparator objeto de expressdo lambda com chaves
* Comparator objeto de expressdo lambda sem chaves
* Comparator expressdo lambda "direto no argumento"

 */

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Notebook", 1200.0));
        list.add(new Product("Tablet", 450.0));

        /*
            //Outro exemplo para comparar - Utilizado como classe anônima

            Comparator<Product> comp = new Comparator<Product>(){

            @Override
            public int compare(Product p1, Product p2){
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            }

            };

         */

        //list.sort(new MyComparator()); //criando classe
        //list.sort(comp); // Classe anonima


        //Utilizando expressão lambda - função anonima

        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase())); //lambda


        for (Product p : list) {
            System.out.println(p);
        }


    }
}
