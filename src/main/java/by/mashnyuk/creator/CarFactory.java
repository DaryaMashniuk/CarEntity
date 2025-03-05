package by.mashnyuk.creator;

import by.mashnyuk.entity.Car;
import by.mashnyuk.validator.impl.CarValidatorImpl;

import java.util.Optional;

public class CarFactory {
    public static Optional<Car> createCar(long id, String brand, String model, int year, String color, double price, String registrationNumber) {
        Car car = new Car(id, brand, model, year, color, price, registrationNumber);

        return CarValidatorImpl.isValid(car) ? Optional.of(car) : Optional.empty();
    }
}
