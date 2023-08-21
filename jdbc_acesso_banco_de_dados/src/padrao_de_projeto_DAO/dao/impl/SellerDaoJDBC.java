package padrao_de_projeto_DAO.dao.impl;

import conexao_bancoDeDados.db.DB;
import conexao_bancoDeDados.db.DbException;
import padrao_de_projeto_DAO.dao.SellerDao;
import padrao_de_projeto_DAO.entities.Department;
import padrao_de_projeto_DAO.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
    Pacote impl -> implementação (onde estão as classes que implementam)
 */
public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*, department.Name AS DepName "
                    +"FROM seller INNER JOIN department "
                    +"ON seller.DepartmentId = department.Id "
                    +"WHERE seller.Id = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();

            if(rs.next()){
                Department dp = new Department();
                dp.setId(rs.getInt("DepartmentId"));
                dp.setName(rs.getString("DepName"));

                Seller obj = new Seller();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setBirthDate(rs.getDate("BirthDate"));
                obj.setDepartment(dp);

                return obj;
            }
            return null;

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }


    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
