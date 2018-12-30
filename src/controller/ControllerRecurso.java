package controller;

//Sessão de importação.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Recurso;
import model.DAORecurso;

/**
 * Classe que define o controle ~ ControllerRecurso.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 14/09/2017
 */
public class ControllerRecurso {
    
    public static void salvarFuncionario(Recurso funcionario) throws SQLException, ClassNotFoundException {
        
        if (funcionario.getCodigo() == null)
            DAORecurso.inserirFuncionario(funcionario);            
        else
            DAORecurso.alterarFuncionario(funcionario);
        
    }//Fim do método ControllerRecurso.

    public static void excluirFuncionario(Integer codFuncionario) throws SQLException, ClassNotFoundException{
        DAORecurso.removerFuncionario(codFuncionario);
    }

    public static List<Recurso> lista() throws SQLException, ClassNotFoundException {
        return DAORecurso.lista();
    }
    
    public static ResultSet buscarTodosFuncionarios() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAORecurso.buscarListagemFuncionarios();                
        return rs;
    }//Fim do método buscarTodosFuncionarios.    

    public static Object getConnection() throws SQLException, ClassNotFoundException {                
        return DAORecurso.getConnectionForReport();
    }//Fim do método buscarEtapasRecursos. 

    public static ResultSet buscarHorasEstimadasEmProjetos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAORecurso.buscarHorasEstimadasEmProjetos();                
        return rs;
    }
    
}//Fim da classe ControllerRecurso.
