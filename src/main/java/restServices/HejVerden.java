package restServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hejverden")
public class HejVerden {
    @GET
    public String lavHtml(){
        System.out.println("Hej Verden!");
        System.out.println("Hvornår smager en Tuborg bedst?");
        System.out.println("Hvergang!");
        return "{text: 'Hej verden! <br/>Hvornår smager en Tuborg bedst?', svar: 'Hvergang'}";
    }
}
