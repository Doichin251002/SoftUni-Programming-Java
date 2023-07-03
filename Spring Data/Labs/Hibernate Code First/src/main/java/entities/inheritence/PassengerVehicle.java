package entities.inheritence;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PassengerVehicle extends Vehicle {
    private int passengerCapacity;

    public PassengerVehicle() {}

    public PassengerVehicle(int numberOfPassengers) {
        this.passengerCapacity = numberOfPassengers;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
