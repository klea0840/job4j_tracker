package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
        System.out.println("Active: " + active);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        Error definedError = new Error(false, 0, "Not working");
        defaultError.printInfo();
        System.out.println();
        definedError.printInfo();
    }
}
