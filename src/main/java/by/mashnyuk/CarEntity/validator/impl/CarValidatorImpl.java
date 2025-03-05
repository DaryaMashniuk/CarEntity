package by.mashnyuk.CarEntity.validator.impl;
import by.mashnyuk.CarEntity.entity.Car;
import by.mashnyuk.CarEntity.validator.CarValidator;

import java.util.Calendar;
import java.util.regex.Pattern;

public class CarValidatorImpl implements CarValidator {

    private static final String BRAND_REGEX = "^[A-Za-z0-9 ]+$";
    private static final Pattern BRAND_PATTERN = Pattern.compile(BRAND_REGEX);
    public static final int FIRST_CAR_INVENTED = 1885;


    public static boolean isValid(Car car) {
        CarValidatorImpl validator = new CarValidatorImpl();
        return validator.validate(car);
    }

    @Override
    public boolean validate(Car car) {
        if (car == null) {
            return false;
        }

        return validateBrand(car.getBrand()) &&
                validateModel(car.getModel()) &&
                validateColor(car.getColor()) &&
                validateYear(car.getYear()) &&
                validateRegistrationNumber(car.getRegistrationNumber()) &&
                validatePrice(car.getPrice());
    }

    @Override
    public boolean validateBrand(String brand) {
        return brand != null && !brand.isBlank() && BRAND_PATTERN.matcher(brand).matches();
    }

    @Override
    public boolean validateModel(String model) {
        return model != null && !model.isBlank();
    }

    @Override
    public boolean validateColor(String color) {
        return color != null && !color.isBlank();
    }

    @Override
    public boolean validateRegistrationNumber(String registrationNumber) {
        return registrationNumber != null && !registrationNumber.trim().isEmpty();
    }

    @Override
    public boolean validateYear(int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return year >= FIRST_CAR_INVENTED && year <= currentYear;
    }

    @Override
    public boolean validatePrice(double price) {
        return price >= 0;
    }
}