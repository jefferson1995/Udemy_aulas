package transacoes.application;

import conexao_bancoDeDados.db.DB;
import conexao_bancoDeDados.db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Precisa ser automica = ou acontece tudo ou nada
    consistente
    isolada
    duravel

Demo: transações


Código fonte: https: //github . com/acenelio/jdbc6

API:
*  setAutoCommit(false)  -> cada operação isolada ela vai ser confirmada automaticamente quando estiver verdadeiro
© commit()   -> confirmar a transação
rollback() -> desfazer o que já foi feito até o momento.


 */
public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false); //-> irá aguardaruma confirmação

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");


            /*
            int x = 1;
            if(x < 2){
                throw new SQLException("Fake error");
            }
            */

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 4090 WHERE DepartmentId = 2");

            conn.commit(); //protege acima

            System.out.println("rows1: "+ rows1);
            System.out.println("rows2: "+ rows2);
        }
        catch (SQLException e){
            try {
                conn.rollback(); //-> volta a transação
                throw new DbException("Transação não concluida isso foi causado pelo erro: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error no rollback, causa do erro: " + ex.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }


    }
}
