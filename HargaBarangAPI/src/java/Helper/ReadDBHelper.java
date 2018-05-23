/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Helper;

import Model.Barang;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ahmad Riza
 */
public class ReadDBHelper extends MysqlConnection{

    Statement stat;
    ResultSet result;
    String query, message;

    public ReadDBHelper() {
        super();
    }

    private void reset(){
        try {
            query = null;
            message = null;
            if(result!=null)result.close();
            if(stat!=null)stat.close();
          
        } catch (SQLException ex) {
            Logger.getLogger(ReadDBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCurrentHarga(String kode){
        openConection();
         query =  "SELECT * \n"
                + "FROM barang\n"
                + "INNER JOIN harga ON harga.kode_barang = barang.kode_barang \n"
                + "WHERE harga.kode_barang = '"+kode+"' "
                + "GROUP BY harga.tgl DESC";
        if(executeQuery()){
            try {
                if (result.next()) {
                    Gson gb = new GsonBuilder().create();
                    Barang b = new Barang(
                            result.getString("kode_barang"),
                             result.getString("nama_barang"),
                             result.getString("tgl"),
                             result.getString("satuan_barang"),
                             result.getDouble("harga"));
                    return gb.toJson(b).toString();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ReadDBHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "error";
    }

    public String getHistoryHarga(String kode){
        openConection();
        try {

            query = String.format("SELECT * FROM barang WHERE kode_barang = '%s'", kode);
            JsonObject response = new JsonObject();

            if (!executeQuery()) {
                return "error";
            }
//        parse res `1
            if (result.next()) {
                response.addProperty("kode", result.getString("kode_barang"));
                response.addProperty("nama", result.getString("nama_barang"));
                response.addProperty("satuan", result.getString("satuan_barang"));
            }else return "error";

            reset();
            query = String.format("SELECT harga,tgl FROM harga WHERE kode_barang = '%s'", kode);
            if(!executeQuery()) return "error";

//            parse res 2
            JsonArray history = new JsonArray();
            JsonObject h;
            while(result.next()){
                h = new JsonObject();
                h.addProperty("harga", result.getDouble("harga"));
                h.addProperty("tgl", result.getString("tgl"));
                history.add(h);
            }
            response.add("history", history);

            return response.toString();
        } catch (SQLException ex) {
            Logger.getLogger(ReadDBHelper.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }
    }

    public boolean getCurrentHarga(){
        openConection();
        query =  "SELECT * \n"
                + "FROM barang\n"
                + "INNER JOIN harga ON harga.kode_barang = barang.kode_barang \n"
                + "GROUP BY harga.tgl DESC";
        return executeQuery();
    }

    public boolean executeQuery(){
        try {
            stat = connect.createStatement();
            result = stat.executeQuery(query);
        } catch (SQLException ex) {
            message = "ERR! "+ex.getMessage();
            return false;
        }
        return true;
    }

    public String getHistoryHarga(){
        query ="";


        return "ERROR 505";
    }

    public String getResultJSON(){
        String jsonResult = null;
        ArrayList<Barang> listBarang = new ArrayList();
        Gson gsonBuilder = new GsonBuilder().create();

        try {
            Barang barang;
            while (result.next()) {
                barang = new Barang(
                        result.getString("kode_barang"),
                        result.getString("nama_barang"),
                        result.getString("tgl"),
                        result.getString("satuan_barang"),
                        result.getDouble("harga"));
                listBarang.add(barang);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadDBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsonResult = gsonBuilder.toJson(listBarang);

        return  jsonResult;
    }

}
