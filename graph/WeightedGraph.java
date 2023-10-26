package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph <T, W> implements IGraph {
    private Map<Node<T>, List<WeightedEdge<T, W>>> adjDict = new HashMap<>();
    private String identifier;

    public WeightedGraph (List<Node<T>> listOfNodes){
        for (Node<T> node: listOfNodes) addNode(node);
    }

    public void addNode(Node<T> newNode, List<WeightedEdge<T, W>> neighbours){
        adjDict.put(newNode, neighbours);
    }
    public void addNode(Node<T> newNode){
        adjDict.put(newNode, new ArrayList<>());
    }

    public boolean addEdge(Node<T> start, Node<T> finish, W weight){
        if (adjDict.containsKey(start) && adjDict.containsKey(finish)){
            WeightedEdge<T, W> potentialEdge = new WeightedEdge<>(start, finish, weight);
            if (adjDict.get(start).contains(potentialEdge)) return false;
            else{
                adjDict.get(start).add(potentialEdge);
                return true;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Взвешенный граф %s: ", identifier) + adjDict;
    }

    @Override
    public String describe() {
        return null;
    }
}
