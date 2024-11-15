package comparator.entities;

public class Product {

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static boolean staticProductPredicate(Product p) {
        return p.getPrice() >= 100;
    }

    public boolean nonStaticProductPredicate() { //Trabalha com os proprios argumentos do objto
        return price >= 100;
    }

    /*
        Exemplo consumer
     */

    public static void staticPriceUpdate(Product p) {
        p.setPrice(p.getPrice() * 1.1);
    }

    public void nonStaticPriceUpdate() {
        setPrice(getPrice() * 1.1);
    }


    /*
        Function exemplos
     */
    public static String staticUpperCaseName(Product p){
        return p.getName().toUpperCase();
    }

    public String nonStaticUpperCaseName(){
        return name.toUpperCase();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
