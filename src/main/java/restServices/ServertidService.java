package restServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("servertid")
public class ServertidService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServertid(){
        System.out.println("servertidService.getServertid() kaldt");
        return Response.ok()
                .entity("{\"servertid\":\"" +new Date().toString() + "\"}")
                .build();
    }
}
