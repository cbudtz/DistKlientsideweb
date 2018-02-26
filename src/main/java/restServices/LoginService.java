package restServices;

import data.Fejlbesked;
import data.LoginData;
import data.Bruger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")

public class LoginService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response doLogin(LoginData loginData) {
        System.out.println("loginService.doLogin() kaldt af "+loginData.getBrugernavn());
        if (loginData.getBrugernavn().equals("admin") && loginData.getPassword().equals("123456")){
            //Login ok
            return Response.ok().entity(new Bruger("admin","Administrator")).build();
        } else {
            //Login bad
            return Response.status(Response.Status.UNAUTHORIZED).entity(new Fejlbesked("Forkert brugernavn/password (prøv med admin/123456)")).build();
        }
    }
}
