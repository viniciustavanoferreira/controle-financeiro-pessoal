package com.cfp.controllers;

//Sessão de importação.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.cfp.models.Despesa;
import com.cfp.models.DAODespesa;

/**
 * Classe que define o controle ~ Despesa.
 * @author Vinicius Tavano Ferreira.
 * @since Classe criada em 09/10/2018.
 */
public class ControllerDespesa {
   
    public static void inserirDespesa(Despesa despesa) throws SQLException, ClassNotFoundException {
        
        if (despesa.getIntCodigo() == null)
            DAODespesa.inserirDespesa(despesa);
        else
            DAODespesa.alterarDespesa(despesa);

    }//Fim do método inserirReceita.

    public static Despesa buscarDespesa(Integer codigo) throws SQLException, ClassNotFoundException {
        return DAODespesa.buscarDespesa(codigo);
    }
    
    public static void excluirDespesa(Integer codigo) throws SQLException, ClassNotFoundException {
        DAODespesa.excluirDespesa(codigo);
    }//Fim do método excluirReceita.
    
    public static ResultSet buscarTodasDespesas() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAODespesa.buscarListagemDespesas();                
        return rs;
    }//Fim do método buscarTodasReceitas.
    
    public static List<Despesa> buscarListaDespesas() throws SQLException, ClassNotFoundException {
//        ResultSet rs;
//        rs = DAOReceita.buscarListagemReceitas();                
//        return rs;
        return DAODespesa.lista();
    }//Fim do método buscarTodasReceitas.
    
    public static ResultSet buscarProjetosRecursos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAODespesa.buscarProjetosRecursos();                
        return rs;
    }//Fim do método buscarProjetosRecursos.
    
    public static ResultSet buscarEtapasRecursos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAODespesa.buscarEtapasRecursos();                
        return rs;
    }//Fim do método buscarEtapasRecursos.   
    
    public static Object getConnection() throws SQLException, ClassNotFoundException {                
        return DAODespesa.getConnectionForReport();
    }//Fim do método buscarEtapasRecursos. 
    
    public static List<Despesa> lista() throws SQLException, ClassNotFoundException {
        return DAODespesa.lista(); 
    }

    public static ResultSet buscarHorasProjetos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAODespesa.buscarHorasProjetos();                
        return rs;
    }
    
    public static ResultSet buscarAtividadesRecursos() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAODespesa.buscarAtividadesRecursos();                
        return rs;
    }

}//Fim da classe ControllerDespesa.