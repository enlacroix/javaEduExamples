package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        Matrix<Integer> matr = new Matrix<>(2, 2, -1);
        System.out.println(matr);
        Matrix<Integer> matr2 = new Matrix<>(new Integer[][]{{4, 2}, {2, 7, 7}});
        System.out.println(matr2);
        Matrix<Integer> matr3 = new Matrix<>(new ArrayList<>(Arrays.asList(3, 4, 2, 1)), 2, 2);
        System.out.println(matr3);

        System.out.println(matr2.flatToVector());

        var haha = MatrixUtils.add(matr, matr3, (x, y) -> x*y);
        var haha2 = MatrixUtils.add(matr, matr3, Integer::sum);
        System.out.println(haha);
    }
}
