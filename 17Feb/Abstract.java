abstract class Vehicle{
    abstract void drive();
    abstract void steeringMechanism();
    void start(){
        System.out.println("Veicle started");
    }
    void stop(){
        System.out.println("Veicle stopped");
    }

}
class Bike extends Vehicle{
    void drive(){
        System.out.println("Drive method of Bike class");
    }
    void steeringMechanism(){
        System.out.println("Steering mechanism method of Bike class");
    }

}
class Car extends Vehicle{
    void drive(){
        System.out.println("Drive method of Car class");
    }
    void steeringMechanism(){
        System.out.println("Steering mechanism method of Car class");
    }

}
public class Abstract{
    public static void main(String[] args) {
        Bike bike = new Bike();
        Car car = new Car();
        bike.drive();
        car.drive();
        bike.steeringMechanism();
        car.steeringMechanism();
    }
}