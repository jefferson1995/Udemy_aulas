package function.funcao_recebe_outra_funcao.application;

import comparator.entities.Product;
import function.funcao_recebe_outra_funcao.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.0));

        ProductService ps = new ProductService();

        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T'); //posso adicionar qualquer condição de predicate

        System.out.println("sum = " + String.format("%.2f", sum));
    }
}
