package crud_completo.application;

import conexao_bancoDeDados.db.DB;
import conexao_bancoDeDados.db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    API:

* Statement
° ResultSet
o. first() [move para posi¢ao 1, se houver]
© beforeFirst() [move para posição 0]
© next() [move para o préximo, retorria false se jé estiver no ultimo]
© absolute(int) [move para a posigéo dada, lembrando que dados reais comegam em 1]

 */
public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while (rs.next()){
                System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
            }

        }
        catch (SQLException e){
            e.getStackTrace();
        }
        //finaliza a transação
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
