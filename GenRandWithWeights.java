import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
Пример:
Дан массив [1, 2, 3], и массив весов [1, 2, 10].
В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».
 */
public class GenRandWithWeights <T> {
    private final T[] values;
    private final int[] weights;
    private final int sumOfWeights;

    public List<T> distribution = new ArrayList<>();

    public GenRandWithWeights(T[] values, int[] weights) {
        assert values.length == weights.length;
        this.values = values;
        this.weights = weights;
        this.sumOfWeights = Arrays.stream(this.weights).reduce(Integer::sum).orElse(0);
        for (int i = 0; i < weights.length; i++) {
            List<T> copies = Collections.nCopies(weights[i], values[i]);
            this.distribution.addAll(copies);
        }
    }

    private int leftBound(int index){
        if (index == 0) return 1;
        else return rightBound(index - 1) + 1;
    }

    private int rightBound(int index){
        if (index == 0) return 1 + this.weights[0];
        else return rightBound(index - 1) + this.weights[index];
    }

    public T generate(){
        int randValue = (int) ((Math.random() * (sumOfWeights - 1)) + 1);
        for (int i = 0; i < weights.length; i++){
            if (randValue >= leftBound(i) && randValue <= rightBound(i)) return values[i];
        }
        return null;
    }

    public T altGenerate(){
        return this.distribution.get((int) ((Math.random() * (sumOfWeights - 1)) + 1));
    }

    public void testGeneration(int iterations){
        for (int i = 0; i < iterations; i++){
            System.out.println(generate());
        }
    }
}
