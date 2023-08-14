package stream.exercicio.application;

import stream.exercicio.entities.Employe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        System.out.print("Enter salary: ");
        Double salary = sc.nextDouble();



        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employe> list = new ArrayList<>();

            String line = br.readLine();

            while (line != null) {

                String[] fields = line.split(",");
                list.add(new Employe(fields[0], fields[1], Double.parseDouble(fields[2])));
                 line = br.readLine();
            }

            List<String> emails = list.stream().filter(x -> x.getSalary() > salary)
                    .map(x -> x.getEmail())
                    .sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
                    .collect(Collectors.toList());
            emails.forEach(System.out::println);

            Double sum = list.stream().filter(x -> x.getName().charAt(0) == 'M')
                    .map(x -> x.getSalary())
                    .reduce(0.0 ,(x, y) -> x + y); //Soma tudo que encontrar no valor zero

            System.out.println("Sum of salary of people whose name starts with 'M': " + sum.toString());



        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
