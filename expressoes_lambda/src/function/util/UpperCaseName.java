package function.util;

import comparator.entities.Product;

import java.util.function.Function;

public class UpperCaseName implements Function<Product, String> { //precisa referenciar a entrada e saida

    @Override
    public String apply(Product product) {
        return product.getName().toUpperCase();
    }

}
