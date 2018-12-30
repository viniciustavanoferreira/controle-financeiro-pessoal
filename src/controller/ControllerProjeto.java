package controller;

//Sessão de importação.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Projeto;
import model.DAOProjeto;

/**
 * Classe que define o controle ~ Projeto.
 * @author Vinicius Tavano Ferreira.
 * @since Classe criada em 07/09/2017.
 */
public class ControllerProjeto {
   
    public static void inserirProjeto(Projeto projeto) throws SQLException, ClassNotFoundException {
        
        if (projeto.getCodigo() == null)
            DAOProjeto.inserirProjeto(projeto);
        else
            DAOProjeto.alterarProjeto(projeto);

    }//Fim do método inserirProjeto.

    public static Projeto buscarProjeto(Integer codigo) throws SQLException, ClassNotFoundException {
        return DAOProjeto.buscarProjeto(codigo);
    }
    
    public static void excluirProjeto(Integer codProjeto) throws SQLException, ClassNotFoundException {
        DAOProjeto.excluirProjeto(codProjeto);
    }//Fim do método excluirProjeto.
    
    public static ResultSet buscarTodosProjetos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOProjeto.buscarListagemProjetos();                
        return rs;
    }//Fim do método buscarTodosProjetos.
    
    public static ResultSet buscarProjetosRecursos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOProjeto.buscarProjetosRecursos();                
        return rs;
    }//Fim do método buscarProjetosRecursos.
    
    public static ResultSet buscarEtapasRecursos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOProjeto.buscarEtapasRecursos();                
        return rs;
    }//Fim do método buscarEtapasRecursos.   
    
    public static Object getConnection() throws SQLException, ClassNotFoundException {                
        return DAOProjeto.getConnectionForReport();
    }//Fim do método buscarEtapasRecursos. 
    
    public static List<Projeto> lista() throws SQLException, ClassNotFoundException {
        return DAOProjeto.lista(); 
    }

    public static ResultSet buscarHorasProjetos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOProjeto.buscarHorasProjetos();                
        return rs;
    }
    
    public static ResultSet buscarAtividadesRecursos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOProjeto.buscarAtividadesRecursos();                
        return rs;
    }

}//Fim da classe ControllerProjeto.