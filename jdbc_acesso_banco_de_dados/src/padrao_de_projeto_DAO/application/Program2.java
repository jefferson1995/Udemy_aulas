package padrao_de_projeto_DAO.application;

import padrao_de_projeto_DAO.dao.DaoFactory;
import padrao_de_projeto_DAO.dao.DepartmentDao;
import padrao_de_projeto_DAO.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nTESTE 1 ***** findById");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department dp = departmentDao.findById(1);
        System.out.println(dp);

        System.out.println("\n\nTESTE 2 ***** findByAll");
        List<Department> list = departmentDao.findAll();

        for(Department obj : list){
            System.out.println(obj);
        }

        System.out.println("\n\nTESTE 3 ***** UPDATE");

        Department department = departmentDao.findById(1);
        department.setName("Contabilidade");
        departmentDao.update(department);

        System.out.println("Departamento  " + department.getId()+ " Atualizado!");


        System.out.println("\n\nTESTE 4 ***** INSERT");

        Department newDepartment = new Department(null, "Queijos");

        departmentDao.insert(newDepartment);
        System.out.println("Novo departamento criado: " + newDepartment.getId());



        System.out.println("\n\nTESTE 5 ***** DELETE");
        System.out.print("Inserir id para delete: ");
        int id = sc.nextInt();

        departmentDao.deleteById(id);

        System.out.println("Id: " + id + " Deletado com sucesso!");
















    }
}
