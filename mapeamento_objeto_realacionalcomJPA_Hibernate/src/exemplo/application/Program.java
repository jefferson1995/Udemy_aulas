package exemplo.application;

import exemplo.dominio.Pessoa;

public class Program {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Carlos Da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(1, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(1, "Maria Silva", "maria@gmail.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
