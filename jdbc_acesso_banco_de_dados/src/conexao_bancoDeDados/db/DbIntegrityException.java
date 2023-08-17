package conexao_bancoDeDados.db;

/*
    Execeção utilizada para identificar se houve algum problema de integridade
    Não é possível apagar algum dado do banco se ele estiver relacionado com outro id
 */
public class DbIntegrityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DbIntegrityException(String msg) {
        super(msg);
    }
}
