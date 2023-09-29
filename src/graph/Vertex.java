package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
    private String label;
    private boolean visited;
    private ArrayList<Vertex> neighbors;
    private ArrayList<Edges> edges;
    private Tag tag;
    private Graph graph;
    private HashMap<String, Edges> hashEdges;

    public Vertex(String label, boolean visited) {
        this.label = label;
        this.visited = visited;
        this.neighbors = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edges>();
        this.hashEdges = new HashMap<>();
    }
    public Vertex(String label, boolean visited, Graph graph) {
        this.graph = graph;
        this.label = label;
        this.visited = visited;
        this.neighbors = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edges>();
    }
    public void addNeighbour(Vertex vertex, Integer weight) {
        this.neighbors.add(vertex);
        Edges edge = new Edges(this, vertex, weight);
        this.edges.add(edge);
        this.hashEdges.put(vertex.getLabel(), edge);
        if (this.graph != null) {
            this.graph.setConnections(this.getLabel() + "_" + vertex.getLabel(), edge);
        }
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public ArrayList<Vertex> getNeighbors() {
        return this.neighbors;
    }
    public ArrayList<Edges> getEdges () {
        return this.edges;
    }
    public Tag getTag() {
        return tag;
    }
    public void setTag(Tag tag) {
        this.tag = tag;
    }
    public Edges getHashByKey(String key) {
        return this.hashEdges.get(key);
    }
    public HashMap<String, Edges> getHashEdges() {
        return hashEdges;
    }
    public void setHashEdges(HashMap<String, Edges> hashEdges) {
        this.hashEdges = hashEdges;
    }
    
    
}
