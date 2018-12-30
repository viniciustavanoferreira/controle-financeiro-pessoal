package controller;

//Sessão de importação.
import java.sql.SQLException;
import java.util.List;
import model.Cargo;
import model.DAOCargo;

/**
 * Classe que define o controle ~ ControllerCargo.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 14/09/2017
 */
public class ControllerCargo {

    public static void inserirNovoCargo(Cargo tipo) throws SQLException, ClassNotFoundException {
        if (tipo.getCodigo() == null) {
            DAOCargo.inserirCargo(tipo);
        } else {
            DAOCargo.alterarCargo(tipo);
        }
    }

    public static List<Cargo> lista() throws SQLException, ClassNotFoundException {
        return DAOCargo.lista();
    }

    public static void excluirCargo(String nome) throws SQLException, ClassNotFoundException {
        DAOCargo.removerCargo(nome);
    }

}//Fim da classe ControllerCargo.
