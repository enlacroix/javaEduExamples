package graph;

import java.util.Objects;

public class Edge <T> {
    public Node<T> start;
    public Node<T> finish;

    public Edge(Node<T> start, Node<T> finish){
        this.start = start;
        this.finish = finish;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Edge<?> edge = (Edge<?>) obj;
        return Objects.equals(start, edge.start) && Objects.equals(finish, edge.finish);
    }
}
