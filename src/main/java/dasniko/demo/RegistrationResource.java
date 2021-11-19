package dasniko.demo;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Path("reg")
@Produces(MediaType.TEXT_HTML)
public class RegistrationResource {

    @Inject
    Template registration;
    @Inject
    Template thanks;

    @GET
    public TemplateInstance getForm() {
        RegistrationForm form = new RegistrationForm();
        form.setEventId("1234567890");
        form.setName("John Doe");
        form.setEmail("john.doe@example.com");
        return registration.data("form", form);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public TemplateInstance postForm(@BeanParam RegistrationForm registrationForm) {
        log.info(registrationForm.toString());
        return thanks.data("reg", registrationForm);
    }

}
