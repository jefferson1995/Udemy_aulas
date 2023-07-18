package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
    Stream de escrita de caracteres em de arquivos
 */
public class EscreverArquivo {

    public static void main(String[] args) {

        String[] lines = new String[]{
                "Bom dia",
                "Boa tarde",
                "Boa noite"
        };

        String path = "C:\\Users\\jeffe\\OneDrive\\Documentos\\Jefferson Barbosa dos Santos\\Udemy\\Java completo mais projetos\\TRABALHANDO COM ARQUIVOS\\out.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){ //true indica que não é para recriar o arquivo e escrever na próxima linha
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
