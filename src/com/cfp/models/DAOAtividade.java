package com.cfp.models;

//Sessão de importação.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import static com.cfp.models.DAORecurso.conexao;
import static com.cfp.models.DAORecurso.getConnection;
import static com.cfp.models.DAORecurso.stmt;

/**
 * Classe que define o modelo ~ DAOAtividade.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 15/09/2017
 */
public class DAOAtividade {

    public static List<Atividade> lista() throws SQLException, ClassNotFoundException {
        Connection conexao = getConnection();
        Statement stmt = conexao.createStatement();
        String sql = "SELECT a.codigo, p.nome AS PROJETO, f.nome AS FUNCIONARIO, a.inicio, a.fim, a.atividade, a.status, a.horas FROM atividades AS a JOIN projetos AS p ON a.projeto = p.codigo JOIN funcionarios AS f ON a.funcionario = f.codigo";
        ResultSet rs = stmt.executeQuery(sql);
        List<Atividade> atividades = new ArrayList();

        while (rs.next()) {
            Integer codigo = rs.getInt("CODIGO");
            String projeto = rs.getString("PROJETO");
            String funcionario = rs.getString("FUNCIONARIO");
            Date inicio = rs.getDate("INICIO");
            Date fim = rs.getDate("FIM");
            String atv = rs.getString("ATIVIDADE");
            Integer status = rs.getInt("STATUS");
            Integer horas = rs.getInt("HORAS");

            Atividade atividade = new Atividade(codigo, new Projeto(projeto), new Recurso(funcionario), inicio, fim, atv, status, horas);
            atividades.add(atividade);
        }
        return atividades;
    }

    public static void inserirAtividade(Atividade atividade) throws SQLException, ClassNotFoundException {
        conexao = getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO atividades VALUES ((select COALESCE(MAX(codigo) + 1, 1) from atividades), ?, ?, ?, ?, ?, ?, ?)");

        ps.setDate(1, new java.sql.Date(atividade.getInicio().getTime()));
        ps.setDate(2, new java.sql.Date(atividade.getFim().getTime()));
        ps.setString(3, atividade.getAtividade());
        ps.setInt(4, atividade.getProjeto().getCodigo());
        ps.setInt(5, atividade.getFuncionario().getCodigo());
        ps.setInt(6, atividade.getHoras());
        ps.setInt(7, atividade.getStatus());
        
        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Atividade cadastrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no Banco de Dados!");
        }
    }

    public static void removerAtividade(Integer codigo) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "DELETE FROM atividades WHERE codigo = " + codigo;
        if (stmt.executeUpdate(sql) > 0) {
            JOptionPane.showMessageDialog(null, "Atividade excluída com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO ao acessar o Banco de Dados!");
        }
    }

    public static void alterarAtividade(Atividade atividade) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE atividades SET funcionario = ?, inicio = ?, fim = ?, status = ?, projeto = ?, horas = ?, atividade = ? WHERE codigo = ?");

        ps.setInt(1, atividade.getFuncionario().getCodigo());
        ps.setDate(2, new java.sql.Date(atividade.getInicio().getTime()));
        ps.setDate(3, new java.sql.Date(atividade.getFim().getTime()));
        ps.setInt(4, atividade.getStatus());
        ps.setInt(5, atividade.getProjeto().getCodigo());
        ps.setInt(6, atividade.getHoras());
        ps.setString(7, atividade.getAtividade());
        ps.setInt(8, atividade.getCodigo());

        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Atividade alterada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO de acesso ao Banco de Dados!");
        }
    }
    
    public static ResultSet buscarListagemAtividades() throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "SELECT a.codigo, p.nome AS PROJETO, f.nome AS FUNCIONARIO, a.inicio, a.fim,'DD/MM/YYYY', a.atividade, a.status, a.horas FROM atividades AS a JOIN projetos AS p ON a.projeto = p.codigo JOIN funcionarios AS f ON a.funcionario = f.codigo ORDER BY codigo DESC";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public static Object getConnectionForReport() throws SQLException, ClassNotFoundException {
        return getConnection();
    }

    public static List<Atividade> listaPercent(String codUser) throws SQLException, ClassNotFoundException {
        Connection conexao = getConnection();
        Statement stmt = conexao.createStatement();
        String sql = "SELECT a.codigo, p.nome AS PROJETO, f.nome AS FUNCIONARIO, a.inicio, "
                + "a.fim, a.atividade, a.status, a.horas "
                + "FROM atividades AS a JOIN projetos AS p ON a.projeto = p.codigo "
                + "JOIN funcionarios AS f ON a.funcionario = f.codigo "
                + "WHERE f.coduser = '" + codUser + "'";
        ResultSet rs = stmt.executeQuery(sql);
        List<Atividade> atividades = new ArrayList();

        while (rs.next()) {
            Integer codigo = rs.getInt("CODIGO");
            String projeto = rs.getString("PROJETO");
            String funcionario = rs.getString("FUNCIONARIO");
            Date inicio = rs.getDate("INICIO");
            Date fim = rs.getDate("FIM");
            String atv = rs.getString("ATIVIDADE");
            Integer status = rs.getInt("STATUS");
            Integer horas = rs.getInt("HORAS");

            Atividade atividade = new Atividade(codigo, new Projeto(projeto), new Recurso(funcionario), inicio, fim, atv, status, horas);
            atividades.add(atividade);
        }
        return atividades;
    }

    public static ResultSet buscarAtividadesRecurso(String codUser) throws SQLException, ClassNotFoundException {
        String sql = "SELECT a.codigo, p.nome AS PROJETO, f.nome AS FUNCIONARIO, a.inicio, "
                + "a.fim, a.atividade, a.status, a.horas "
                + "FROM atividades AS a JOIN projetos AS p ON a.projeto = p.codigo "
                + "JOIN funcionarios AS f ON a.funcionario = f.codigo "
                + "WHERE f.coduser = '" + codUser + "'";
        
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }


}//Fim da classe DAOAtividade.
