package by.mashnyuk.service;

import by.mashnyuk.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findCarsByBrand(String brand);
    List<Car> findCarsByModelOlderThan(String model, int year);
    List<Car> findCarsByYearGreaterThanPrice(int year, double price);

}