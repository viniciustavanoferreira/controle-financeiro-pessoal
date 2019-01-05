package com.cfp.controllers;

//Sessão de importação.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.cfp.models.Receita;
import com.cfp.models.DAOReceita;

/**
 * Classe que define o controle ~ Receita.
 * @author Vinicius Tavano Ferreira.
 * @since Classe criada em 07/09/2018.
 */
public class ControllerReceita {
   
    public static void inserirReceita(Receita projeto) throws SQLException, ClassNotFoundException {
        
        if (projeto.getIntCodigo() == null)
            DAOReceita.inserirReceita(projeto);
        else
            DAOReceita.alterarReceita(projeto);

    }//Fim do método inserirReceita.

    public static Receita buscarReceita(Integer codigo) throws SQLException, ClassNotFoundException {
        return DAOReceita.buscarReceita(codigo);
    }
    
    public static void excluirReceita(Integer codProjeto) throws SQLException, ClassNotFoundException {
        DAOReceita.excluirReceita(codProjeto);
    }//Fim do método excluirReceita.
    
    public static ResultSet buscarTodasReceitas() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOReceita.buscarListagemReceitas();                
        return rs;
    }//Fim do método buscarTodasReceitas.
    
    public static List<Receita> buscarListaReceitas() throws SQLException, ClassNotFoundException {
//        ResultSet rs;
//        rs = DAOReceita.buscarListagemReceitas();                
//        return rs;
        return DAOReceita.lista();
    }//Fim do método buscarTodasReceitas.
    
    public static ResultSet buscarProjetosRecursos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOReceita.buscarProjetosRecursos();                
        return rs;
    }//Fim do método buscarProjetosRecursos.
    
    public static ResultSet buscarEtapasRecursos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOReceita.buscarEtapasRecursos();                
        return rs;
    }//Fim do método buscarEtapasRecursos.   
    
    public static Object getConnection() throws SQLException, ClassNotFoundException {                
        return DAOReceita.getConnectionForReport();
    }//Fim do método buscarEtapasRecursos. 
    
    public static List<Receita> lista() throws SQLException, ClassNotFoundException {
        return DAOReceita.lista(); 
    }

    public static ResultSet buscarHorasProjetos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOReceita.buscarHorasProjetos();                
        return rs;
    }
    
    public static ResultSet buscarAtividadesRecursos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOReceita.buscarAtividadesRecursos();                
        return rs;
    }

}//Fim da classe ControllerReceita.