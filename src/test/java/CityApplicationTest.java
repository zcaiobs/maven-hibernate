import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import app.model.person.Employee;
import app.model.person.Person;
import app.model.vehicle.Bike;
import app.model.vehicle.Car;
import app.model.vehicle.Vehicle;
import app.repository.PersonPersistence;
import app.repository.VehiclePersistence;
import app.service.CrudService;

public class CityApplicationTest {

    CrudService<Vehicle> cs = new CrudService<>(new VehiclePersistence());
    CrudService<Person> cp = new CrudService<>(new PersonPersistence());

    @Test
    @DisplayName("Verify collection.")
    void teste() {

    }

    @Test
    @DisplayName("Verify persistence method.")
    void findAllPersonTest() {
        List<Person> persons = cp.findAll();
        persons.forEach(System.out::println);
    }

    @Test
    @DisplayName("Verify persistence method.")
    void savePersonTest() {
        //Customer c = new Customer("Caio", new Date(), "caio@email.com");
        Employee e = new Employee("Flash", new Date(), "Hero");
        cp.save(e);
        cp.close();
    }

    @Test
    @DisplayName("Verify érsistence method.")
    void findPersonTest() {
        Employee e = (Employee) cp.findById(2);
        System.out.println(e.toString());
    }

    @Test
    @DisplayName("Verify persistence method.")
    void saveTest() {
        Car c = new Car("X1","Black",85000.00,"Flex-fuel");
       // Bike b = new Bike("", "White", 40000.00, "Yamaha");
        cs.save(c);
        cs.close();
    }

    @Test
    @DisplayName("Verify persistence method.")
    void findAllTest() {
        List<Vehicle> result = cs.findAll();
        cs.close();
        result.forEach(System.out::println);
    }

    @Test
    @DisplayName("Verify persistence method.")
    void findByIdTest() {
        Bike b = (Bike) cs.findById(3);
        cs.close();
        System.out.println(b.toString());
    }

    @Test
    @DisplayName("Verify persistence method.")
    void updateTest() {
        Bike b = (Bike) cs.findById(3);
        b.setColor("Blue");
        cs.update(b);
        List<Vehicle> result = cs.findAll();
        cs.close();
        result.forEach(System.out::println);
    }

    @Test
    @DisplayName("Verify persistence method.")
    void removeTest() {
        List<Vehicle> result1 = cs.findAll();
        result1.forEach(System.out::println);
        Car c = (Car) cs.findById(2);
        cs.remove(c);
        List<Vehicle> result2 = cs.findAll();
        result2.forEach(System.out::println);
        Assertions.assertNotEquals(result1, result2);
        cs.close();
    }

}
