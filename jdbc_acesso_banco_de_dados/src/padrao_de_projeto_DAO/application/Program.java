package padrao_de_projeto_DAO.application;

import padrao_de_projeto_DAO.entities.Department;

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

        Department dp = new Department(1, "books");
        System.out.println(dp);



    }
}
