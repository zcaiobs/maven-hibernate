package model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle {

    private String fuel;

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Car() {
        super();
    }

    @Override
    public String buy() {
        return "Purchased";
    }

    @Override
    public String sell() {
        return "Selled";
    }

    public Car(String model, String color, Double price, String fuel) {
        super(model, color, price);
        this.fuel = fuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(super.id, car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + super.id +
                ", model='" + super.model + '\'' +
                ", color='" + super.color + '\'' +
                ", price=" + super.price + '\'' +
                ", fuel='" + this.fuel +
                '}';
    }
}
