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

/**
 * Classe que define o modelo ~ DAORecurso.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 14/09/2017
 */
public class DAORecurso {
    static Connection conexao;
    static Statement stmt;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Connection con;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/EngSoft Process", "fatec", "fatec");
        return con;
    }
    
    public static List<Recurso> lista() throws SQLException, ClassNotFoundException {
        
        Connection conexao = getConnection();
        Statement stmt = conexao.createStatement();
        
        String sql = "SELECT * from funcionarios ORDER BY codigo DESC";
        
        ResultSet rs = stmt.executeQuery(sql);
        
        List<Recurso> funcionarios = new ArrayList();
        
        while(rs.next()) {
            
            Integer codigo = rs.getInt("CODIGO");
            String nome = rs.getString("NOME");
            String endereco = rs.getString("ENDERECO");
            String cidade = rs.getString("CIDADE");
            String estado = rs.getString("ESTADO");
            String sexo = rs.getString("SEXO");
            String cargo = rs.getString("TIPO");
            String codUser = rs.getString("CODUSER");
                    
            Recurso funcionario = new Recurso(codigo, nome, endereco, cidade, estado, sexo, new Cargo(cargo), new User(codUser));
            funcionarios.add(funcionario);
        }
        
        return funcionarios;
    }
        
    public static void inserirFuncionario(Recurso funcionario) throws SQLException, ClassNotFoundException {
        conexao = getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO funcionarios VALUES ((select COALESCE(MAX(codigo) + 1, 1) from funcionarios), ?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getEndereco());
        ps.setString(3, funcionario.getCidade());
        ps.setString(4, funcionario.getEstado());
        ps.setString(5, funcionario.getSexo());
        ps.setString(6, funcionario.getCargo().getNome());
        ps.setString(7, funcionario.getUser().getCodUser());
        
        if (ps.executeUpdate() > 0)
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Erro ao gravar no Banco de Dados!");
    }
    
    public static void alterarFuncionario(Recurso funcionario) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE funcionarios SET nome = ?, endereco = ?, cidade = ?, estado = ?, sexo = ?, tipo = ?, coduser = ? WHERE codigo = ?");
        
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getEndereco());
        ps.setString(3, funcionario.getCidade());
        ps.setString(4, funcionario.getEstado());
        ps.setString(5, funcionario.getSexo());
        ps.setString(6, funcionario.getCargo().getNome());
        ps.setString(7, funcionario.getUser().getCodUser());
        ps.setInt(8, funcionario.getCodigo());

        if(ps.executeUpdate()>0)
            JOptionPane.showMessageDialog(null,"Funcionário alterado com sucesso!");
        else
            JOptionPane.showMessageDialog(null,"ERRO de acesso ao Banco de Dados!");
    }
    
    public static void removerFuncionario(Integer codFuncionario) throws SQLException, ClassNotFoundException{
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "DELETE FROM funcionarios WHERE codigo = " + codFuncionario;
        if(stmt.executeUpdate(sql) > 0)
            JOptionPane.showMessageDialog(null,"Funcionário excluído com sucesso!");
        else
            JOptionPane.showMessageDialog(null,"ERRO ao acessar o Banco de Dados!");
    }
    
    public static ResultSet buscarListagemFuncionarios() throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "SELECT * FROM funcionarios ORDER BY codigo DESC";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public static Object getConnectionForReport() throws SQLException, ClassNotFoundException {
        return getConnection();
    }

    public static ResultSet buscarHorasEstimadasEmProjetos() throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        stmt = conexao.createStatement();
        sql = "SELECT a.atividade, a.status, a.horas, " +
"              p.nome AS projeto, f.nome  AS funcionario " +
"              FROM atividades AS a " +
"              JOIN projetos AS p " +
"               ON (a.projeto = p.codigo) " +
"              JOIN funcionarios AS f " +
"               ON (a.funcionario = f.codigo)";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
      
}//Fim da classe DAORecurso.
