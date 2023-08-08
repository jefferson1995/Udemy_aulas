package map.exercicio.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Map<String, Integer> candidatos = new HashMap<>();

            String line = br.readLine();

            while (line != null) {

                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if (candidatos.containsKey(name)) {
                    int votosAteAgora = candidatos.get(name);
                    candidatos.put(name, votosAteAgora + count);
                } else {
                    candidatos.put(name, count);
                }


                line = br.readLine();
            }

            for (String key : candidatos.keySet()) {

                System.out.println(key + ": " + candidatos.get(key));

            }

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        }
    }

}
