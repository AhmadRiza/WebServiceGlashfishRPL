/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad Riza
 */
public class MysqlConnection {

    private final String URL= "jdbc:mysql://localhost/harga_barang";
    private final String USER= "root";
    private final String PASS= "";

    protected Connection connect = null;

    public MysqlConnection() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

    }

    protected void openConection(){
        if(connect != null) return ;
        try {
            connect = DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException ex) {
            Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }


}