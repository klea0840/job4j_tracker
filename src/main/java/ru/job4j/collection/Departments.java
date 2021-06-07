package ru.job4j.collection;

import java.util.*;

public class Departments {
    /** Метод принимает список строк и возвращает список с перегруппированными элементами
     * Промежуточная коллекция LinkedHashSet позволяет устранить дубликаты из коллекции,
     * которые будут получаться
     * в результате последовательного складывания единичных департаментов
     * @param deps - список строк для обработки
     * @return - список с отсортированными и дополненными элементами
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                    tmp.add(start + el);
                    start = el + "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /** Метод принимает список строк и сортирует его в порядке убывания
     * категории элементов списка
     * @param orgs - список для сортировки
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
            }
}