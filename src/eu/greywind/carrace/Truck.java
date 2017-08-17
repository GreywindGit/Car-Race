package eu.greywind.carrace;

import java.util.HashSet;
import java.util.Set;

class Truck extends Vehicle {
    private final static double BREAKDOWN_PERCENTAGE = .05;
    private int speed;
    private static Set<String> truckClones = new HashSet<>();
    private int brokenDown = 0;
    private static int breakdowns = 0;

    Truck() {
        this.name = generateName();
        this.type = "Truck";
        this.distanceTraveled = 0;
        this.speed = 100;
    }

    private String generateName() {
        String truckName;
        do {
           truckName = Integer.toString( (int) Math.floor(Math.random() * 1000) + 1);
        } while (truckClones.contains(truckName));
        truckClones.add(truckName);
        return truckName;
    }

    void moveForAnHour() {
        switch (brokenDown) {
            case 1:
                brokenDown++;
                break;
            case 2:
                brokenDown = 0;
                break;
            default:
                if (isBrokenDown()) {
                    brokenDown++;
                    breakdowns++;
                }
                break;
        }
        if (brokenDown > 0) {
            limitSpeed();
        } else {
            setNormalSpeed();
        }
        distanceTraveled += speed;
    }

    private boolean isBrokenDown() {
        return (Math.random() < BREAKDOWN_PERCENTAGE);
    }

    void limitSpeed() {
        speed = 0;
    }

    void setNormalSpeed() {
        speed = 100;
    }

    static int getBreakdowns() {
        return breakdowns;
    }

}
