package matrix;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class MatrixUtils {
    private MatrixUtils() {};

    public static <T> Matrix<T> add (Matrix<T> m1, Matrix<T> m2, BinaryOperator<T> operator){
        if (!(m1.getRows() == m2.getRows() && m1.getCols() == m2.getCols())) throw new RuntimeException("Неправильные размеры матриц");
        List<ArrayList<T>> result = new ArrayList<>();
        for (int i = 0; i < m1.getRows(); i++){
            ArrayList<T> row = new ArrayList<>();
            for (int j = 0; j < m2.getCols(); j++){
                T first = m1.getElement(i, j);
                T second = m2.getElement(i, j);
                row.add(operator.apply(first, second));
            }
            result.add(row);
        }
        return new Matrix<>(m1.getRows(), m1.getCols(), result);
    }
}
