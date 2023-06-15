public interface IMatrix {
    void setNumber(int rowNum, int colNum, double number) throws Exception;
    double getNumber(int rowNum, int colNum);
    double[] getCol(int colNum);
    double[] getRow(int rowNum);
    int[] getSize();

}
