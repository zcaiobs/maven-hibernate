package app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import app.model.person.Person;
import app.model.vehicle.Vehicle;
import app.repository.PersistenceRepository;
import app.repository.PersonPersistence;
import app.repository.VehiclePersistence;
import app.service.CrudService;

@Controller
public class CityController {

    PersistenceRepository<Person> cp = new PersonPersistence();
    CrudService<Vehicle> cv = new CrudService<>(new VehiclePersistence());

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/service")
    public String service(ModelMap model) {
        List<Person> persons = cp.findAll();
        model.addAttribute("persons", persons);
        List<Vehicle> vehicles = cv.findAll();
        model.addAttribute("vehicles", vehicles);
        return "service";
    }

}
