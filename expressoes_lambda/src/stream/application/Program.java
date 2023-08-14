package stream.application;

/*
    Stream

* Em umaa sequencia de elementos advinda de uma fonte de dados que
oferece suporte a "operagdes agregadas".
* Fonte de dados: colegao, array, função de de iteração, recurso de E/S

* Sugestao de leitura:
http://www.oracle.com/technetwork/pt/articles/java/streams-api-java-8-3410098-ptb.html

 */

/*
    Caracteristicas

* Stream é uma solução para processar sequéncias de dados de forma:
* Declarativa (iteragado interna: escondida do programador)
* Parallel-friendly (imutavel -> thread safe)
* Sem efeitos colaterais
* Sob demanda (lazy evaluation)

* Acesso sequencial (nao ha indices)
* Single-use: s6 pode ser "usada" uma vez

* Pipeline: operacdes em streams retornam novas streams. Entao é possivel
criar uma cadeia de operagées (fluxo de processamento).

 */

/*
    Operac6ées intermediarias e terminais


* O pipeline é composto por zero ou mais operações de intermediarias e
uma terminal.

* Operação intermediaria:
* Produz uma nova streams (encadeamento)
* S6 executa quando uma operacao terminal é invocada (lazy evaluation)

* Operagdo terminal:
* Produz um objeto nao-stream (coleção ou outro)
* Determina o fim do processamento da stream

 */

/*
    Operações intermediarias

* filter

* map

* flatmap
* peek

* distinct
* sorted
* skip

* limit (*)  - quando não sabe a quantidade de elementos, nesse caso posso pegar os 10 primeiros

* short-circuit

 */

/*
    Operações terminais

forEach
forEachOrdered,
toArray

reduce

collect
 min
 max

count
anyMatch (*)
allMatch (*)
noneMatch (*)
findFirst (*)
findAny (*)

* short-circuit

 */

/*
    Criar uma stream

* Basta chamar o método stream() ou parallelStream() a partir
de qualquer objeto Collection.
https://docs.oracle.com/javase/10/docs/api/java/util/Collection.html

* Outras formas de se criar uma stream incluem:
* Stream.of
* Stream.ofNullable
* Stream.iterate

 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3 ,4, 5, 10, 7);

        //Sem condição
        Stream<Integer> st1 = list.stream();
        System.out.println(Arrays.toString(st1.toArray()));

        //map
        Stream<Integer> st2 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st2.toArray()));

        //utilizando o stream.of
        Stream<String> st3 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st3.toArray()));

        //função de interação
        Stream<Integer> st4 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));

        //fibonacci
        Stream<Long> st5 = Stream.iterate(new Long[] {0L, 1L}, x -> new Long[] {x[1], x[0]+x[1]}).map(p -> p [0]);
        System.out.println(Arrays.toString(st5.limit(10).toArray()));
    }
}
