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
public class DAOReceita {

    public static Receita buscarReceita(Integer codigo) throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            String sql = "SELECT * FROM receita WHERE codigo = " + codigo;
            try(ResultSet rs = stmt.executeQuery(sql)){
                if (rs.next()) {
                    Integer intCodigo = rs.getInt("CODIGO");
                    String strDescricao = rs.getString("DESCRICAO");
                    String strAtivo = rs.getString("ATIVO");

                    return new Receita(intCodigo, strDescricao, strAtivo);
                }
                return null;
            }
        }
    }

    public static ResultSet buscarListagemReceitas() throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
        Statement stmt = conn.createStatement()){
            String sql = "SELECT * FROM receita  ORDER BY codigo DESC";
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

    public static List<Receita> lista() throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            String sql = "SELECT * FROM receita ORDER BY codigo DESC";
            try(ResultSet rs = stmt.executeQuery(sql)){
                List<Receita> receitas = new ArrayList();
                while (rs.next()) {
                    Integer intCodigo = rs.getInt("CODIGO");
                    String strDescricao = rs.getString("DESCRICAO");
                    String strAtivo = rs.getString("ATIVO");

                    Receita receita = new Receita(intCodigo, strDescricao, strAtivo);
                    receitas.add(receita);
                }
                return receitas;
            }
        }
    }

    public static void inserirReceita(Receita receita) throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO receita (codigo, descricao, ativo) SELECT COALESCE(MAX(codigo) + 1, 1), ?, ? FROM receita ";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, receita.getStrDescricao());
                ps.setString(2, receita.getStrAtivo());

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Receita cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao gravar no Banco de Dados!");
                }                
            }
        }
    }

    public static void alterarReceita(Receita receita) throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "UPDATE receita SET descricao = ?, ativo = ? WHERE codigo = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, receita.getStrDescricao());
                ps.setString(2, receita.getStrAtivo());
                ps.setInt(3, receita.getIntCodigo());

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Receita alterada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO de acesso ao Banco de Dados!");
                }                
            }
        }
    }

    
    public static void excluirReceita(Integer codReceita) throws SQLException, ClassNotFoundException {
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            String sql = "DELETE FROM receita WHERE codigo = " + codReceita;
            if (stmt.executeUpdate(sql) > 0) 
            {
                JOptionPane.showMessageDialog(null, "Receita excluída com sucesso!");
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

} // Fim da classe DAOReceita.
