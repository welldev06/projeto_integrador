package com.mycompanys.projetointegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public static Connection conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/projetointegrador";
            String usuario = "root";
            String senha = ""; 
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco: " + e.getMessage());
            return null;
        }
    }
}
