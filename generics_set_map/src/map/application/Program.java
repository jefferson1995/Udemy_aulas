package map.application;

import map.entities.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
    Map<k,V>

https://docs.oracle.com/javase/10/docs/api/java/util/Map.html

E uma coleção de pares chave / valor - os valores são identificados por uma chave e pode ser de qualquer tipo
* Nao admite repeticdes do objeto chave
* Os elementos sao indexados pelo objeto chave (nao possuem posi¢ao)
* Acesso, inserção e remoção de elementos são rápidos

Uso comum: cookies, local storage, qualquer modelo chave-valor

Principais implementações:
+ HashMap - mais rapido (operagdes O(1) em tabela hash) e nao ordenado

* TreeMap - mais lento foperacces O(log(n)) em arvore rubro-negra) e ordenado pelo
compareTo do objeto (ou Comparator}

* LinkedHashMan - velocidade intermediaria e elementos na ordem em que sao adicionados

Alguns métodos importantes

* put(key, value), remove(key), containsKey(key), get(key)
* Baseado em equals e hashCode
* Se equals e hashCode n@o existir, é usada comparacao de ponteiros

* clear()
* size()

* keySet() - retorna um Set<K>
* values() - retornaa um Collection<V>

 */
public class Program {

    public static void main(String[] args) {

        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Maria"); //chave / valor
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "99711122");

        cookies.remove("email"); //remove do Map cuja a chave é o e-mail.
        cookies.put("phone", "99711133");

        System.out.println("Contains 'phone' Key: " + cookies.containsKey("phone"));
        System.out.println("phone number: " + cookies.get("phone"));
        System.out.println("email: " + cookies.get("email"));
        System.out.println("size: " + cookies.size());

        System.out.println("All cookies: ");

        for (String key : cookies.keySet()){ //retorna um set com as chaves do Map
            System.out.println(key + ": " + cookies.get(key));
        }

        System.out.println("------------------------------------------------");

        Map<Product, Double> stock = new HashMap<>();

        Product p1 = new Product("TV", 900.0);
        Product p2 = new Product("Notebook", 1200.0);
        Product p3 = new Product("Tablet", 400.0);

        stock.put(p1, 10000.0);
        stock.put(p2, 20000.0);
        stock.put(p3, 15000.0);

        Product ps1 = new Product("TV", 900.0);

        System.out.println(p1.equals(ps1));

        System.out.println(stock.containsKey(ps1));





    }
}



















