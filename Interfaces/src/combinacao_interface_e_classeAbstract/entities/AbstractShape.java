package combinacao_interface_e_classeAbstract.entities;

import enums.Color;
/*
    Se torna abstract para não ter que implementar o método area da interface
 */
public abstract class AbstractShape implements Shape {

    private Color color;

    public AbstractShape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
