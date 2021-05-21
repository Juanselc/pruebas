
package modelo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 public class conexion {
    
    private String base = "usuarios";
    private String url = "jdbc:mysql://127.0.0.1/"+ base;
    private String usuario = "root";
    private String password = "";
    private Connection con = null;
    
    public Connection getConexion (){
                
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            
           
            
        } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
        
    }
    
        
          
   

  

    
    
    

}
