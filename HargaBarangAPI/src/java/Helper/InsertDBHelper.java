/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad Riza
 */
public class InsertDBHelper extends MysqlConnection {

    PreparedStatement pStat;
    String query, message;

    @Override
    public void closeConnection() {
        try {
            if (pStat != null) {
                pStat.close();
            }
            message = null;
            query = null;
            super.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(InsertDBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String insertBarang(String kode, String nama, String satuan) {
        openConection();
        try {
            query = "INSERT INTO barang VALUES (?,?,?)";
            pStat = connect.prepareStatement(query);
            pStat.setString(1, kode);
            pStat.setString(2, nama);
            pStat.setString(3, satuan);
            pStat.executeUpdate();
        } catch (SQLException ex) {
            message = "INSERT FAILED! " + ex.getMessage();
            return message;
        } finally {
            closeConnection();
        }
        return "success";
    }

    public String insertHarga(String kode, String harga) {
        if(!validateKode(kode)) return "Invalid kode";
        openConection();
        try {
            query = "INSERT INTO harga VALUES (?,default,?)";
            pStat = connect.prepareStatement(query);
            pStat.setString(1, kode);
            pStat.setDouble(2, Double.parseDouble(harga));
            pStat.executeUpdate();
        } catch (SQLException ex) {
            message = "INSERT FAILED! " + ex.getMessage();
            return message;
        } finally {
            closeConnection();
        }
        return "success";
    }

    private boolean validateKode(String kode) {
        try {
            openConection();
            ResultSet res;
            Statement st;
            String sql = "SELECT kode_barang from barang where kode_barang = '%s'";
            st = connect.createStatement();
            res = st.executeQuery(String.format(sql, kode));
            if (res.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertDBHelper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            closeConnection();
        }

    }
}
