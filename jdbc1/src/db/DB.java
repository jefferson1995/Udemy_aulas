package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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

}
