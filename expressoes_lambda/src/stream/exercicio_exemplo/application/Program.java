package stream.exercicio_exemplo.application;

/*
    Exercicio resolvido - filter, sorted, map, reduce
 */

/*
    Fazer um programa para ler um conjunto de produtos a partir de um
arquivo em formato .csv (suponha que exista pelo menos um produto).
Em seguida mostrar o preço médio dos produtos. Depois, mostrar os
nomes, em ordem decrescente, dos produtos que possuem preço
inferior ao preço médio.

Veja exemplo na proxima pagina.
 */

import comparator.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Product> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Double avg = list.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y) / list.size();
            System.out.println("Média dos prosdutos " + String.format("%.2f", avg));

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> names = list.stream().filter(p -> p.getPrice() < avg).map(p -> p.getName())
                    .sorted(comp.reversed())
                    .collect(Collectors.toList());

            names.forEach(System.out::println);
            System.out.println(list.size());




        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
