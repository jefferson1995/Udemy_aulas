package funcional_calc_lambda.application;

import java.util.Arrays;

/*
    Transparência referencial
    Uma função possui transparência referencial se seu resultado for sempre o mesmo
    para os mesmos dados de entrada. Benefícios: simplicidade e previsibilidade.
 */

public class Program {

    /*
    Exemplo de função que não é referencialmente transparente
 */
    public static int globalValue = 3;

    public static void main(String[] args) {

        //Depende da variável global para mudar o resultado
        int[] vect = new int[]{3, 4, 5};
        changeOddValues(vect);
        System.out.println(Arrays.toString(vect));
    }

    public static void changeOddValues(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                numbers[i] += globalValue;
            }
        }
    }
}

