package model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("Bike")
public class Bike extends Vehicle {

    private String brand;

    public Bike() {
        super();
    }

    public Bike(String model, String color, Double price, String brand) {
        super(model, color, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return Objects.equals(super.id, bike.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.id);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public String buy() {
        return "Purchased";
    }

    @Override
    public String sell() {
        return "Selled";
    }
}
