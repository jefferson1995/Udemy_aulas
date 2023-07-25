package exercicio_fixacao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        Integer numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        Date data = fmt.parse(sc.nextLine());
        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = sc.nextInt();


        sc.close();

    }


}
