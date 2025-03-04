package by.mashnyuk.service;

import by.mashnyuk.entity.Car;
import by.mashnyuk.util.CarGarage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CarService implements CarServiceInterface {
    private static final Logger logger = LogManager.getLogger(CarService.class);
    private final CarGarage carGarage;

    public CarService(CarGarage carGarage) {
        this.carGarage = carGarage;
    }

    @Override
    public List<Car> getCarsByBrand(String brand) {
        logger.info("Retrieving cars by brand: {}", brand);
        List<Car> result = new ArrayList<>();
        for (Car car : carGarage.getCars()) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        logger.info("Found {} cars for brand: {}", result.size(), brand);
        return result;
    }

    @Override
    public List<Car> getCarsByModelOlderThan(String model, int years) {
        logger.info("Retrieving cars by model: {} older than {} years", model, years);
        List<Car> result = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Car car : carGarage.getCars()) {
            if (car.getModel().equalsIgnoreCase(model) && currentYear - car.getYear() > years) {
                result.add(car);
            }
        }
        logger.info("Found {} cars for model: {} older than {} years", result.size(), model, years);
        return result;
    }

    @Override
    public List<Car> getCarsByYearGreaterThanPrice(int year, double price) {
        logger.info("Retrieving cars from year: {} with price greater than {}", year, price);
        List<Car> result = new ArrayList<>();
        for (Car car : carGarage.getCars()) {
            if (car.getYear() == year && car.getPrice() > price) {
                result.add(car);
            }
        }
        logger.info("Found {} cars from year: {} with price greater than {}", result.size(), year, price);
        return result;
    }
}