/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfp.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.cfp.models.DAOUser;
import com.cfp.models.User;

/**
 *
 * @author vtffa
 */
public class ControllerUser {

    public static ResultSet getCodUserPassUsuario(String codUser, String codPassword) throws SQLException {
        ResultSet rs = new DAOUser().getCodUserPassUsuario(codUser, codPassword);
        return rs;
    }
    
    public static List<User> lista() throws SQLException, ClassNotFoundException {
        return DAOUser.lista(); 
    }    

    public static void inserirUsuario(User user) throws SQLException {
        DAOUser.inserirUser(user);
    }

    public static void excluirUser(String codUser) throws SQLException {
        DAOUser.excluirUser(codUser);
    }
    
    public static ResultSet buscarPapeisUsuarios() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = DAOUser.buscarPapeisUsuarios();                
        return rs;
    }

    public static List<User> listaRecursos() throws SQLException {
        return DAOUser.listaRecursos(); 
    }

    public static void alterarSenha(String codUser, String senha) throws SQLException {
        DAOUser.alterarSenha(codUser, senha);
    }
    
}
