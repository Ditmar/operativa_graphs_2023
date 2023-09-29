package graph;

public class Tag {
    private Integer weight;
    private Vertex parent;
    public Tag (Integer weight, Vertex parent) {
        this.weight = weight;
        this.parent = parent;
    }
    public void updateTag(Integer weight, Vertex parent) {
        this.weight = weight;
        this.parent = parent;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public Vertex getParent() {
        return parent;
    }
    public void setParent(Vertex parent) {
        this.parent = parent;
    }
    
}
