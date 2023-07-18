package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Processopara ler um arquivo
public class Buffered {
    public static void main(String[] args) {

        String path = "C:\\Users\\jeffe\\OneDrive\\Documentos\\Jefferson Barbosa dos Santos\\Udemy\\Java completo mais projetos\\TRABALHANDO COM ARQUIVOS\\in.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
