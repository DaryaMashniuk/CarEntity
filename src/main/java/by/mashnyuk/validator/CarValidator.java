package by.mashnyuk.validator;

import by.mashnyuk.entity.Car;

public interface CarValidator {

    boolean validate(Car car);
    boolean validateBrand(String brand);
    boolean validateModel(String model);
    boolean validateColor(String color);
    boolean validateRegistrationNumber(String registrationNumber);
    boolean validateYear(int year);
    boolean validatePrice(double price);
}
