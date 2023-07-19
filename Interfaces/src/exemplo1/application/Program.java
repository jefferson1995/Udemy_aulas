package exemplo1.application;

import exemplo1.entities.CarRental;
import exemplo1.entities.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print();
        String carModel = sc.nextLine();
        System.out.println("Retirada: (dd/MM/yyyy hh:mm: ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);  //realiza a leitura com o formato
        System.out.println("Retorno: (dd/MM/yyyy hh:mm: ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));




        sc.close();
    }
}
