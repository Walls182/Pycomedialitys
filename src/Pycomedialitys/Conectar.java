/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeterinariaDogtor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Conectar {
    private static Connection conn;
    private static String Driver = "com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String pass = "22130";
    private static String url = "jdbc:mysql://localhost:3306/bdveterinaria";

    public Conectar() {
        conn = null;
        try{
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, user, pass);
            if(conn!=null){
                System.out.println("Conexión establecida");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error conectando"); 
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void close(){
        conn = null;
        System.out.println("Conexión cerrada");
    }
     public void llenarTablas(JComboBox combo){
        String sql = "show tables";
        Statement st;
        Conectar conn = new Conectar();
        Connection Conectar = conn.getConnection();
        try{
            st = Conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                combo.addItem(rs.getString("Tables_in_bdveterinaria"));
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        } 
    }
     public void llenaCombo(String tabla,String valor,JComboBox combo){
        String sql = "select * from " + tabla;
        Statement st;
        Conectar conn = new Conectar();
        Connection Conectar = conn.getConnection();
        try{
            st = Conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                combo.addItem(rs.getString(valor));
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
        } 
    }
}
