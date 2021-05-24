package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 333", 100),
                new Attachment("image 1", 34),
                new Attachment("image 2222", 13)
        );
        Comparator comparator =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        Comparator<Attachment> attachmentComparatorByLength =
                (left, right) -> {
                    System.out.println("comparing " + right.getName().length()
                            + " and " + left.getName().length());
                    return right.getName().length() - left.getName().length();
                };
        attachments.sort(attachmentComparatorByLength);
        System.out.println(attachments);
        System.out.println();

//*2.5. Ленивая загрузка [#249211]
        String[] names1 = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names1, lengthCmp);
        String[] names2 = {
                "Ivan",
                "Petr"
        };

        Arrays.sort(names2, lengthCmp);
    }
}
