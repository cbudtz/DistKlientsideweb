package restServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;

@Path("")
public class Startside {

    @GET
    public String getIndexHtml() throws IOException {
        //Initialize Mustache renderer
//        MustacheFactory mf = new DefaultMustacheFactory();
//        Mustache m = mf.compile("startside.mustache");
//
//        //Set some data
//        HashMap<String, Object> mustacheData = new HashMap<String, Object>();
//        mustacheData.put("servertid", new Date());
//
//        //render template with data
//        StringWriter writer = new StringWriter();
//        m.execute(writer, mustacheData).flush();
//        return writer.toString();
        return null;
    }
}
