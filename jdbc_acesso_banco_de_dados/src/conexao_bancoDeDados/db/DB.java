package conexao_bancoDeDados.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import conexao_bancoDeDados.db.DbException;

public class DB {

    private static Connection conn = null;

    //Conecta com o banco de dados
    public static Connection getConnection() {
        if (conn == null) {
            try {

                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    //fechar a conexão
    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }

        }
    }

    //carrega os dados do arquivo
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs); //Guarda os dados dentro do objeto properties

            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    //Para não ter que ficar colonando try em outras classes e nãos obrigado a ficar tratando os erros
    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    //Para não ter que ficar colonando try em outras classes e nãos obrigado a ficar tratando os erros
    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

}
