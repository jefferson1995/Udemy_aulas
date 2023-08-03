package delimitados.services;

import java.util.List;

public class CalculationService {

    /*
        Explicação:
        Este método vai trabalhar com qualquer tipo T ->
        Desde que o T seja qualquer subtipo de uma Compable T e o supert qualquer super classe dela

        prática = extendends o comparação de produto ou qualquer super classe dela

        Nesse caso fica uma chamado generica para este método

     */
    public static <T extends Comparable<? super T>> T max(List<T> list){
        if(list.isEmpty()){
            throw new IllegalStateException("List can't be empty");
        }

        T max = list.get(0);
        for(T item : list){
            if(item.compareTo(max) > 0){
                max = item;
            }
        }
        return max;
    }
}
