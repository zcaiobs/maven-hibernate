package app.model.person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Person{
    private String occupation;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Employee() {
        super();
    }

    public Employee(String name, Date birthDate, String occupation) {
        super(name, birthDate);
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(super.id, employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", occupation='" + occupation + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
