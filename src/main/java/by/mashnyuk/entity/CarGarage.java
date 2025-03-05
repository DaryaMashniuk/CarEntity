package by.mashnyuk.entity;

import by.mashnyuk.service.impl.CarServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CarGarage {

    private static final Logger logger = LogManager.getLogger(CarServiceImpl.class);
    private List<Car> cars = new ArrayList<>();

    public boolean addCar(Car car) {
        if (car == null || cars.contains(car)) {
            logger.error("Attempted to add a null car.");
            return false;
        }
        logger.info("Car added: {} {}", car.getBrand(), car.getModel());
        return cars.add(car);

    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public boolean removeCar(Car car){
        if (!cars.contains(car)) {
            logger.error("Attempted to remove a car that is not in the garage");
            return false;
        }
        logger.info("Car removed: {} {}", car.getBrand(), car.getModel());
        return cars.remove(car);

    }

}
