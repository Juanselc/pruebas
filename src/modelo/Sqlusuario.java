
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 public class Sqlusuario extends conexion { 

     public boolean resgistrar (usuario usr){
         
         PreparedStatement Ps = null;
         Connection con = getConexion ();
         
         String sql = "INSERT INTO usuario (correo, nombre, edad, sexo, cargo, salario, password) VALUES(?,?,?,?,?,?,?)";
         
         try {
             Ps = con.prepareStatement(sql);
             Ps.setString(1, usr.getCorreo());
             Ps.setString(2, usr.getNombre());
             Ps.setString(3, usr.getEdad());
             Ps.setString(4, usr.getSexo());
             Ps.setString(5, usr.getCargo());
             Ps.setString(6, usr.getSalario());
             Ps.setString(7, usr.getPassword());
             Ps.execute();
             return true;
             
                                
           } catch (SQLException ex) {
             Logger.getLogger(Sqlusuario.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
               
     }  
     
     public int existeCorreo (String correo){
         PreparedStatement Ps = null;
         ResultSet rs = null;
         Connection con = getConexion ();
                  
         String sql ="SELECT COUNT(id) FROM `usuario` WHERE correo = '?'";
         
         try {
             Ps = con.prepareStatement(sql);
             Ps.setString(2, correo);
             rs = Ps.executeQuery();
             
             if (rs.next()){
                 return rs.getInt(1);
             }
              return 2;      
                         
                                
           } catch (SQLException ex) {
             Logger.getLogger(Sqlusuario.class.getName()).log(Level.SEVERE, null, ex);
             return 2;
         }
               
     }  
     
     public boolean esEmail (String correo){     
     Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

     Matcher mather = pattern.matcher(correo);
     return mather.find();
     }
     
     public boolean login (usuario usr){
         PreparedStatement Ps = null;
         ResultSet rs = null;
         Connection con = getConexion ();
         
         String sql ="SELECT * FROM `usuario` WHERE correo = '?'";
         
         try {
             Ps = con.prepareStatement(sql);
             Ps.setString(1, usr.getCorreo());
             rs = Ps.executeQuery();

             if (rs.next()) {

                 if (usr.getPassword().equals(rs.getString(8))) {
//                     usr.setId(rs.getInt(1));
                     usr.setCorreo(rs.getString(2));
                     return true;
                 } else {
                     return false;
                 }

             }
             return false;

         } catch (SQLException ex) {
             Logger.getLogger(Sqlusuario.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
     }
     public boolean modificar(usuario usr){
         
         PreparedStatement Ps = null;
         Connection con = getConexion ();
         
         String sql = "UPDATE 'usuarios' SET correo =?, nombre=?, edad=?, sexo=?, cargo=?, salario=?, password=? ";
         
         try {
             
             Ps = con.prepareStatement(sql);
             Ps.setString(1, usr.getCorreo());
             Ps.setString(2, usr.getNombre());
             Ps.setString(3, usr.getEdad());
             Ps.setString(4, usr.getSexo());
             Ps.setString(5, usr.getCargo());
             Ps.setString(6, usr.getSalario());
             Ps.setString(7, usr.getPassword());
             Ps.executeUpdate();
             return true;
             
                                
           } catch (SQLException ex) {
             Logger.getLogger(Sqlusuario.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
               
     }  
     
    
     }  
     
 