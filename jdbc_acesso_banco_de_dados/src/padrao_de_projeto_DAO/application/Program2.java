package padrao_de_projeto_DAO.application;

import padrao_de_projeto_DAO.dao.DaoFactory;
import padrao_de_projeto_DAO.dao.DepartmentDao;
import padrao_de_projeto_DAO.entities.Department;

public class Program2 {
    public static void main(String[] args) {

        System.out.println("TESTE 1 ***** findById");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department dp = departmentDao.findById(1);
        System.out.println(dp);

        System.out.println("TESTE 2 ***** findByAll");



    }
}
