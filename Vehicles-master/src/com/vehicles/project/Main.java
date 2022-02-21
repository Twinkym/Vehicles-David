package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String[] data = askCarPlateBrandColor();
        Car car;
        Bike bike;
        try {
            bike = new Bike(data[0], data[1], data[2]);
            System.out.println("Adding front wheels. ");
            List<Wheel> wheelsBikeFront = orderFrontBikeWheel();
            addFrontBikeWheel(bike, wheelsBikeFront);

            System.out.println("Adding back wheels. ");
            List<Wheel> wheelsBikeRear = orderRearBikeWheel();
            addRearBikeWheels(bike, wheelsBikeRear);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            car = new Car(data[0], data[1], data[2]);
            System.out.println("Adding front wheels. ");
            List<Wheel> wheelFront = orderFrontWheels();
            addFrontWheels(car, wheelFront);

            System.out.println("Adding back wheels. ");
            List<Wheel> wheelsRear = orderRearWheels();
            addRearWheels(car, wheelsRear);

            car.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void addRearBikeWheels(Bike bike, List<Wheel> wheelBikeRear) {
        try{
            bike.addFrontBikeWheel(wheelBikeRear);
        }catch (Exception e){
            System.out.println("Error when trying to add wheels to the main.");
        }

    }

    private static List<Wheel> orderRearBikeWheel() {
        List<Wheel> wheelBikeRear = new ArrayList<>();
        Wheel right = orderOneWheel();

        wheelBikeRear.add(right);

        return wheelBikeRear;
    }

    private static void addFrontBikeWheel(Bike bike, List<Wheel> wheelBikeFront) {
            try{
                bike.addFrontBikeWheel(wheelBikeFront);
            }catch (Exception e){
                System.out.println("Error when trying to add wheels to the main.");
            }
    }

    private static List<Wheel> orderFrontBikeWheel() {
            List<Wheel> wheelBikeFront = new ArrayList<>();
            Wheel right = orderOneWheel();

            wheelBikeFront.add(right);

            return wheelBikeFront;

    }

    private static void addRearWheels(Car car, List<Wheel> wheelsRear) {
        try {
            car.addWheelsRear(wheelsRear);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Wheel> orderFrontWheels() {
        List<Wheel> frontWheels = new ArrayList<>();
        Wheel right = orderOneWheel();
        Wheel left = orderOneWheel();

        frontWheels.add(right);
        frontWheels.add(left);

        return frontWheels;
    }


    private static List<Wheel> orderRearWheels() {
        List<Wheel> wheelsRear = new ArrayList<>();
        Wheel right = orderOneWheel();
        Wheel left = orderOneWheel();

        wheelsRear.add(right);
        wheelsRear.add(left);

        return wheelsRear;
    }



    private static Wheel orderOneWheel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the wheel's brand: ");
        String brand = sc.next();
        System.out.println("Enter wheel's diameter: ");
        Double diameter = sc.nextDouble();

        Wheel wheel = new Wheel(brand, diameter);
        return wheel;
    }

    private static void addFrontWheels(Car car, List<Wheel> wheelsFront) {
        try {
            car.addTwoWheels(wheelsFront);
        } catch (Exception e) {
            System.out.println("Error trying to add two wheels to the main. ");
        }
    }

    public static String[] askCarPlateBrandColor(){
        String[] data = new String[3];
        data[0] = askCarPlate();
        data[1] = askCarBrand();
        data[2] = askCarColor();

        return data;
    }

    private static String askCarColor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the car's Color:");
        String color = sc.next();
        return color;
    }

    private static String askCarBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the car's Brand:");
        String brand = sc.next();
        return brand;
    }

    private static String askCarPlate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the car's Plate:");
        String plate = sc.next();
        return plate;
    }
}
