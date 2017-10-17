package helpers;

import java.util.Stack;

/**
 * Created by Sergey on 10/17/2017.
 */

public class MatrixHelper {

    /**
     *
     * @param size - size of generated matrix
     * @return - generated matrix
     */
    public static int[][] generateMatrix(int size) {

        int[][] matrix = new int[size][size];


        int value = 1;
        int cursor = 0;
        int counterToCenter;
        int center = size / 2;

        Stack<Integer> stack = makeNumbersStack(size);

        for (counterToCenter = 1; counterToCenter <= center; counterToCenter++) {

            for (cursor = counterToCenter - 1; cursor < size - counterToCenter + 1; cursor++) {
                matrix[cursor][counterToCenter - 1] = stack.pop();
            }

            for (cursor = counterToCenter; cursor < size - counterToCenter + 1; cursor++) {
                matrix[size - counterToCenter][cursor] = stack.pop();
            }

            for (cursor = size - counterToCenter - 1; cursor >= counterToCenter; cursor--) {
                matrix[cursor][size - counterToCenter] = stack.pop();
            }

            for (cursor = size - counterToCenter; cursor >= counterToCenter; cursor--) {
                matrix[counterToCenter - 1][cursor] = stack.pop();
            }


        }

        if (size % 2 == 1) {
            matrix[center][center] = 1;
        }
        return matrix;


    }

    /**
     *
     * @param size - size of stack (number of items), depends on the matrix length
     * @return - Integer stack w/out numbers with digit "6" in it
     */

    public static Stack<Integer> makeNumbersStack(int size) {
        int length = size * size;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < length + 1; i++) {
            if(!containsSix(i)) {
                stack.push(i);
            } else {
                length++;
            }
        }
        return stack;
    }


    /**
     *
     * @param number - number to check
     * @return - true if number contains digit "6", otherwise - false
     */
    private static boolean containsSix(int number) {
        return String.valueOf(number).contains("6");
    }



}
