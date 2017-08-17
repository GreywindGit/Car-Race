package eu.greywind.carrace;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private final static String BOLD = "\u001B[1m";
    private final static String RESET = "\u001B[0m";
    private final static int MAX_LAPS = 50;
    private final static double RAIN_PERCENTAGE = .3;
    private final static double LIMIT_PERCENTAGE = .3;
    private static int rainyLaps = 0, limitedLaps = 0;

    public static void main(String[] args) {
        ArrayList<Vehicle> racers = createVehicles();
        simulateRace(racers);
        printRaceResults(racers);
        declareWinners(racers);
        viewStatistics();

    }

    private static boolean isRaining() {
        return (Math.random() < RAIN_PERCENTAGE);
    }

    private static boolean isSpeedLimit() {
        return (Math.random() < LIMIT_PERCENTAGE);
    }

    private static ArrayList createVehicles() {
        ArrayList<Vehicle> racingVehicles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            racingVehicles.add(new Motorcycle());
            racingVehicles.add(new Truck());
            racingVehicles.add(new Car());
        }
        return racingVehicles;
    }

    private static void simulateRace(ArrayList<Vehicle> racers) {
        boolean rainy, limit;

        for (int laps = 0; laps < MAX_LAPS; laps++) {
            rainy = isRaining();
            limit = isSpeedLimit();
            if (rainy) rainyLaps++;
            if (limit) limitedLaps++;
            for (Vehicle racer : racers) {
                if (racer.type.equals("Motorcycle")) {
                    if (rainy) {
                        racer.limitSpeed();
                    } else {
                        racer.setNormalSpeed();
                    }
                }
                if (racer.type.equals("Car")) {
                    if (limit) {
                        racer.limitSpeed();
                    } else {
                        racer.setNormalSpeed();
                    }
                }
                racer.moveForAnHour();
            }
        }
    }

    private static void printRaceResults(ArrayList<Vehicle> racers) {
        System.out.println(String.format("%-25s| %-12s|%18s", "Name", "Type", "Distance travelled"));
        System.out.println("----------------------------------------------------------");
        for (Vehicle racer : racers) {
            System.out.println(String.format("%-25s| %-12s|%10d km", racer.name, racer.type, racer.distanceTraveled));
        }
    }

    private static void declareWinners(ArrayList<Vehicle> racers) {
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Vehicle> winners = new ArrayList<>();

        for (Vehicle racer : racers) {
            if (!distances.contains(racer.distanceTraveled))
            distances.add(racer.distanceTraveled);
        }
        distances.sort(Collections.reverseOrder());
        for (int i = 0; i < 3; i++) {
            for (Vehicle racer : racers) {
                if (racer.distanceTraveled == distances.get(i)) {
                    winners.add(racer);
                }
            }
        }
        System.out.println(BOLD + "\nThe winners are...\n" + RESET);
        for (int i = 0; i < 3; i++) {
            String suffix = (i == 0) ? "st" : (i == 1) ? "nd" : "rd";
            System.out.println(String.format("%s%s place: %s (%d km)", i + 1, suffix, winners.get(i).name,
                                             winners.get(i).distanceTraveled));
        }
    }

    private static void viewStatistics() {
        System.out.println(BOLD + "\nStatistics: " + RESET);
        System.out.println(String.format("\n- It rained %d times out of %d.", rainyLaps, MAX_LAPS));
        System.out.println(String.format("- There were %d truck breakdowns.", Truck.getBreakdowns()));
        System.out.println(String.format("- Speed limit was in effect for %d laps in total.", limitedLaps));
    }
}
