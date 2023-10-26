package perm;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Permutation {
    private Set<Integer> data = new LinkedHashSet<>();

    public Permutation(LinkedHashSet<Integer> data){
        if (!checkLogic(data)) throw new PermutationException("Неверные аргументы");
        this.data = data;
    }

    private boolean checkLogic(LinkedHashSet<Integer> data) {
        return Permutation.getNeutralElement(data.size()).data.equals(data);
    }

    private boolean checkEqualityOfSizes(Permutation first, Permutation second){
        return first.getSize() == second.getSize();
    }

    private static LinkedHashSet<Integer> handleStringRequest(String strForm){
        String[] data = strForm.split(", ");
        return Arrays.stream(data).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Permutation(String strForm){
        this(Permutation.handleStringRequest(strForm));
    }

    private Permutation() {}

    public Permutation multiply(Permutation that){
        if (!checkEqualityOfSizes(this, that)) throw new PermutationException("нельзя перемножать перестановки с разными размерами");
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        for (int i = 1; i <= this.getSize(); i++) result.add(that.getElement(this.getElement(i)));
        return new Permutation(result);
    }

    public String cycleStructure(){
        StringBuilder sb = new StringBuilder("(1");
        List<Integer> handled = new ArrayList<>(List.of(1));
        Integer first = 1;
        Integer next = getElement(first);
        while (handled.size() <= getSize()){
            if (next.equals(first)) {
                sb.append(") ");
                first = IntStream.rangeClosed(1, getSize()).boxed().filter(val -> !handled.contains(val)).min(Integer::compare).orElse(-1);
                if (first == -1) break;
                sb.append("(").append(first);
                handled.add(first);
                next = getElement(first);
            }
            else
            {
                sb.append(next);
                handled.add(next);
                next = getElement(next);
            }
        }
        return sb.toString();
    }

    public Permutation reverse(){
        int[] test = new int[getSize()];
        for (int k = 1; k <= getSize(); k++) test[getElement(k) - 1] = k;
        return new Permutation((LinkedHashSet<Integer>) Arrays.stream(test).boxed().collect(Collectors.toCollection(LinkedHashSet::new)));
    }

    public Permutation pow(int N){
        if (N == 0) return Permutation.getNeutralElement(getSize());
        int power = Math.abs(N);
        Permutation result = this;
        for (int i = 1; i < power; i++) result = result.multiply(this);
        return N > 0 ? result : result.reverse();
    }

    public Integer getElement(int index){
        return new ArrayList<>(data).get(index - 1);
    }

    public static Permutation getNeutralElement(Integer groupSize){
        Permutation neutral = new Permutation();
        neutral.data = IntStream.rangeClosed(1, groupSize).boxed().collect(Collectors.toSet());
        return neutral;
    }

    public static List<Permutation> generateAll(Integer groupSize){
        return null;
    }

    public int getSize(){
        return data.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permutation that = (Permutation) o;
        return Objects.equals(new ArrayList<>(data), new ArrayList<>(that.data));
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        if (this.equals(Permutation.getNeutralElement(getSize()))) return "Нейтральный элемент группы S" + getSize();
        return data.stream().map(String::valueOf).collect(Collectors.joining(", ", "{", "}"));
    }
}
