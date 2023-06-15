import java.util.Arrays;

public class ImMatrix  implements IMatrix {
    private final double[][] numbers;

    public ImMatrix() {
        numbers = new double[0][0];
    }

    public ImMatrix(int rowNum, int colNum) {
        numbers = new double[rowNum][colNum];
    }

    public ImMatrix(Matrix forCopy) {
        numbers = new double[forCopy.getSize()[0]][forCopy.getSize()[1]];
        for (int i = 0; i < forCopy.getSize()[0]; i++) {
            for (int j = 0; j<forCopy.getSize()[1];j++)
                numbers[i][j] = forCopy.getNumber(i,j);
        }
    }

    @Override
    public void setNumber(int rowNum, int colNum, double number) throws Exception {
        throw new Exception("Immutable class can't have any setters");
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
        if (!(o instanceof ImMatrix)) return false;

        ImMatrix matrix = (ImMatrix) o;

        return Arrays.deepEquals(numbers, matrix.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(numbers);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ImMatrix{");
        sb.append("numbers=").append("\n");
        for (double[] arr: numbers){
            sb.append(Arrays.toString(arr)).append("\n");
        }
        sb.append('}');
        return sb.toString();
    }

}