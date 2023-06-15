import java.util.Arrays;

public class Matrix implements IMatrix {
    private final double[][] numbers;

    public Matrix() {
        numbers = new double[0][0];
    }

    public Matrix(int rowNum, int colNum) {
        numbers = new double[rowNum][colNum];
    }

    public Matrix(Matrix forCopy) {
        numbers = new double[forCopy.numbers.length][forCopy.numbers[0].length];
        for (int i = 0; i < forCopy.numbers.length; i++) {
            numbers[i] = Arrays.copyOf(forCopy.numbers[i], forCopy.numbers[i].length);
        }
    }

    @Override
    public void setNumber(int rowNum, int colNum, double number) {
        numbers[rowNum][colNum] = number;
    }

    @Override
    public double getNumber(int rowNum, int colNum) {
        return numbers[rowNum][colNum];
    }

    @Override
    public double[] getCol(int colNum) {
        double[] returned = new double[numbers.length];
        for (int i = 0; i < returned.length; i++)
            returned[i] = numbers[i][colNum];
        return returned;
    }

    @Override
    public double[] getRow(int rowNum) {
        return Arrays.copyOf(numbers[rowNum], numbers[rowNum].length);
    }

    @Override
    public int[] getSize() {
        return new int[]{numbers.length, numbers[0].length};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;

        Matrix matrix = (Matrix) o;

        return Arrays.deepEquals(numbers, matrix.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(numbers);
    }

    public static Matrix createDiagonal(double[] vector){
        Matrix matrix = new Matrix(vector.length, vector.length);
        for (int i=0;i<vector.length;i++)
            matrix.numbers[i][i] = vector[i];
        return matrix;
    }

    public void upTriangle() {
        if (numbers.length != numbers[0].length)
            throw new RuntimeException("Matrix is not square");
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i][i] == 0) {
                for (int k = i + 1; k < numbers.length; k++) {
                    if (numbers[k][i] != 0) {
                        swapRows(i, k);
                        break;
                    }
                }
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j][i] != 0) {
                    double num = numbers[j][i] / numbers[i][i];
                    multiplyAndSubtractRow(i, j, num);
                }
            }
        }
    }

    public void lowTriangle() {
        if (numbers.length != numbers[0].length)
            throw new RuntimeException("Matrix is not square");
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i][i] == 0) {
                for (int k = i - 1; k >= 0; k--) {
                    if (numbers[k][i] != 0) {
                        swapRows(i, k);
                        break;
                    }
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j][i] != 0) {
                    double num = numbers[j][i] / numbers[i][i];
                    multiplyAndSubtractRow(i, j, num);
                }
            }
        }
    }

    private void swapRows(int row1, int row2) {
        double[] temp = numbers[row1];
        numbers[row1] = numbers[row2];
        numbers[row2] = temp;
    }

    private void multiplyAndSubtractRow(int srcRow, int destRow, double factor) {
        for (int i = 0; i < numbers[0].length; i++) {
            numbers[destRow][i] -= numbers[srcRow][i] * factor;
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Matrix{");
        sb.append("numbers=").append("\n");
        for (double[] arr: numbers){
            for (double num: arr){
                sb.append(((double)(int)(num*100))/100).append(" ");
//                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        sb.append('}');
        return sb.toString();
    }
}
