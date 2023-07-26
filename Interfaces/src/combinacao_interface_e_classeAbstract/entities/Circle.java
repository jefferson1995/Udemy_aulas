package combinacao_interface_e_classeAbstract.entities;

import enums.Color;

public class Circle extends AbstractShape {

    private Double radius;

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    //Método da interface Shape
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
