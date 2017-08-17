package eu.greywind.carrace;

abstract class Vehicle {
    String name, type;
    int distanceTraveled;

    abstract void moveForAnHour();
    abstract void limitSpeed();
    abstract void setNormalSpeed();
}
