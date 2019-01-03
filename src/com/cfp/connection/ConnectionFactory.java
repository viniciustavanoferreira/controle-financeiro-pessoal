package com.cfp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que define o modelo ~ Atividade.
 * @author Vinicius Tavano Ferreira
 * @since Classe criada em 15/10/2018
 */
public class ConnectionFactory {
    
        // Blocos estáticos são carregados depois que a JVM interpreta do classpath, 
        //porém antes de processar seu respectivo construtor.
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
                    throw new RuntimeException("Erro na conexão: ", e);
		}		
	}
        
	public static Connection getConnection () throws SQLException{
		Connection conn = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/controle_financeiro_pessoal", 
						"root", ""); // Usuário e senha utilizado no MySQL após subir
                                                             //o servidor XAMPP.
		return conn;
	}
  
} 
