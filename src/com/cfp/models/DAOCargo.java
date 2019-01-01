package com.cfp.models;

//Sessão de importação.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static com.cfp.models.DAOCargo.conexao;

/**
 * Classe que define o modelo ~ Cargo.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 14/09/2017
 */
public class DAOCargo {

    static Connection conexao;
    static Statement stmt;//executa clausula sql

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/EngSoft Process", "fatec", "fatec");
        return con;
    }

    /*    
    public static void gravarNovoCargo(Cargo tipo) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO cargos VALUES ((select max(codigo) + 1 from cargos), ?)");
        ps.setString(1, tipo.getNome());
                        
        if (ps.executeUpdate() > 0)
            JOptionPane.showMessageDialog(null, "Cargo cadastrado com sucesso! (DAOCargo)");
        else
            JOptionPane.showMessageDialog(null, "Erro ao gravar no BD!");
    }*/

    public static List<Cargo> lista() throws SQLException, ClassNotFoundException {
        Connection conexao = getConnection();
        Statement stmt = conexao.createStatement();
        String sql = "SELECT * FROM CARGOS";
        ResultSet rs = stmt.executeQuery(sql);
        List<Cargo> cargos = new ArrayList();

        while (rs.next()) {

            Integer codigo = rs.getInt("CODIGO");
            String tipo = rs.getString("TIPO");

            Cargo cargo = new Cargo(codigo, tipo);
            cargos.add(cargo);
        }
        return cargos;
    }

    public static void removerCargo(String nome) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "DELETE FROM cargos WHERE tipo = '" + nome + "'";

        if (stmt.executeUpdate(sql) > 0) 
        {
            JOptionPane.showMessageDialog(null, "Cargo excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Banco de Dados!");
        }
    }

    public static void inserirCargo(Cargo tipo) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO cargos VALUES ((select COALESCE(MAX(codigo) + 1, 1) from cargos), ?)");
        ps.setString(1, tipo.getNome());

        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Cargo cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no Banco de Dados!");
        }
    }

    public static void alterarCargo(Cargo cargo) throws SQLException, ClassNotFoundException {
        conexao = getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE cargos SET tipo = ? WHERE codigo = ?");
        
        ps.setString(1, cargo.getNome());
        ps.setInt(2, cargo.getCodigo());
        
        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Cargo alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO de acesso ao Banco de Dados!");
        }
    }

}//Fim da classe OrcamentoDAO.
