package by.mashnyuk.CarEntity.service;

import by.mashnyuk.CarEntity.creator.CarFactory;
import by.mashnyuk.CarEntity.entity.Car;
import by.mashnyuk.CarEntity.entity.CarGarage;
import by.mashnyuk.CarEntity.service.impl.CarServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class CarServiceImplTest {
    private static final Logger logger = LogManager.getLogger(CarServiceImplTest.class);
    private CarServiceImpl carServiceImpl;
    private CarGarage carGarage;
    private SoftAssert softAssert;

    @BeforeClass
    public void initialSetUp() {
        carServiceImpl = new CarServiceImpl(carGarage);
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void setUp() {
        carGarage = new CarGarage();
    }

    @Test
    public void givenValidCar_whenAddCar_thenCarIsAdded() {
        logger.info("Testing adding a valid car to CarService");

        Optional<Car> car1 = CarFactory.createCar(1, "Toyota", "Camry", 2020, "Red", 30000, "XYZ123");
        car1.ifPresent(car -> carGarage.addCar(car));

        List<Car> cars = carServiceImpl.findCarsByBrand("Toyota");
        softAssert.assertEquals(cars.size(), 1);
        softAssert.assertEquals(cars.get(0).getModel(), "Camry");
        softAssert.assertAll();
    }

    @Test
    public void givenNoCars_whenGetCarsByBrand_thenReturnsEmptyList() {
        logger.info("Testing getting cars by brand when no cars are present");

        List<Car> cars = carServiceImpl.findCarsByBrand("BMW");
        assertTrue(cars.isEmpty(), "Expected empty list for non-existent brand");
        logger.info("No cars found for brand: BMW");
    }

    @Test
    public void givenCars_whenGetCarsByModelOlderThan_thenReturnsCorrectCars() {
        logger.info("Testing getting cars by model older than specified years");

        Optional<Car> car1 = CarFactory.createCar(1, "Honda", "Civic", 2016, "Black", 15000, "LMN789");
        car1.ifPresent(car -> carGarage.addCar(car));
        Optional<Car> car2 = CarFactory.createCar(2, "Honda", "Accord", 2015, "White", 18000, "OPQ012");
        car2.ifPresent(car -> carGarage.addCar(car));

        List<Car> result = carServiceImpl.findCarsByModelOlderThan("Civic", 5);
        softAssert.assertEquals(result.size(), 1);
        softAssert.assertEquals(result.get(0).getModel(), "Civic");
        softAssert.assertAll();
    }

    @Test
    public void givenCars_whenGetCarsByYearGreaterThanPrice_thenReturnsCorrectCars() {
        logger.info("Testing getting cars from year with price greater than specified");

        Optional<Car> car1 = CarFactory.createCar(1, "Ford", "Focus", 2021, "Green", 22000, "RST345");
        car1.ifPresent(car -> carGarage.addCar(car));
        Optional<Car> car2 = CarFactory.createCar(2, "Ford", "Mustang", 2021, "Yellow", 29000, "UVW678");
        car2.ifPresent(car -> carGarage.addCar(car));

        List<Car> result = carServiceImpl.findCarsByYearGreaterThanPrice(2021, 25000);
        softAssert.assertEquals(result.size(), 1);
        softAssert.assertEquals(result.get(0).getModel(), "Mustang");
        softAssert.assertAll();
        logger.info("Found car with price greater than 25000: {}", result.get(0).getModel());
    }

    @Test
    public void givenCars_whenGetCarsByBrand_thenReturnsCorrectCars() {
        Optional<Car> car1 = CarFactory.createCar(1, "Toyota", "Camry", 2020, "Red", 30000, "XYZ123");
        car1.ifPresent(car -> carGarage.addCar(car));
        Optional<Car> car2 = CarFactory.createCar(2, "Toyota", "Corolla", 2018, "Blue", 20000, "ABC456");
        car2.ifPresent(car -> carGarage.addCar(car));

        List<Car> result = carServiceImpl.findCarsByBrand("Toyota");

        softAssert.assertEquals(result.size(), 2);
        softAssert.assertEquals(result.get(0).getModel(), "Camry");
        softAssert.assertEquals(result.get(1).getModel(), "Corolla");
        softAssert.assertAll();
        logger.info("Test passed: getCarsByBrand");
    }
}