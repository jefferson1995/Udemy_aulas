package application;

import java.io.File;
import java.util.Scanner;

public class ManipularPastas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o caminho de uma pasta: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File:: isDirectory); // Adiciona o diretório das pastas
        System.out.println("Folders:");
        for(File folder : folders){
            System.out.println(folder);
        }

        File[] files = path.listFiles(File::isFile); //Pega somente o caminho dos arquivos
        for (File file: files){
            System.out.println("Files:");
            System.out.println(file);
        }

        //Exemplo para criar uma subpasta
        boolean sucess = new File(strPath + "\\subdir").mkdir();
        System.out.println("Diretório crado com sucesso: " + sucess);

        sc.close();
    }
}
