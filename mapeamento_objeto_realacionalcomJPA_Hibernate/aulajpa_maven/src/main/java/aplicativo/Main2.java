package aplicativo;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/*
    Para remover um dado é preciso que que ele seja considerado dentro da transação antes de fechar
    Exemplo: Faço a busca de uma pessoa no banco de dados e este mesmo objeto eu referencio para excluir
 */
public class Main2 {
    public static void main(String[] args) {

        //Exemplo para buscar um usuário no banco de dados


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        EntityManager em = emf.createEntityManager(); //Cria a conexão com banco de dados

        //Não precisa colocar a transação, porque não está alterando dados, apenas buscando

        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);


        //exemplo para remover um dado que está sendo monitorado na transação
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();


        System.out.println("pronto");


        em.clear();
        emf.close();
    }
}
