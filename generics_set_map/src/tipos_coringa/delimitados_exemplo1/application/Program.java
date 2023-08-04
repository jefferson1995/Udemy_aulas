package tipos_coringa.delimitados_exemplo1.application;

import tipos_coringa.delimitados_exemplo1.entities.Circle;
import tipos_coringa.delimitados_exemplo1.entities.Rectangle;
import tipos_coringa.delimitados_exemplo1.entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCicles = new ArrayList<>();
        myCicles.add(new Circle(2.0));
        myCicles.add(new Circle(3.0));



        System.out.println("Total area: " + totalArea(myCicles));

    }

    /*
        Nesse caso, pode ser uma lista de Shape ou qualquer subtipo dele
        exemplo: irá aceitar uma lista de circle no método
        Obs.: Não é possível adicionar dentro da lista
     */
    public static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }
}
