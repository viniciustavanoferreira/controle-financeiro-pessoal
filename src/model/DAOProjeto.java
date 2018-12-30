package model;

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

/**
 * Classe que define o DAO ~ Projeto.
 * @author Vinicius Tavano Ferreira.
 * @since Classe criada em 07/09/2017.
 */
public class DAOProjeto {

    static Connection conexao;
    static Statement stmt;//executa clausula sql
    static ResultSet rs;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/EngSoft Process", "fatec", "fatec");
        return con;
    }

    public static Projeto buscarProjeto(Integer codigo) throws SQLException, ClassNotFoundException {
        conexao = getConnection();
        stmt = conexao.createStatement();
        String sql = "SELECT * FROM projetos WHERE codigo = " + codigo;
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            Integer cod = rs.getInt("CODIGO");
            String nome = rs.getString("NOME");
            String etapa = rs.getString("ETAPA");

            return new Projeto(cod, nome, etapa);
        }
        return null;
    }

    public static ResultSet buscarListagemProjetos() throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "SELECT * FROM projetos  ORDER BY codigo DESC";
        rs = stmt.executeQuery(sql);
        return rs;
    }
    
    public static ResultSet buscarProjetosRecursos() throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "SELECT p.nome AS PROJETO, f.nome AS FUNCIONARIO, f.tipo AS CARGO FROM projetos p, funcionarios f, atividades a  WHERE a.projeto = p.codigo AND a.funcionario = f.codigo";
        rs = stmt.executeQuery(sql);
        return rs;
    }
    
    public static ResultSet buscarEtapasRecursos() throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "SELECT p.etapa AS ETAPA, p.nome AS PROJETO, f.nome AS FUNCIONARIO, f.tipo AS CARGO, f.valor_hora AS TAXA FROM projetos p, funcionarios f, orcamento o  WHERE o.projeto = p.codigo AND o.funcionario = f.codigo";
        rs = stmt.executeQuery(sql);
        return rs;
    }
    
    public static Object getConnectionForReport() throws SQLException, ClassNotFoundException {
        return getConnection();
    }

    public static List<Projeto> lista() throws SQLException, ClassNotFoundException {

        Connection conexao = getConnection();
        Statement stmt = conexao.createStatement();
        String sql = "SELECT * FROM PROJETOS ORDER BY codigo DESC";
        ResultSet rs = stmt.executeQuery(sql);
        List<Projeto> projetos = new ArrayList();

        while (rs.next()) {

            Integer codigo = rs.getInt("CODIGO");
            String nome = rs.getString("NOME");
            String etapa = rs.getString("ETAPA");

            Projeto projeto = new Projeto(codigo, nome, etapa);
            projetos.add(projeto);
        }
        return projetos;
    }

    public static void inserirProjeto(Projeto projeto) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO projetos VALUES ((select COALESCE(MAX(codigo) + 1, 1) from projetos), ?, ?)");
        ps.setString(1, projeto.getNome());
        ps.setString(2, projeto.getEtapa());

        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Projeto cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no Banco de Dados!");
        }
    }

    public static void alterarProjeto(Projeto projeto) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE projetos SET nome = ?, etapa = ? WHERE codigo = ?");
        
        ps.setString(1, projeto.getNome());
        ps.setString(2, projeto.getEtapa());
        ps.setInt(3, projeto.getCodigo());
        
        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Projeto alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO de acesso ao Banco de Dados!");
        }
    }

    public static void excluirProjeto(Integer codProjeto) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "DELETE FROM projetos WHERE codigo = " + codProjeto;
        if (stmt.executeUpdate(sql) > 0) 
        {
            JOptionPane.showMessageDialog(null, "Projeto excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o Banco de Dados!");
        }
    }

    public static ResultSet buscarHorasProjetos() throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "SELECT a.atividade, a.status, a.horas, p.nome AS PROJETO, f.nome AS FUNCIONARIO FROM atividades a, projetos p, funcionarios f  WHERE a.projeto = p.codigo AND a.funcionario = f.codigo";
        rs = stmt.executeQuery(sql);
        return rs;
    }
    
    public static ResultSet buscarAtividadesRecursos() throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "SELECT a.atividade, a.status, a.horas, f.nome, f.tipo AS cargo FROM atividades a, funcionarios f  WHERE a.funcionario = f.codigo";
        rs = stmt.executeQuery(sql);
        return rs;
    }

} // Fim da classe DAOProjeto.
