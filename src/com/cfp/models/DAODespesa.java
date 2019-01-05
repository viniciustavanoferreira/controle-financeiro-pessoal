package com.cfp.models;

//Sessão de importação.
import com.cfp.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe que define o DAO ~ Receita.
 * @author Vinicius Tavano Ferreira.
 * @since Classe criada em 07/09/2017.
 */
public class DAODespesa {

    public static Despesa buscarDespesa(Integer codigo) throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            String sql = "SELECT * FROM despesa WHERE codigo = " + codigo;
            try(ResultSet rs = stmt.executeQuery(sql)){
                if (rs.next()) {
                    Integer intCodigo = rs.getInt("CODIGO");
                    String strDescricao = rs.getString("DESCRICAO");
                    String strAtivo = rs.getString("ATIVO");

                    return new Despesa(intCodigo, strDescricao, strAtivo);
                }
                return null;
            }
        }
    }

    public static ResultSet buscarListagemDespesas() throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
        Statement stmt = conn.createStatement()){
            String sql = "SELECT * FROM despesa  ORDER BY codigo DESC";
            try(ResultSet rs = stmt.executeQuery(sql)){
                return rs;
            }
        }
    }
    
    public static ResultSet buscarProjetosRecursos() throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
        Statement stmt = conn.createStatement()){
            String sql = "SELECT p.nome AS PROJETO, f.nome AS FUNCIONARIO, f.tipo AS CARGO FROM projetos p, funcionarios f, atividades a  WHERE a.projeto = p.codigo AND a.funcionario = f.codigo";
            try(ResultSet rs = stmt.executeQuery(sql)){
                return rs;
            }
        }
    }
    
    public static ResultSet buscarEtapasRecursos() throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
              Statement stmt = conn.createStatement()){
            String sql = "SELECT p.etapa AS ETAPA, p.nome AS PROJETO, f.nome AS FUNCIONARIO, f.tipo AS CARGO, f.valor_hora AS TAXA FROM projetos p, funcionarios f, orcamento o  WHERE o.projeto = p.codigo AND o.funcionario = f.codigo";
            try(ResultSet rs = stmt.executeQuery(sql)){
                return rs;
            }
        }
    }
    
    public static Object getConnectionForReport() throws SQLException, ClassNotFoundException {
        return ConnectionFactory.getConnection();
    }

    public static List<Despesa> lista() throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            String sql = "SELECT * FROM despesa ORDER BY codigo DESC";
            try(ResultSet rs = stmt.executeQuery(sql)){
                List<Despesa> despesas = new ArrayList();
                while (rs.next()) {
                    Integer intCodigo = rs.getInt("CODIGO");
                    String strDescricao = rs.getString("DESCRICAO");
                    String strAtivo = rs.getString("ATIVO");

                    Despesa despesa = new Despesa(intCodigo, strDescricao, strAtivo);
                    despesas.add(despesa);
                }
                return despesas;
            }
        }
    }

    public static void inserirDespesa(Despesa despesa) throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO despesa (codigo, descricao, ativo) SELECT COALESCE(MAX(codigo) + 1, 1), ?, ? FROM despesa ";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, despesa.getStrDescricao());
                ps.setString(2, despesa.getStrAtivo());

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao gravar no Banco de Dados!");
                }                
            }
        }
    }

    public static void alterarDespesa(Despesa despesa) throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "UPDATE despesa SET descricao = ?, ativo = ? WHERE codigo = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, despesa.getStrDescricao());
                ps.setString(2, despesa.getStrAtivo());
                ps.setInt(3, despesa.getIntCodigo());

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Despesa alterada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO de acesso ao Banco de Dados!");
                }                
            }
        }
    }

    
    public static void excluirDespesa(Integer codigo) throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            String sql = "DELETE FROM despesa WHERE codigo = " + codigo;
            if (stmt.executeUpdate(sql) > 0) 
            {
                JOptionPane.showMessageDialog(null, "Despesa excluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao acessar o Banco de Dados!");
            }
        }
    }

    public static ResultSet buscarHorasProjetos() throws SQLException, ClassNotFoundException {
        String sql;
        Connection conexao = ConnectionFactory.getConnection();
        Statement stmt = conexao.createStatement();
        sql = "SELECT a.atividade, a.status, a.horas, p.nome AS PROJETO, f.nome AS FUNCIONARIO FROM atividades a, projetos p, funcionarios f  WHERE a.projeto = p.codigo AND a.funcionario = f.codigo";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
    
    public static ResultSet buscarAtividadesRecursos() throws SQLException, ClassNotFoundException {
        String sql;
        Connection conexao = ConnectionFactory.getConnection();
        Statement stmt = conexao.createStatement();
        sql = "SELECT a.atividade, a.status, a.horas, f.nome, f.tipo AS cargo FROM atividades a, funcionarios f  WHERE a.funcionario = f.codigo";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

} // Fim da classe DAODespesa.
