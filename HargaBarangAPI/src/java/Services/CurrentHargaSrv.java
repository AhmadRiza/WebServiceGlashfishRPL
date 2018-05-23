package Services;

import Helper.ReadDBHelper;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author AhmadRiza
 */
@Path("/cur_harga")
public class CurrentHargaSrv {

    @Context
    private UriInfo context;
    private ReadDBHelper db;

    /** Creates a new instance of HelloWorldResource */
    public CurrentHargaSrv() {
        db = new ReadDBHelper();
    }

    @GET
    @Path("")
    @Produces("application/json")
    public String getXml(@QueryParam("kode_barang") @DefaultValue("") String kode) {
        if (kode.equals("")) {
            if (db.getCurrentHarga()) {
                return db.getResultJSON();
            } else {
                return "505 ERROR";
            }
        }else{
            
            return db.getCurrentHarga(kode);
            
        }


    }
}
