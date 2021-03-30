package ru.job4j.pojo;

public class Library {

    public static Book[] swap(Book[] bk, int x, int y) {
        Book book = bk[x];
        bk[x] = bk[y];
        bk[y] = book;
        return bk;
    }

    public static void main(String[] args) {
        Book goodBook = new Book("Убить пересмешника", 412);
        Book mustBook = new Book("12 rules for life", 564);
        Book reqBook = new Book("Clean Code", 1024);
        Book bestBook = new Book("Сердце Ворона", 284);
        Book[] books = new Book[4];
        books[0] = goodBook;
        books[1] = mustBook;
        books[2] = reqBook;
        books[3] = bestBook;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println();
        Library.swap(books, 0, 3);
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (bk.getName().equals("Clean Code")) {
                System.out.println(bk.getName() + " - " + bk.getPages());
            }
        }
        }
}
