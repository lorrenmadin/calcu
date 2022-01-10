
package mahasiswa;
import java.sql.*;

public class koneksi {
    public Connection cc;
    public Statement ss;
    public ResultSet rr;
            
public static void main(String args[]){
        try {
            String url ="jdbc:mysql://localhost/mahasiswa";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
        System.out.println("koneksi okey");
        } catch (Exception e){
            System.out.println(e);
            
    }
}  

    void Class() {
        throw new UnsupportedOperationException("tidak mensupport."); //To change body of generated methods, choose Tools | Templates.
    }
}
