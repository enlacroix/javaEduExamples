package graph;

import java.util.Objects;

public class Node <T> {

    private final T value;

    public Node(T name){
        this.value = name;
    }

    @Override
    public String toString() {
        return "Вершина [" + value + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
