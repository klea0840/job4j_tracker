package ru.job4j.stream;

public class SpaceShip {
    private String model;
    private String name;
    private int yearMade;
    private double price;
    private long speed;
    private boolean fromMandalore;
    private String type;

    @Override
    public String toString() {
        return "SpaceShip{"
                + "model='" + model + '\''
                + ", name='" + name + '\''
                + ", yearMade=" + yearMade
                + ", price=" + price + ", speed=" + speed
                + ", fromMandalore=" + fromMandalore
                + ", type='" + type + '\'' + '}';
    }

    static class Builder {
        private String model;
        private String name;
        private int yearMade;
        private double price;
        private long speed;
        private boolean fromMandalore;
        private String type;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildType(int yearMade) {
            this.yearMade = yearMade;
            return this;
        }

        Builder buildPrice(double price) {
            this.price = price;
            return this;
        }

        Builder buildSpeed(long speed) {
            this.speed = speed;
            return this;
        }

        Builder buildFromMandalore(boolean fromMandalore) {
            this.fromMandalore = fromMandalore;
            return this;
        }

        Builder buildYearMade(int yearMade) {
            this.yearMade = yearMade;
            return this;
        }

        SpaceShip build() {
            SpaceShip spaceShip = new SpaceShip();
            spaceShip.name = name;
            spaceShip.speed = speed;
            spaceShip.model = model;
            spaceShip.fromMandalore = fromMandalore;
            spaceShip.price = price;
            spaceShip.type = type;
            spaceShip.yearMade = yearMade;
            return spaceShip;
        }

    }

    public static void main(String[] args) {
        SpaceShip spaceShip = new Builder().buildName("Raven")
                .buildModel("XXX101")
                .buildType("Dagger")
                .buildPrice(100.28)
                .buildSpeed(1509835697)
                .buildFromMandalore(true)
                .buildYearMade(2050)
                .build();
        System.out.println(spaceShip);
    }
}
