package comparable_interface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program  {

    public static void main(String[] args) {

        List<comparable_interface.application.entities.Funcionario> list = new ArrayList<>();
        String path = "C:\\Users\\jeffe\\OneDrive\\Documentos\\Jefferson Barbosa dos Santos\\Udemy\\Java completo mais projetos\\INTERFACES\\nomes.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String funcionarioCsv = br.readLine();
            while (funcionarioCsv != null){
                String[] fields = funcionarioCsv.split(","); //Separa por vírgula
                list.add(new comparable_interface.application.entities.Funcionario(fields[0], Double.parseDouble(fields[1])));
                funcionarioCsv = br.readLine();
            }
            Collections.sort(list); //Ordena a lista
            for (comparable_interface.application.entities.Funcionario funcionario : list){
                System.out.println(funcionario.getName() + ", " + funcionario.getSalary());
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
