package aplicativo;

import dominio.Pessoa;

public class Main {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Carlos Da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(1, "Maria Da Silva", "maria@gmail.com");
        Pessoa p3 = new Pessoa(1, "Pedro Da Silva", "pedro@gmail.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

}
