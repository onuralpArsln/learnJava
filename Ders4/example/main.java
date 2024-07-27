
import devices.*;
import people.*;
import vehicle.VehicleBase;

public class main {

    public static void main(String[] args) {
        HumanBase testHuman = new HumanBase("test", 21);
        HumanPatient testPatient = new HumanPatient("patient", 31, "headache");

        System.out.println(testHuman.AgeGetter());
        // liskov subs
        // objects of a superclass should be replaceable
        // with objects of its subclasses
        // without affecting the correctness of the program.

        // human base ve human patient methodla düzgün çalışmalı
        Xray testDevice = new Xray();
        testDevice.image(testHuman);
        System.out.println(testHuman.diagnosis);

        testDevice.image(testPatient);
        System.out.println(testPatient.diagnosis);

        VehicleBase testVehicle = new VehicleBase(5, "07 JB 007");
        System.out.println(testVehicle.seatCount);
        System.out.println(testVehicle.licensePlate);
        System.out.println(testVehicle.passengers.length);

        System.out.println(testVehicle.passengers[0]);
        HumanBase testHuman2 = new HumanBase("test2", 22);
        HumanBase testHuman3 = new HumanBase("test3", 23);
        HumanBase testHuman4 = new HumanBase("test4", 24);
        HumanBase testHuman5 = new HumanBase("test5", 25);
        HumanBase testHuman6 = new HumanBase("test6", 25);

        testVehicle.GetInCar(testHuman5);
        testVehicle.GetInCar(testHuman3);
        testVehicle.GetInCar(testHuman4);
        testVehicle.GetInCar(testHuman5);
        testVehicle.GetInCar(testHuman2);
        testVehicle.GetInCar(testHuman6);

        testVehicle.GetOutCar(testHuman5);
        testVehicle.GetOutCar(testHuman3);
        testVehicle.GetOutCar(testHuman4);
        testVehicle.GetOutCar(testHuman2);
        testVehicle.GetOutCar(testHuman5);

    }

}
