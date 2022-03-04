package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.Class;
import java.lang.reflect.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Vehicle {
    String brand;
    int noOfWheels;
    public boolean isRegistred;

    Vehicle() {

    }

    public Vehicle(String brand, int noOfWheel) {
        this.brand = brand;
        this.noOfWheels = noOfWheels;
        this.isRegistred = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public boolean isRegistred() {
        return isRegistred;
    }

    public void setRegistred(boolean isRegistred) {
        this.isRegistred = isRegistred;
    }

    private void displayDrivingOrientation() {
        System.out.println("Driving orientation");
    }

    public void register(String brand, int noOfWheels) {
        this.brand = brand;
        this.noOfWheels = noOfWheels;
        this.isRegistred = true;
        this.displayDrivingOrientation();

        System.out.println(
                this.toString() + " Registered on: " + java.time.LocalDate.now());

    }

    @Override
    public String toString() {
        return "Vehicle [brand=" + brand + ", isRegistred=" + isRegistred + ", noOfWheels=" + noOfWheels + "]";
    }

}

class Car extends Vehicle {
    public String carName;
    Date yearOfManufacture;

    Car() {

    }

    public Car(String brand, int noOfWheel, String carName) {
        super(brand, noOfWheel);
        this.carName = carName;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

        try {
            this.yearOfManufacture = (Date) simpleDateFormat.parse("2021");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Date yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public void registerCar(String carName, Date yearOfManufacture) {
        this.carName = carName;
        this.yearOfManufacture = yearOfManufacture;
        super.register(this.brand, this.noOfWheels);
    }

    @Override
    public String toString() {
        return super.toString() + " Car [carName=" + carName + ", yearOfManufacture=" + yearOfManufacture + "]";
    }

}

public class ReflectionDriver {
    public static void main(String[] args)
            throws ParseException, NoSuchFieldException, IllegalAccessException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date yearOfRegister = (Date) simpleDateFormat.parse("2022");

        Car car = new Car("Ford", 4, "Ecosport");
        Class cls = car.getClass();
        Class supercls = cls.getSuperclass();
        car.registerCar("Ford", yearOfRegister);
        System.out.println("Class name: " + cls.getName());
        System.out.println("Super Class name: " + supercls.getName());
        Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("Constructor name: " + c.getName());

            System.out.println("Parameters: " + c.getParameterCount());
        }
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method name: " + m.getName());

            System.out.println("Parameters: " + m.getParameterCount());

            System.out.println("Return Type: " + m.getReturnType());
        }
        Field field1 = cls.getField("carName");
        Field field2 = cls.getField("isRegistred");

        System.out.println("car name: " + field1.get(car));
        System.out.println("Is registred: " + field2.get(car));
        field1.set(car, "I20");
        field2.set(car, false);
        System.out.println("Modified car name: " + field1.get(car));
        System.out.println("Modified Is registred: " + field2.get(car));
        System.out.println(car);

    }

}
