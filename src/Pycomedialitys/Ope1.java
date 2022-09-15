/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeterinariaDogtor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Ope1 {
    private Conectar cn;
    private String SQL_Insertcliente="insert into cliente (idcliente, nombre, apellido, telefono) values(?,?,?,?)";
    private String SQL_Delete="delete from cliente where  ";
    private String SQL_Insertcitas="insert into citas (idcitas) values(?)";
    private String SQL_Deletecitas="";
    private String SQL_Insertmascota="insert into mascota(idmascota, alias, idcliente, especie, raza, pelo, nacimiento, idveterinario, idservicios, idcitas) values(?,?,?,?,?,?,?,?,?,?)";
    private String SQL_Deletemascota="";
    private String SQL_Insertservicios="insert into servicios(idservicios, hospitalizacion, vacunacion, esterilizacion, peluqueria) values(?,?,?,?,?)";
    private String SQL_Deleteservicios="";
    private String SQL_Insertvet="insert into veteriario(id, nombre, apellido, correo) values(?,?,?,?)";
    private String SQL_Deletevet="";

    private PreparedStatement ST;

    public Ope1() {
        cn = new Conectar();
        ST = null;
    }
    
    public int insertar(int idcliente, String nombre, String apellido, String telefono){
        int res=0;
        try{
            ST = cn.getConnection().prepareStatement(SQL_Insertcliente);
            ST.setInt(1, idcliente);
            ST.setString(2, nombre);
            ST.setString(3, apellido);
            ST.setString(4, telefono);
            
            res = ST.executeUpdate();
            if (res>0)
            {JOptionPane.showMessageDialog(null,"Registrado correctamente");}
        }catch(SQLException e){
            System.out.println("Error "+ e);
        }finally{
            cn.close();
        }
        return res;
    }
    

   
    
    public int insertar2(int idcitas){
        int res=0;
        try{
            ST = cn.getConnection().prepareStatement(SQL_Insertcitas);
            ST.setInt(1, idcitas);
            
            
            res = ST.executeUpdate();
            if (res>0)
            {JOptionPane.showMessageDialog(null,"Registrado correctamente");}
                    
        }catch(SQLException e){
            System.out.println("Error "+ e);
        }finally{
            cn.close();
        }
        return res;
        
    }
    public int insertar3(int idmascota, String alias, String idcliente, String especie, String raza, String pelo, String nacimiento, String idveterinario, String idservicios, String idcitas){
        int res=0;
        try{
        ST = cn.getConnection().prepareStatement(SQL_Insertmascota);
        ST.setInt(1, idmascota);
        ST.setString(2, alias);
        ST.setString(3, idcliente);
        ST.setString(4, especie);
        ST.setString(4, raza);
        ST.setString(4, pelo);
        ST.setString(4, nacimiento);
        ST.setString(4, idveterinario);
        ST.setString(4, idservicios);
        ST.setString(4, idcitas);

        res = ST.executeUpdate();
        if (res>0)
            {JOptionPane.showMessageDialog(null,"Registrado correctamente");}


        }catch(SQLException e){
        System.out.println("Error "+ e);
        }finally{
        cn.close();
        }
        return res;
        }
        public int insertar4(int idservicios, String hospitalizacion, String vacunacion, String esterilizacion, String peluqueria){
                int res=0;
                try{
                ST = cn.getConnection().prepareStatement(SQL_Insertservicios);
                ST.setInt(1, idservicios);
                ST.setString(2, hospitalizacion);
                ST.setString(3, vacunacion);
                ST.setString(4, esterilizacion);
                ST.setString(5, peluqueria);
                res = ST.executeUpdate();



                }catch(SQLException e){
                System.out.println("Error "+ e);
                }finally{
                cn.close();
                }
                return res;
                }
        public int insertar5(int id, String nombre, String apellido, String correo){
            int res=0;
            try{
            ST = cn.getConnection().prepareStatement(SQL_Insertvet);
            ST.setInt(1, id);
            ST.setString(2, nombre);
            ST.setString(3, apellido);
            ST.setString(4, correo);

            res = ST.executeUpdate();
            if (res>0)
            {JOptionPane.showMessageDialog(null,"Registrado correctamente");}


            }catch(SQLException e){
            System.out.println("Error "+ e);
            }finally{
            cn.close();
            }
            return res;
            }







}
    