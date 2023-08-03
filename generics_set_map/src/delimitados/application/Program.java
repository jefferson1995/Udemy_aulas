package delimitados.application;

import delimitados.entities.Product;
import delimitados.services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        String path = "C:\\Users\\jeffe\\OneDrive\\Documentos\\Jefferson Barbosa dos Santos\\Udemy\\Java completo mais projetos\\Generics_Set_Map\\produtos.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Product x = CalculationService.max(list); //Chama o método delimitado
            System.out.println("Max: ");
            System.out.println(x);

        }catch (IOException e){

            System.out.println("Error: " + e.getMessage());

        }
    }
}
