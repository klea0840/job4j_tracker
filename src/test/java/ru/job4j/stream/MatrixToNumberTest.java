package ru.job4j.stream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.List;

public class MatrixToNumberTest{
    @Test
    public void testSwitchToList() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        MatrixToNumber matrixToNumber = new MatrixToNumber();
        List<Integer> rsl = matrixToNumber.switchToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }

    @Test
    public void testSwitchToList3() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, -10),
                List.of(3, 4, 26),
                List.of(143, 0, 15)
        );
        MatrixToNumber matrixToNumber = new MatrixToNumber();
        List<Integer> rsl = matrixToNumber.switchToList(matrix);
        List<Integer> expected = List.of(1, 2, -10, 3, 4, 26, 143, 0, 15);
        assertThat(rsl, is(expected));
    }

    @Test
    public void testSwitchToListEmpty() {
        List<List<Integer>> matrix = List.of(
                List.of(),
                List.of(),
                List.of()
        );
        MatrixToNumber matrixToNumber = new MatrixToNumber();
        List<Integer> rsl = matrixToNumber.switchToList(matrix);
        List<Integer> expected = List.of();
        assertThat(rsl, is(expected));
        assertTrue(rsl.isEmpty());
    }
}