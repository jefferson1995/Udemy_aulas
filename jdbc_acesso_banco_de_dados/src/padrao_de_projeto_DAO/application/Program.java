package padrao_de_projeto_DAO.application;

import padrao_de_projeto_DAO.dao.DaoFactory;
import padrao_de_projeto_DAO.dao.SellerDao;
import padrao_de_projeto_DAO.entities.Department;
import padrao_de_projeto_DAO.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
    Padrao de projeto DAO (Data Access Object)

Referências:
https: //www.devmedia.com.br/dao-pattern-persistencia-de-dados-utilizando-o-padrao-dao/3@999
https: //www. oracle. com/technetwork/java/dataaccessobject-138824.html

Ideia geral do padrao DAO:
* Para cada entidade, havera um objeto responsavel por fazer acesso a dados relacionado a esta
entidade. Por exemplo:

o Cliente: ClienteDao
° Produto: ProdutoDao
o Pedido: PedidoDao

* Cada DAO sera definido por uma interface.

* A injecao de dependéncia pode ser feita por meio do padrao de projeto Factory (Quando não está usando framework)

-Melhor para manutenção caso o banco de dados mude futuramente

 */
public class Program {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById ==== ");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        //Busca por departamento
        System.out.println("\n=== TEST 2: seller findByDepartment ==== ");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        //Busca todos
        System.out.println("\n=== TEST 3: seller findByAll ==== ");

        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }


        //Inserir dados
        System.out.println("\n=== TEST 4: seller insert ==== ");

        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Novo id igual a: " + newSeller.getId());


        //Update
        System.out.println("\n=== TEST 5: seller Update ==== ");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update comleto");


        //DELETE
        System.out.println("\n=== TEST 6: seller DELETE ==== ");
        System.out.print("Entre com um id para deletar: ");
        int id = sc.nextInt();

        sellerDao.deleteById(id);
        System.out.println("Delete completo");

        sc.close();



    }
}
