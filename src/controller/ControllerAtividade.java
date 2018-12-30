package controller;

//Sessão de importação.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Atividade;
import model.DAOAtividade;

/**
 * Classe que define o controle ~ ControllerAtividade.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 15/09/2017
 */
public class ControllerAtividade {

    public static List<Atividade> lista() throws SQLException, ClassNotFoundException {
        return DAOAtividade.lista();
    }

    public static void salvarAtividade(Atividade atividade) throws SQLException, ClassNotFoundException {
        
        if (atividade.getCodigo() == null)
            DAOAtividade.inserirAtividade(atividade);            
        else
            DAOAtividade.alterarAtividade(atividade);
        
    }//Fim do método salvarAtividade

    public static void excluirAtividade(Integer codigo) throws SQLException, ClassNotFoundException {
        DAOAtividade.removerAtividade(codigo);
    }
    
    public static ResultSet buscarTodasAtividades() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOAtividade.buscarListagemAtividades();                
        return rs;
    }//Fim do método buscarTodasAtividades.    

    public static Object getConnection() throws SQLException, ClassNotFoundException {                
        return DAOAtividade.getConnectionForReport();
    }//Fim do método getConnection. 

    public static List<Atividade> listaPercent(String codUser) throws SQLException, ClassNotFoundException {
        return DAOAtividade.listaPercent(codUser);
    }

    public static ResultSet buscarAtividadesRecurso(String codUser) throws SQLException, ClassNotFoundException{
        return DAOAtividade.buscarAtividadesRecurso(codUser);
    }

}//Fim da classe ControllerAtividade.
