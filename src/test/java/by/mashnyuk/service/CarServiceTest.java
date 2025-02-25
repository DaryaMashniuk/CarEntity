package by.mashnyuk.service;

import by.mashnyuk.creator.CarFactory;
import by.mashnyuk.entity.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CarServiceTest {
    private static final Logger logger = LogManager.getLogger(CarServiceTest.class);
    private CarService carService;

    @BeforeMethod
    public void setUp() {
        carService = new CarService(); // Инициализация нового экземпляра перед каждым тестом
    }

    @Test
    public void givenValidCar_whenAddCar_thenCarIsAdded() {
        logger.info("Testing adding a valid car to CarService");

        Car car = new Car(1, "Toyota", "Camry", 2020, "Red", 30000, "XYZ123");
        carService.addCar(car);

        List<Car> cars = carService.getCarsByBrand("Toyota");
        assertEquals(cars.size(), 1);
        assertEquals(cars.get(0).getModel(), "Camry");
        logger.info("Successfully added car: {} {}", car.getBrand(), car.getModel());
    }

    @Test
    public void givenNoCars_whenGetCarsByBrand_thenReturnsEmptyList() {
        logger.info("Testing getting cars by brand when no cars are present");

        List<Car> cars = carService.getCarsByBrand("BMW");
        assertTrue(cars.isEmpty(), "Expected empty list for non-existent brand");
        logger.info("No cars found for brand: BMW");
    }

    @Test
    public void givenCars_whenGetCarsByModelOlderThan_thenReturnsCorrectCars() {
        logger.info("Testing getting cars by model older than specified years");

        Car car1 = new Car(1, "Honda", "Civic", 2016, "Black", 15000, "LMN789");
        Car car2 = new Car(2, "Honda", "Accord", 2015, "White", 18000, "OPQ012");
        carService.addCar(car1);
        carService.addCar(car2);

        List<Car> result = carService.getCarsByModelOlderThan("Civic", 5);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getModel(), "Civic");
        logger.info("Found car older than 5 years: {}", result.get(0).getModel());
    }

    @Test
    public void givenCars_whenGetCarsByYearGreaterThanPrice_thenReturnsCorrectCars() {
        logger.info("Testing getting cars from year with price greater than specified");

        Car car1 = new Car(1, "Ford", "Focus", 2021, "Green", 22000, "RST345");
        Car car2 = new Car(2, "Ford", "Mustang", 2021, "Yellow", 29000, "UVW678");
        carService.addCar(car1);
        carService.addCar(car2);

        List<Car> result = carService.getCarsByYearGreaterThanPrice(2021, 25000);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getModel(), "Mustang");
        logger.info("Found car with price greater than 25000: {}", result.get(0).getModel());
    }

    @Test
    public void givenCars_whenGetCarsByBrand_thenReturnsCorrectCars() {
        Car car1 = CarFactory.createCar(1, "Toyota", "Camry", 2020, "Red", 30000, "XYZ123");
        Car car2 = CarFactory.createCar(2, "Toyota", "Corolla", 2018, "Blue", 20000, "ABC456");
        carService.addCar(car1);
        carService.addCar(car2);

        List<Car> result = carService.getCarsByBrand("Toyota");

        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getModel(), "Camry");
        assertEquals(result.get(1).getModel(), "Corolla");
        logger.info("Test passed: getCarsByBrand");
    }
}