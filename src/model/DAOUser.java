package model;

//Sessão de importação.
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * Classe que define a visão ~ Acesso.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 20/08/2017
 */
public class DAOUser {

    private static void inserirNovoUser(User user) throws SQLException {
        String sql = "INSERT INTO USUARIO (coduser, codpassword, descname, role) VALUES (? ,? ,? ,?)";
        
        try(Connection conn = getConnectionStatic();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, user.getCodUser());
            ps.setString(2, user.getCodPassword());
            ps.setString(3, user.getDescName());
            ps.setString(4, user.getRole());
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao gravar no Banco de Dados!");
            }
            
        }
    }

    private static void atualizarUser (User user) throws SQLException {
        String sql = "UPDATE usuario SET descname = ?, role = ? WHERE coduser = ? AND codpassword = ?";
        
        try(Connection conn = getConnectionStatic();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, user.getDescName());
            ps.setString(2, user.getRole());
            ps.setString(3, user.getCodUser());
            ps.setString(4, user.getCodPassword());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO de acesso ao Banco de Dados!");
                            
            }
            
        }
    }

    public static void excluirUser(String codUser) throws SQLException {
        String sql = "DELETE FROM usuario WHERE coduser = ?";
        
        try(Connection conn = getConnectionStatic();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codUser);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao acessar o Banco de Dados!");
            }
            
        }
    }

    public static ResultSet buscarPapeisUsuarios() throws SQLException {
//        String sql = "SELECT coduser, descname, role FROM usuario";
//        try(Connection conn = getConnectionStatic();
//            PreparedStatement ps = conn.prepareStatement(sql)){
//            try(ResultSet rs = ps.executeQuery()){
//                return rs;
//            }
//        }
        String sql;
        Connection conexao = getConnectionStatic();
        Statement stmt = conexao.createStatement();
        sql = "SELECT coduser, descname, role FROM usuario";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public static List<User> listaRecursos() throws SQLException {
        
        Connection conexao = getConnectionStatic();
        Statement stmt = conexao.createStatement();
        String sql = "SELECT * FROM usuario WHERE ROLE = 'RECURSO' ORDER BY coduser DESC";
        ResultSet rs = stmt.executeQuery(sql);
        List<User> users = new ArrayList();

        while (rs.next()) {

            String codUser = rs.getString("CODUSER");
            String codPassword = rs.getString("CODPASSWORD");
            String descName = rs.getString("DESCNAME");
            String role = rs.getString("ROLE");

            User user = new User(codUser, codPassword, descName, role);
            users.add(user);
        }
        
        return users;
    }

    public static void alterarSenha(String codUser, String senha) throws SQLException {
        String sql = "UPDATE usuario SET codpassword = ? WHERE coduser = ?";
        try(Connection conn = getConnectionStatic();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, senha);
            ps.setString(2, codUser);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO de acesso ao Banco de Dados!");
                            
            }
        }
    }

    private Connection conn;
    private Statement stmt;
    private ResultSet rs = null;
    private String sql;
    final private String url = "jdbc:derby://localhost:1527/EngSoft Process";
    final private String user = "fatec";
    final private String password = "fatec";    

    
    private static Connection getConnectionStatic() throws SQLException{
        Connection con;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/EngSoft Process", "fatec", "fatec");
        return con;
    }
    
    //Método que estabelece a conexão com o banco de dados.
    private Connection getConnection() throws SQLException{
        Connection con;
        con = DriverManager.getConnection(this.url, this.user, this.password);
        return con;
    }
    
    public ResultSet getCodUserPassUsuario(String codUser, String codPassword) throws SQLException {
        this.conn = this.getConnection();
        this.stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        this.sql = "SELECT * FROM usuario WHERE ( coduser = '" + codUser + "' AND " 
                                              + " codpassword  = '" + codPassword + "' )";
        this.rs = this.stmt.executeQuery(this.sql);
        
        if (!this.rs.first()) {
            JOptionPane.showMessageDialog(null,"Usuário e/ou senha incorreto(s).");
            this.rs = null;
        }
        
        return this.rs;
    }

    public static List<User> lista() throws SQLException, ClassNotFoundException {
        
        Connection conexao = getConnectionStatic();
        Statement stmt = conexao.createStatement();
        String sql = "SELECT * FROM usuario ORDER BY coduser DESC";
        ResultSet rs = stmt.executeQuery(sql);
        List<User> users = new ArrayList();

        while (rs.next()) {

            String codUser = rs.getString("CODUSER");
            String codPassword = rs.getString("CODPASSWORD");
            String descName = rs.getString("DESCNAME");
            String role = rs.getString("ROLE");

            User user = new User(codUser, codPassword, descName, role);
            users.add(user);
        }
        
        return users;
    }    
    
    public static void inserirUser(User user) throws SQLException {
        
        String sql = "SELECT * FROM usuario WHERE ( coduser = ? AND " 
                                              + " codpassword  = ? )";
        
        try(Connection conn = getConnectionStatic();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, user.getCodUser());
            ps.setString(2, user.getCodPassword());
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    atualizarUser(user);
                } else {
                    inserirNovoUser(user);
                }
                
            }
            
        }
    }
    
    //Método para desconectar o banco de dados.
    private void setDisconnect(Connection con){
    
        try{
            con.close();
            //JOptionPane.showMessageDialog(null,"Banco desconectado");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"O banco não conseguiu se desconectar!"); 
          //JOptionPane.showMessageDialog(null,"O banco não conseguiu desconectar " + erroSQL.getMessage()); 
        }
        
    }   

}
      

