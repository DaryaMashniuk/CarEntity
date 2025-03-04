package by.mashnyuk.service;

import by.mashnyuk.entity.Car;

import java.util.List;

public interface CarServiceInterface {

    List<Car> getCarsByBrand(String brand);
    List<Car> getCarsByModelOlderThan(String model, int year);
    List<Car> getCarsByYearGreaterThanPrice(int year, double price);

}
