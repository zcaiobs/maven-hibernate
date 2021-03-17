import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.thread.MyThread;
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
    @DisplayName("Running MyThread Test")
    void trheadsTest() throws InterruptedException {
        Thread m1 = new Thread(new MyThread('A', 10), "T1");
        Thread m2 = new Thread(new MyThread('B', 10), "T2");
        Thread m3 = new Thread(new MyThread('C', 10), "T3");
        m1.start();
        m1.join();
        m2.start();
        m3.start();
    }

    @Test
    @DisplayName("Writer and Reader with File Test")
    void WriterAndReaderFileTest() {
        Path file = Paths.get("src/main/resources/document/text.txt");
        byte [] dados = {25, 25, 63, 25, 78};
        try(BufferedOutputStream bw = new BufferedOutputStream( new FileOutputStream(file.toAbsolutePath().toString()));
            BufferedInputStream br = new BufferedInputStream( new FileInputStream(file.toAbsolutePath().toString()))){
            bw.write(dados);
            bw.flush();
            int read;
            while ((read = br.read()) != -1){
                System.out.println(" " + read);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Bundle")
    void bundleTest() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(rb.getString("language"));
        rb = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(rb.getString("language"));
    }

    @Test
    @DisplayName("Test RegEx")
    void RegExTest() {
        String regex = "([jav.])+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("Hello World asdiuh java hhuhsduhsu8hdf husndiufn osdinfoisnubyb");
        while (matcher.find()) {
            if (matcher.group().equals("java")) {
                System.out.println(matcher.group() + " 25 anos!");
            }
        }
    }

    @Test
    @DisplayName("Test StringBuilder")
    void stringBuilderRest() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello World");
        sb.append(" Ok");
        System.out.println(sb);
    }

    @Test
    @DisplayName("Verify collection.")
    void dateTest() {
        System.out.println(new SimpleDateFormat("'São Paulo, 'd 'de 'MMMM 'de 'yyyy").format
                (Calendar.getInstance().getTime()));
    }

    @Test
    @DisplayName("Find all persons.")
    void findAllPersonTest() {
        List<Person> persons = cp.findAll();
        persons.forEach(System.out::println);
    }

    @Test
    @DisplayName("Verify persistence method.")
    void savePersonTest() {
        //Customer c = new Customer("Caio", new Date(), "caio@email.com");
        Date date = Calendar.getInstance().getTime();
        Employee e = new Employee("Superman", date, "Hero");
        cp.save(e);
    }

    @Test
    @DisplayName("Remove person by ID.")
    void RemovePersonTest() {
        Employee e = (Employee) cp.findById(2);
        Assertions.assertTrue(cp.remove(e));
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
        Car c = new Car("X1", "Black", 85000.00, "Flex-fuel");
        // Bike b = new Bike("", "White", 40000.00, "Yamaha");
        cs.save(c);
    }

    @Test
    @DisplayName("Verify persistence method.")
    void findAllTest() {
        List<Vehicle> result = cs.findAll();
        result.forEach(System.out::println);
    }

    @Test
    @DisplayName("Verify persistence method.")
    void findByIdTest() {
        Bike b = (Bike) cs.findById(3);
        System.out.println(b.toString());
    }

    @Test
    @DisplayName("Verify persistence method.")
    void updateTest() {
        Bike b = (Bike) cs.findById(3);
        b.setColor("Blue");
        cs.update(b);
        List<Vehicle> result = cs.findAll();
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
    }

}
