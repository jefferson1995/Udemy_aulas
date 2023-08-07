package set.exemplo_resolvido_set.application;

import set.exemplo_resolvido_set.entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com a url do arquivo: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();

            while (line != null){

                String[] fields = line.split(" ");
                String username = fields[0];
                Date momento = Date.from(Instant.parse(fields[1])); //Para pegar a data

                set.add(new LogEntry(username, momento)); //Já realiza a comparação com o hashcode and equals da classe

                line = br.readLine();
            }

            System.out.println("Total users: " + set.size());

        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
