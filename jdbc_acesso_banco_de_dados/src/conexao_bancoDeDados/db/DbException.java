package conexao_bancoDeDados.db;

/*
    Para não precisar ficar colocando muitos try e catch
    Porque extends do RuntimeException
 */
public class DbException extends RuntimeException{

    public DbException(String msg){
        super(msg);
    }
}
