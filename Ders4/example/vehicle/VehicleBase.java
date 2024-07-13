package vehicle;

import people.*;

public class VehicleBase {

    public HumanBase driver;
    public HumanBase[] passengers;
    public final int seatCount;
    public final String licensePlate;

    public VehicleBase(int count, String license) {
        this.seatCount = count;
        this.licensePlate = license;
        this.passengers = new HumanBase[count - 1];
    }

    public boolean GetInCar(HumanBase passenger) {
        for (int i = 0; i < this.passengers.length; i++) {
            if (this.passengers[i] == null) {
                this.passengers[i] = passenger;
                System.out.println(passenger.name + " arabaya bindi");
                return true;
            } else if (this.passengers[i] == passenger) {
                System.out.println("yolcu zaten arabada");
                return false;
            }
        }
        System.out.println("tüm araba dolu binemedim");
        return false;
    }

}
