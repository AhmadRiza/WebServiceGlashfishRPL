
package Services;

import Helper.InsertDBHelper;
import Helper.ReadDBHelper;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author AhmadRiza
 */

@Path("/add_harga")
public class AddHarga {
    @Context
    private UriInfo context;

    private InsertDBHelper db ;

    /** Creates a new instance of HelloWorldResource */
    public AddHarga() {
        db = new InsertDBHelper();
    }

    @POST
    @Path("")
    @Consumes("application/json")
    public String addHarga(
            @FormParam("nama") @DefaultValue("") String harga,
            @FormParam("kode") @DefaultValue("") String kode
            ){

        if(kode.equals("")|| harga.equals("")) return "error";

        return db.insertHarga(kode, harga);

    }

}
