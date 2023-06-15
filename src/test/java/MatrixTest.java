import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    private Matrix matrix;

    @BeforeEach
    public void setUp() {
        matrix = new Matrix(3, 3);
        matrix.setNumber(0, 0, 1);
        matrix.setNumber(0, 1, 2);
        matrix.setNumber(0, 2, 3);
        matrix.setNumber(1, 0, 4);
        matrix.setNumber(1, 1, 5);
        matrix.setNumber(1, 2, 6);
        matrix.setNumber(2, 0, 7);
        matrix.setNumber(2, 1, 8);
        matrix.setNumber(2, 2, 9);
    }

    @Test
    public void testGetNumber() {
        assertEquals(1, matrix.getNumber(0, 0));
        assertEquals(5, matrix.getNumber(1, 1));
        assertEquals(9, matrix.getNumber(2, 2));
    }

    @Test
    public void testSetNumber() {
        matrix.setNumber(0, 0, 10);
        assertEquals(10, matrix.getNumber(0, 0));
    }

    @Test
    public void testGetSize() {
        assertArrayEquals(new int[] {3, 3}, matrix.getSize());
    }

    @Test
    public void testGetRow() {
        assertArrayEquals(new double[] {1, 2, 3}, matrix.getRow(0));
        assertArrayEquals(new double[] {4, 5, 6}, matrix.getRow(1));
        assertArrayEquals(new double[] {7, 8, 9}, matrix.getRow(2));
    }

    @Test
    public void testGetCol() {
        assertArrayEquals(new double[] {1, 4, 7}, matrix.getCol(0));
        assertArrayEquals(new double[] {2, 5, 8}, matrix.getCol(1));
        assertArrayEquals(new double[] {3, 6, 9}, matrix.getCol(2));
    }

    @Test
    public void testEquals() {
        Matrix matrixCopy = new Matrix(matrix);
        Assertions.assertEquals(matrix, matrixCopy);
    }

    @Test
    public void testEqualsManual() {
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setNumber(0, 0, 1.0);
        matrix1.setNumber(0, 1, 2.0);
        matrix1.setNumber(1, 0, 3.0);
        matrix1.setNumber(1, 1, 4.0);

        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setNumber(0, 0, 1.0);
        matrix2.setNumber(0, 1, 2.0);
        matrix2.setNumber(1, 0, 3.0);
        matrix2.setNumber(1, 1, 4.0);

        assert matrix1.equals(matrix2);
    }

    @Test
    public void testHashCode() {
        Matrix matrixCopy = new Matrix(matrix);
        Assertions.assertEquals(matrix.hashCode(), matrixCopy.hashCode());
    }

    @Test
    public void testHashCodeManual() {
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setNumber(0, 0, 1.0);
        matrix1.setNumber(0, 1, 2.0);
        matrix1.setNumber(1, 0, 3.0);
        matrix1.setNumber(1, 1, 4.0);

        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setNumber(0, 0, 1.0);
        matrix2.setNumber(0, 1, 2.0);
        matrix2.setNumber(1, 0, 3.0);
        matrix2.setNumber(1, 1, 4.0);

        assert matrix1.hashCode() == matrix2.hashCode();

    }

    @Test
    public void testCreateDiagonal() {
        double[] vector = {1, 2, 3};
        Matrix diagonalMatrix = Matrix.createDiagonal(vector);
        Matrix expected = new Matrix(3, 3);
        expected.setNumber(0, 0, 1);
        expected.setNumber(1, 1, 2);
        expected.setNumber(2, 2, 3);
        Assertions.assertEquals(expected, diagonalMatrix);
    }

    @Test
    public void testUpTriangle() {
        Matrix matrixCopy = new Matrix(matrix);
        matrixCopy.upTriangle();
        Matrix expected = new Matrix(3, 3);
        expected.setNumber(0, 0, 1);
        expected.setNumber(0, 1, 2);
        expected.setNumber(0, 2, 3);
        expected.setNumber(1, 1, -3);
        expected.setNumber(1, 2, -6);
        expected.setNumber(2, 2, -0);
        Assertions.assertEquals(expected, matrixCopy);
    }

    @Test
    public void testLowTriangle() {
        Matrix matrixCopy = new Matrix(matrix);
        matrixCopy.lowTriangle();
        Matrix expected = new Matrix(3, 3);
        expected.setNumber(0, 0, 0);
        expected.setNumber(1, 0, -0.666666);
        expected.setNumber(1, 1, -0.333333);
        expected.setNumber(2, 0, 7);
        expected.setNumber(2, 1, 8);
        expected.setNumber(2, 2, 9);
        System.out.println("Expected:\n" + expected);
        System.out.println("Actual:\n" + matrixCopy);
    }
}

