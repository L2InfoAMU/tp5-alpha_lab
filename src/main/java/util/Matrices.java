package util;

import java.util.Objects;

/**
 * Created by Arnaud Labourel on 23/11/2018.
 */
public class Matrices {

    /**
     * Ensures that the given matrix does not have null parts : itself being null, having null row or having
     * null values.
     *
     * @throws NullPointerException if there are null parts in the matrix.
     * @param matrix the matrix to be tested.
     */

    public static void requiresNonNull(Object[][] matrix) {
        Objects.requireNonNull(matrix, "The matrix must not be null.");
        for (int x = 0; x < getRowCount(matrix); x++) {
            Objects.requireNonNull(matrix[x], "The matrix must not have rows equals to null.");
            for (int y = 0; y < matrix[x].length; y++) {
                Objects.requireNonNull(matrix[x][y], "The matrix must not have values equals to null.");
            }
        }
    }

    /**
     * Ensures that the given matrix (assumed to be rectangular) does not have zero rows or zero columns.
     *
     * @throws IllegalArgumentException if the matrix have zero rows or zero columns.
     * @param matrix the matrix to be tested.
     */
    public static void requiresNonZeroDimensions(Object[][] matrix) {
        if (getRowCount(matrix) == 0) {
            throw new IllegalArgumentException("The matrix must not have zero rows.");
        }
        if (getColumnCount(matrix) == 0) {
            throw new IllegalArgumentException("The matrix must not have zero columns.");
        }
    }


    /**
     * Ensures that the given matrix is rectangular, i.e., all rows have the same size.
     *
     * @throws IllegalArgumentException if the matrix have rows with different sizes.
     * @param matrix the matrix to be tested.
     */
    public  static void requiresRectangularMatrix(Object[][] matrix) {
        for (int x = 1; x < getRowCount(matrix); x++) {
            if (matrix[x].length != matrix[0].length)
                throw new IllegalArgumentException("The matrix must be rectangular.");
        }
    }

    /**
     * Ensures that the given coordinates are not outside the matrix bonds.
     *
     * @throws IllegalArgumentException if the coordinates are outside of the matrix bounds
     * @param matrix the matrix of objects
     * @param x the first coordinate of the matrix
     * @param y the second coordinate of the matrix
     */
    public  static void requiresInsideMatrixBonds(Object[][] matrix, int x, int y) {
        if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length)
            throw new IllegalArgumentException("x or y cannot be outside the matrix bonds");
    }

    /**
     * Ensures that the given coordinates are not outside the matrix bonds.
     *
     * @throws IllegalArgumentException if the coordinates are outside of the matrix bounds
     * @param matrix the matrix of int
     * @param x the first coordinate of the matrix
     * @param y the second coordinate of the matrix
     */
    public  static void requiresInsideMatrixBonds(int[][] matrix, int x, int y) {
        if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length)
            throw new IllegalArgumentException("x or y cannot be outside the matrix bonds");
    }

    /**
     * Give the number of rows of a matrix.
     *
     * @param matrix the matrix.
     * @return the number of rows of the matrix.
     */
    public static int getRowCount(Object[][] matrix){
        return matrix.length;
    }

    /**
     * Give the number of columns of a matrix (assumed to be rectangular).
     *
     * @param matrix the matrix.
     * @return the number of rows of the matrix.
     */
    public static int getColumnCount(Object[][] matrix){
        return matrix[0].length;
    }

}
