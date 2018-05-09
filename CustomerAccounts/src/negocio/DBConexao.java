/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author gabry
 */
public class DBConexao extends DBData {
    
    //criando variaveis para conexao
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement preparedStmt;
    private boolean conexao;

    //criando getters e setters
    public boolean isConexao() {return conexao;}
    
    public Connection getCon() {return con;}
    
    public Statement getSt() {return st;}
    public void setSt(Statement st) {this.st = st;}
    
    public ResultSet getRs() {return rs;}
    public void setRs(ResultSet rs) {this.rs = rs;}
    
    public PreparedStatement getPreparedStmt() {return preparedStmt;}
    public void setPreparedStmt(PreparedStatement preparedStmt) {this.preparedStmt = preparedStmt;}
    
    //construtor para checar conexao
    public DBConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBConexao.host, DBConexao.user, DBConexao.password);
            st = (Statement) con.createStatement();
            this.conexao = true;
        } catch(ClassNotFoundException | SQLException e){
            this.conexao = false;
        }
    }
    
        
    
}
