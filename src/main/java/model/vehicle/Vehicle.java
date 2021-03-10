package model.vehicle;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 255, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Vehicle")
public abstract class Vehicle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected Integer id;
    protected String model;
    protected String color;
    protected Double price;

    public Vehicle(String model, String color, Double price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public Vehicle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public abstract String buy();

    public abstract String sell();
}
