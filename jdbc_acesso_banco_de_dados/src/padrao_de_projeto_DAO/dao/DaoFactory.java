package padrao_de_projeto_DAO.dao;

import conexao_bancoDeDados.db.DB;
import padrao_de_projeto_DAO.dao.impl.DepartmentDaoJDBC;
import padrao_de_projeto_DAO.dao.impl.SellerDaoJDBC;

/*
    Onde estão as operações static para instanciar os Daos
 */
public class DaoFactory {

    /*
        Para não precisar expor a implementação, não irá precisar instanciar no programa principal
     */

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
