import model.Bike;
import model.Car;
import model.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.VehiclePersistence;
import service.CrudService;

import java.util.List;

public class CityApplicationTest {

    CrudService<Vehicle> cs = new CrudService<>(new VehiclePersistence());

    @Test
    @DisplayName("Verify persistence method.")
    void saveTest() {
        Car c = new Car("X1","Black",85000.00,"Flex-fuel");
        Bike b = new Bike("", "White", 40000.00, "Yamaha");
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
