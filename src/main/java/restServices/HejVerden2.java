package restServices;

import data.Fejlbesked;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hejverden2")
public class HejVerden2 {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response tjekSvar(@QueryParam("svar") String svar) {
        System.out.println("svaret i HejVerden2 blev angivet til '" + svar + "'");
        if (svar==null) {
          return Response.status(Response.Status.BAD_REQUEST)
                  .entity(new Fejlbesked("Du skal give parameteren 'svar' i URL'en"))
                  .build();
        }

        if (!svar.toLowerCase().startsWith("hvergang")) {
          return Response.status(Response.Status.BAD_REQUEST)
                  .entity(new Fejlbesked("Beklager, '" + svar + "' er ikke korrekt."))
                  .build();
        }

        return Response.ok().entity("Helt rigtigt!").build();
    }
}