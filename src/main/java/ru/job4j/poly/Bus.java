package ru.job4j.poly;

public class Bus implements Transport {
    private int seats = 12;
    private double gasPrice = 45.5;

    @Override
    public void ride() {
        System.out.println("The distance is 74 km.");
    }

    @Override
    public void passengers(int people) {
        int load = seats - people;
        if (load == seats) {
            System.out.println("The bus is empty.");
        } else if (load > 0) {
            System.out.println("The bus can take " + load + (" passenger(s)."));
        } else if (load == 0) {
            System.out.println("The bus is full.");
        } else {
            System.out.println("The bus is overloaded.");
        }
    }

    @Override
    public double expenses(double gas) {
        return gas * gasPrice;
    }
}
