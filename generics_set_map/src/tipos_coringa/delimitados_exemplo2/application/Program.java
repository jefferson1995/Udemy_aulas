package tipos_coringa.delimitados_exemplo2.application;

import java.util.ArrayList;
import java.util.List;

public class Program {

    /*
        Vamos fazer um método que copia os elementos de uma lista para uma outra lista que pode ser
        mais genérica que a primeira.
     */
    public static void main(String[] args) {

        /*
            Princípio get/put - covariância
            -Deixa acessar os elementos
            -Inserir não é permitida
         */

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(5);

        List<? extends Number> list = intList; //Pode ser number ou qualquer subtipo

        Number x = list.get(0);

        //list.add(20);  erro de compilação, porque a lista não sabe o tipo


        /*
            Princípio get/put - contravariância
            - Não deixa Deixa acessar os elementos
            - deixa Inserir
         */

        List<Object> myObjs = new ArrayList<>();
        myObjs.add("Maria");
        myObjs.add("Alex");

        List<? super Number> myNums = myObjs; //Pode ser um number ou qualquer superTipo - no caso o Object
        //Pode adicionar qualquer valor do tipo number, objsct como string
        myNums.add(10);
        myNums.add(3.14);

        //Number x = myNums.get(0); erro de compilação - porque o tipo dessa lista pode ser um subertipo de number, no caso pode ter string





    }
}
