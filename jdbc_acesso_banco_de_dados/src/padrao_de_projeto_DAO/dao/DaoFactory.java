package padrao_de_projeto_DAO.dao;

import padrao_de_projeto_DAO.dao.impl.SellerDaoJDBC;

/*
    Onde estão as operações static para instancias os Daos
 */
public class DaoFactory {

    /*
        Para não precisar expor a implementação, não irá precisar instanciar no programa principal
     */

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
