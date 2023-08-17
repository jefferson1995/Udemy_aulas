package crud_completo.application;

import conexao_bancoDeDados.db.DB;
import conexao_bancoDeDados.db.DbException;
import conexao_bancoDeDados.db.DbIntegrityException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
    API:

* Statement
° ResultSet
o. first() [move para posi¢ao 1, se houver]
© beforeFirst() [move para posição 0]
© next() [move para o préximo, retorria false se jé estiver no ultimo]
© absolute(int) [move para a posigéo dada, lembrando que dados reais comegam em 1]

 */


/*
  Demo: inserir dados

Código fonte: https ://github.com/acenelio/jdbc3

* PreparedStatement

e executeUpdate
* Statement.RETURN_GENERATED_KEYS
* getGeneratedKeys

Checklist:

*  Inserção simples com preparedStatement
*  Inserção com recuperação de Id

Demo: atualizar dados

Código fonte: https: //github.com/acenelio/jdbc4

 */
public class Program {
    public static void main(String[] args) {



        /*
            Recuperar dados
         */
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        //finaliza a transação
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            // DB.closeConnection();
        }





        /*
            inserir dados - exemplo
         */

        Connection conn2 = null;
        PreparedStatement st2 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conn2 = DB.getConnection();

            /*
            st2 = conn2.prepareStatement(
                    "INSERT INTO seller "
                    +"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    +"VALUES "
                    +"(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); //retorna o id que foi inserido

            //Substitui o ? pelo valor
            st2.setString(1, "Carl Purple");
            st2.setString(2, "Carl@gmail.com");
            st2.setDate(3, new Date(sdf.parse("22/04/1985").getTime()));
            st2.setDouble(4, 3000.0);
            st2.setInt(5, 4);

             */

            //outro exemplo para adicionar com mais de um insert

            st2 = conn2.prepareStatement("insert into department (Name) values ('D1'), ('D2')", Statement.RETURN_GENERATED_KEYS);


            int rowsAffected = st2.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs2 = st2.getGeneratedKeys();
                while (rs2.next()) {
                    int id = rs2.getInt(1); //Pega o primeiro id da coluna
                    System.out.println("Done! id = " + id);
                }
            } else {
                System.out.println("Nenhuma linha alterada");
            }
        } catch (SQLException e) {
            e.getStackTrace();

        } /*catch (ParseException e) {
            throw new RuntimeException(e);
        }
         */ finally {
            DB.closeStatement(st2);
            //DB.closeConnection();
        }






        /*
            Exemplo para atualizar dados
         */

        Connection conn3 = null;
        PreparedStatement st3 = null;

        try {
            conn3 = DB.getConnection();
            st3 = conn3.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)");
            st3.setDouble(1, 200.0);
            st3.setInt(2, 2);

            int rowsAffected3 = st3.executeUpdate();

            System.out.println("Done! Linhas afetadas: " + rowsAffected3);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st3);
            //DB.closeConnection();
        }



        /*
        Exemplo para deletar dados
         */

        Connection conn4 = null;
        PreparedStatement st4 = null;

        try {
            conn4 = DB.getConnection();
            st4 = conn4.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE "
                            + "Id = ?");

            st4.setInt(1, 2);


            int rowsAffected4 = st4.executeUpdate();

            System.out.println("Done! Linhas afetadas: " + rowsAffected4);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage()); //exception personalizada, para não estourar aquele erro gigante
        } finally {
            DB.closeStatement(st3);
            DB.closeConnection();
        }


    }
}
