package tipos_coringa.delimitados_exemplo2.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program2 {

    //Exemplo para realizar a cópia de listas

    public static void main(String[] args) {

        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<>();

        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles, myObjs);
        System.out.println(myObjs);

    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny){  //(Contravariância)Lista de destino qualquer que seja supertipo de Number -> exemplo Object

        for (Number number : source){
            destiny.add(number);
        }

    }

    //Método para imprimir uma lista

    public static void printList(List<?> list){
        for(Object obj : list){
            System.out.print(obj + " ");
        }
        System.out.println();
    }



}
