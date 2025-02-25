package by.mashnyuk.validator;
import by.mashnyuk.entity.Car;

public class CarValidator {
    public static final int FIRSTCAR = 1885;
    public static boolean isValid(Car car) {
        return car.getBrand() != null && !car.getBrand().isEmpty() &&
                car.getModel() != null && !car.getModel().isEmpty() &&
                car.getYear() > FIRSTCAR &&
                car.getPrice() >= 0;
    }
}
