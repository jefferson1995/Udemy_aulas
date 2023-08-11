package function.funcao_recebe_outra_funcao.services;

import comparator.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filteredSum(List<Product> list, Predicate<Product> criteria){ //Adiciona um predicate como parametro

        double sum = 0.0;

        for (Product p : list){
            if(criteria.test(p)){
                sum += p.getPrice();
            }
        }
        return sum;
    }
}
