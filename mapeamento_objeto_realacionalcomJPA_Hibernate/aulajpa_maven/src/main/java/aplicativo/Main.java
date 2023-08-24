package aplicativo;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(null, "Carlos Da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Maria Da Silva", "maria@gmail.com");
        Pessoa p3 = new Pessoa(null, "Pedro Da Silva", "pedro@gmail.com");

        //Faz as configurações de conexão
        //Passa como parametro o nome que está dentro do arquivo persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        EntityManager em = emf.createEntityManager(); //Cria a conexão com banco de dados


        em.getTransaction().begin(); //Transação com banco de dados

        //Salva no banco de dados
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        em.getTransaction().commit(); //Para confirmar as transações realizadas
        em.clear();
        emf.close();

    }

}
