package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
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
        attachments.sort(comparator);
        System.out.println(attachments);
        // Здесь создайте компаратор на основании анонимного класса.
        Comparator<Attachment> comparatorByName =  new Comparator<Attachment>() {
           @Override
           public int compare(Attachment a1, Attachment a2) {
                return a1.getName().compareTo(a2.getName());
            }
        };
        attachments.sort(comparatorByName);
        System.out.println(attachments);
        System.out.println();

        Comparator<Attachment> comparatorByNameLambda = (left, right) ->
                left.getName().compareTo(right.getName());
        attachments.sort(comparatorByName);
        System.out.println(attachments);
        System.out.println();

        Comparator<Attachment> attachmentComparatorBySize =
                (left, right) -> right.getSize() - left.getSize();
        attachments.sort(attachmentComparatorBySize);
        System.out.println(attachments);
        System.out.println();

        Comparator<Attachment> comparatorByLambda = (left, right) ->
                left.getName().compareTo(right.getName());
        attachments.sort(comparatorByLambda);
        System.out.println(attachments);
        System.out.println();

        Comparator<Attachment> attachmentComparatorByLength =
                (left, right) -> right.getName().length() - left.getName().length();
        attachments.sort(attachmentComparatorByLength);
        System.out.println(attachments);
        System.out.println();
    }
}
