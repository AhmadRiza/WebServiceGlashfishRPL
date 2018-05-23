
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

@Path("/add_barang")
public class AddBarang {
    @Context
    private UriInfo context;

    private InsertDBHelper db ;

    /** Creates a new instance of HelloWorldResource */
    public AddBarang() {
        db = new InsertDBHelper();
    }

    @POST
    @Path("")
    @Consumes("application/json")
    public String addBarang(
            @FormParam("nama") @DefaultValue("") String nama,
            @FormParam("kode") @DefaultValue("") String kode,
            @FormParam("satuan") @DefaultValue("") String satuan
            ){

        if(nama.equals("")||kode.equals("")||satuan.equals("")) return "error";

        return db.insertBarang(kode, nama, satuan);
    }

}
