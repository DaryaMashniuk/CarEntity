package by.mashnyuk.entity;

import java.util.Objects;

public class Car {
    private final long id;
    private final String brand;
    private final String model;
    private final int year;
    private final String color;
    private final double price;
    private final String registrationNumber;

    public Car(long id, String brand, String model, int year, String color, double price, String registrationNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && year == car.year &&
                Double.compare(price, car.price) == 0 &&
                brand.equals(car.brand) && model.equals(car.model) &&
                color.equals(car.model) && registrationNumber.equals(car.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, year, color, price, registrationNumber);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", year=").append(year);
        sb.append(", color='").append(color).append('\'');
        sb.append(", price=").append(price);
        sb.append(", registrationNumber='").append(registrationNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
