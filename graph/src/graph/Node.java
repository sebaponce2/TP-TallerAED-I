package graph;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
    
    private T value;
    private Set<Node<T>> neighbors;

    public Node(T value){
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public T getValue(){
        return this.value;
    }
}