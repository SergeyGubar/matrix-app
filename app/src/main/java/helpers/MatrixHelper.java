package helpers;

/**
 * Created by Sergey on 10/17/2017.
 */

public class MatrixHelper {
    public static int[][] generateMatrix(int size) {

        int[][] matrix = new int[size][size];


        int value = 1;
        int cursor = 0;
        int counterToCenter;
        int center = size / 2;


        for (counterToCenter = 1; counterToCenter <= center; counterToCenter++) {

            for (cursor = counterToCenter - 1; cursor < size - counterToCenter + 1; cursor++) {
                if (containsSix(value)) {
                    value++;
                }
                matrix[cursor][counterToCenter - 1] = newValue(value);
                value++;
            }

            for (cursor = counterToCenter; cursor < size - counterToCenter + 1; cursor++) {
                if (containsSix(value)) {
                    value++;
                }
                matrix[size - counterToCenter][cursor] = newValue(value);
                value++;
            }

            for (cursor = size - counterToCenter - 1; cursor >= counterToCenter; cursor--) {
                if (containsSix(value)) {
                    value++;
                }
                matrix[cursor][size - counterToCenter] = newValue(value);
                value++;
            }

            for (cursor = size - counterToCenter; cursor >= counterToCenter; cursor--) {
                if (containsSix(value)) {
                    value++;
                }
                matrix[counterToCenter - 1][cursor] = newValue(value);
                value++;
            }

        }

        if (size % 2 == 1) {
            matrix[center][center] = size * size;
        }

        return matrix;


    }

    private static int newValue(int number) {
        int result = number;
        if (containsSix(number)) {
            result++;
        }
        return result;
    }

    private static boolean containsSix(int number) {
        return String.valueOf(number).contains("6");
    }
}
