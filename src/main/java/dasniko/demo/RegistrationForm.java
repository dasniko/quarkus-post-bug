package dasniko.demo;

import io.quarkus.qute.TemplateData;
import lombok.Data;

import javax.ws.rs.FormParam;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@Data
@TemplateData
public class RegistrationForm {
    @FormParam("eventId")
    public String eventId;
    @FormParam("name")
    public String name;
    @FormParam("email")
    public String email;
}
