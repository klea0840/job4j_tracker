package ru.job4j.poly;

public class Travel {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle truck = new Truck();
        Vehicle[] vehicles = new Vehicle[] {plane, train, truck};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
