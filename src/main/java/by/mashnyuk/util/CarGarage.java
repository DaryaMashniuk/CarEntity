package by.mashnyuk.util;

import by.mashnyuk.entity.Car;
import by.mashnyuk.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CarGarage {

    private static final Logger logger = LogManager.getLogger(CarService.class);
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        if (car == null) {
            logger.error("Attempted to add a null car.");
            throw new IllegalArgumentException("Car cannot be null");
        }
        if (cars.contains(car)) {
            logger.error("Attempted to add a duplicate car {} {}.", car.getBrand(),car.getModel() );
            throw new IllegalArgumentException("Car is already in the garage");
        }
        cars.add(car);
        logger.info("Car added: {} {}", car.getBrand(), car.getModel());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void removeCar(Car car){
        if (!cars.contains(car)) {
            logger.error("Attempted to remove a car that is not in the garage");
            throw new IllegalArgumentException("Car is not in the garage");
        }
        cars.remove(car);
        logger.info("Car removed: {} {}", car.getBrand(), car.getModel());
    }

}
