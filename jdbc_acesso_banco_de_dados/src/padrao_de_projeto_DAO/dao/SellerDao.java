package padrao_de_projeto_DAO.dao;

import padrao_de_projeto_DAO.entities.Department;
import padrao_de_projeto_DAO.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);

}
