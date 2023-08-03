package tipos_coringa.exemplo1.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        //Exemplo para uma lista aceitar qualquer tipo de dados

        List<?> myObjs = new ArrayList<>();
        List<Integer> myNumbers = new ArrayList<>();

        myObjs = myNumbers;  //Nesse caso, consigo adicionar a lista de numeros em uma lista generica


        //Exemplo
        List<Integer> myInts = Arrays.asList(5, 2 , 10);
        printList(myInts);

        //Exemplo 2 com string
        List<String> myStrs = Arrays.asList("Maria", "Alex", "Bob");
        printList(myStrs);

    }

    //Método generico -> Lembrando que não é possível adicionar na lista, porque o compilador não sabe o tipo que vai receber
    public static void printList(List<?> list){
        for(Object obj : list){
            System.out.println(obj);
        }
    }




}
