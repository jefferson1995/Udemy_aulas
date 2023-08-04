package hashCode_and_Equals.application;

import hashCode_and_Equals.entities.Client;

public class Program {

    /*
        São operações da classe Object utilizadas para comparar se um objeto é igual a outro.
     */

    public static void main(String[] args) {

        Client c1 = new Client("Maria", "maria@gmail.com");
        Client c2 = new Client("Maria", "maria@gmail.com");

        String s1 = "Test";
        String s2 = "Test";




        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));

        System.out.println(c1 == c2); //Compara a referência de memória - tem posições diferentes na memória

        System.out.println(s1 == s2); // Nesse caso é verdadeiro, o compilador trata a de forma especial o que é literais. Diferente quando instacia um obj

    }
}
