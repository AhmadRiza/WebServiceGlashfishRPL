
package Services;

import Helper.DbHelper;
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

@Path("/history_harga")
public class HistoryHargaSrv {
    @Context
    private UriInfo context;

    private DbHelper db ;

    /** Creates a new instance of HelloWorldResource */
    public HistoryHargaSrv() {
        db = new DbHelper();
    }

    @GET
    @Path("")
    @Produces("application/json")
    public String getJson(
            @QueryParam("kode_barang") @DefaultValue("") String kode
            ){
        return db.getHistoryHarga(kode);
    }

}
