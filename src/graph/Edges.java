package graph;

public class Edges {
    private Vertex source;
    private Vertex destination;
    private Integer weight;
    public Edges(Vertex source, Vertex destination, Integer weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    public Vertex getSource() {
        return source;
    }
    public void setSource(Vertex source) {
        this.source = source;
    }
    public Vertex getDestination() {
        return destination;
    }
    public void setDestination(Vertex destination) {
        this.destination = destination;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    
}
