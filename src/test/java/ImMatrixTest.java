import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ImMatrixTest {
    @Test
    public void imMatrixTest() {
        ImMatrix matrix = new ImMatrix(2, 3);

        int[] expectedSize = {2, 3};
        assertArrayEquals(matrix.getSize(), expectedSize);

        double[][] expectedNumbers = {
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0}
        };

        for (int i = 0; i < matrix.getSize()[0]; i++) {
            for (int j = 0; j < matrix.getSize()[1]; j++) {
                assert matrix.getNumber(i, j) == expectedNumbers[i][j];
            }
        }
    }
    @Test
    public void imMatrixCopyTest(){
        Matrix sourceMatrix = new Matrix(2, 2);
        sourceMatrix.setNumber(0, 0, 1.0);
        sourceMatrix.setNumber(0, 1, 2.0);
        sourceMatrix.setNumber(1, 0, 3.0);
        sourceMatrix.setNumber(1, 1, 4.0);

        ImMatrix matrix = new ImMatrix(sourceMatrix);

        int[] expectedSize = {2, 2};
        assertArrayEquals(matrix.getSize(), expectedSize);

        double[][] expectedNumbers = {
                {1.0, 2.0},
                {3.0, 4.0}
        };

        for (int i = 0; i < matrix.getSize()[0]; i++) {
            for (int j = 0; j < matrix.getSize()[1]; j++) {
                assert matrix.getNumber(i, j) == expectedNumbers[i][j];
            }
        }
    }

    @Test
    public void setNumberTest(){
        ImMatrix matrix = new ImMatrix(2, 2);

        try {
            matrix.setNumber(0, 0, 1.0); // This should throw an exception
            assert false; // The above line should throw an exception, so this line should not be reached
        } catch (Exception e) {
            // Exception expected
            assert true;
        }
    }
}