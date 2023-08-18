package padrao_de_projeto_DAO.dao;

import padrao_de_projeto_DAO.entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();


}
