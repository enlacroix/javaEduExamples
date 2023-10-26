package matrix;

import java.util.*;

public class Matrix <T> {
    private final int rows;
    private final int cols;
    public List<ArrayList<T>> data = new ArrayList<>();

    public Matrix (int rows, int cols, T fillValue){
        for (int i = 1; i <= rows; i++){
            this.data.add(new ArrayList<>(Collections.nCopies(cols, fillValue)));
        }
        this.rows = rows;
        this.cols = cols;
    }

    public Matrix(int rows, int cols, List<ArrayList<T>> data) {
        this.rows = rows;
        this.cols = cols;
        this.data = data;
    }

    public Matrix (T[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        for (int i = 0; i < this.rows; i++) this.data.add(new ArrayList<>(Arrays.asList(data[i])));
    }

    public T getElement(int i, int j){
        return data.get(i).get(j);
    }

    public Matrix (ArrayList<T> flattenData, int rows, int cols){
        if (flattenData.size() != rows * cols) throw new RuntimeException("плохие размеры");
        this.rows = rows;
        this.cols = cols;
        // Преобразовать плоский массив [1, 2, 4, 7] в  [[1, 2], [4, 7]]
        int counter = 1;
        for (int i = 0; i < rows; i++){
            ArrayList<T> row = new ArrayList<>();
            while (counter <= cols){
                row.add(flattenData.get(2*i + counter - 1));
                counter++;
            }
            this.data.add(row);
            counter = 1;
        }
    }

    public List<T> flatToVector(){
        return (this.data).stream().flatMap(Collection::stream).toList();
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
