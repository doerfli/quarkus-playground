package li.doerf.person;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") String name) {
        Person greeting = new Person();
        greeting.name = name;
        greeting.persist();
        return "Person " + name;
    }

    @GET
    @Path("names")
    @Produces(MediaType.TEXT_PLAIN)
    public String names() {
        List<Person> persons = Person.listAll();
        String names = persons.stream().map(g -> g.name)
                .collect(Collectors.joining(", "));
        return "I've said person to " + names;
    }
}
