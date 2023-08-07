package set.application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

 /*
        Set<T>
        - Representa um conjunto de elementos (Similar ao da álgebra)
        -Não admite repetições
        -Elementos não possuem posição
        -Acesso, inserção e remoção de elementos são rápidos
        -Oferece operações eficientes de conjunto: interseção, união, diferença.
        Principais implementações
         . HashSet - maais rápido (Operações 0(1) em tabela hash) e não ordenado
         . TreeSet - mais lento (operações 0(log(n)) em árvore rubro-negro) e ordenado pelo compareTo do objeto(ou Comparador) precisa implementar na classe o Compareble
         . LinkedHashSet - velocidade intermediária e elementos na ordem em que são adicionados.

     */

public class Program {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("Tv");
        set.add("Tablet");
        set.add("Notebook");


        System.out.println(set.contains("Notebook"));
        set.remove("Tablet");
        set.removeIf(x -> x.equals("Tv")); //Remove de acordo com a condição

        for (String p : set) {
            System.out.println(p);
        }

        System.out.println();
        System.out.println();


        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));

        //Union
        /*
            União do que está no a e b
         */
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        //Intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);  //Somente elementos em comuns
        System.out.println(d);

        //Difference
        /*
            Remove todos que são diferentes
         */
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);




    }


}
