package by.mashnyuk.creator;

import by.mashnyuk.entity.Car;
import by.mashnyuk.validator.CarValidator;

public class CarFactory {
    public static Car createCar(long id, String brand, String model, int year, String color, double price, String registrationNumber) {
        Car car = new Car(id, brand, model, year, color, price, registrationNumber);

        if (!CarValidator.isValid(car)) {
            throw new IllegalArgumentException("Invalid car data");
        }
        return car;
    }
}
