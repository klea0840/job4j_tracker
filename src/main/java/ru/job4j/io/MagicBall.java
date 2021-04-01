package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.println("Попугай Кеша предсказывает будущее, но знает он всего 2 слова, "
               + System.lineSeparator() + "поэтому Ваш вопрос должен начинаться со слова <Будет...?>." + System.lineSeparator()
                + "Введите вопрос.");
        Scanner sc = new Scanner(System.in);
        String question = sc.nextLine();
        int answer = new Random().nextInt(3);

        switch (answer) {
            case 1 -> System.out.println(question + " Ответ: нет");
            case 0 -> System.out.println(question + " Ответ: да");
            default -> System.out.println(question + " Ответ: может быть");
        }
    }
}
