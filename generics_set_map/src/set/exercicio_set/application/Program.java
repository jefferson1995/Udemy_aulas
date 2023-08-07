package set.exercicio_set.application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<Integer> alunos = new HashSet<>();


        System.out.print("How many students for course A? ");
        int cont = sc.nextInt();

        sc.nextLine();

        for(int i=0; i< cont; i++){
            alunos.add(sc.nextInt());
        }

        System.out.print("How many students for course B? ");
        cont = sc.nextInt();

        sc.nextLine();

        for(int i=0; i< cont; i++){
            alunos.add(sc.nextInt());
        }

        System.out.print("How many students for course C? ");
        cont = sc.nextInt();
        sc.nextLine();
        for(int i=0; i< cont; i++){
            alunos.add(sc.nextInt());
        }

        for(int a : alunos){
            alunos.removeIf(x -> alunos.equals(x));
        }

        System.out.println(alunos);


        System.out.println("Total de studants: " + alunos.size());



    }
}
