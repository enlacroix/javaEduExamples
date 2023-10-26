package graph;

import java.util.Objects;

public class WeightedEdge <T, W> extends Edge<T> {
    private W weight;

    @Override
    public String toString() {
        return "Ребро (" + weight + "): " + start + " -> " + finish;
    }

    public void setWeight(W weight) {
        this.weight = weight;
    }

    public WeightedEdge(Node<T> start, Node<T> finish, W weight){
        super(start, finish);
        this.weight = weight;
    }


    @Override
    public boolean equals(Object obj) {
        WeightedEdge<?, ?> edge = (WeightedEdge<?, ?>) obj;
        return super.equals(obj) && Objects.equals(weight, edge.weight);
    }
}
